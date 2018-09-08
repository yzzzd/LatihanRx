package com.nuryazid.latihanrx.api

import com.nuryazid.latihanrx.BuildConfig
import com.nuryazid.latihanrx.obj.TeamResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by nuryazid on 8/28/18.
 */

interface APIService {

    companion object Factory {
        fun create(): APIService {

            val client = OkHttpClient.Builder()
                    .readTimeout(90, TimeUnit.SECONDS)
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

            return retrofit.create(APIService::class.java)
        }
    }

    @GET("search_all_teams.php")
    fun teamList(
            @Query("l") league: String?
    ): Observable<ResponseBody>
}