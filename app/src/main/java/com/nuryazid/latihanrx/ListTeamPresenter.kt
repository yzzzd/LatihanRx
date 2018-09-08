package com.nuryazid.latihanrx

import com.google.gson.Gson
import com.nuryazid.latihanrx.api.APIService
import com.nuryazid.latihanrx.obj.Team
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class ListTeamPresenter (private val view: ListTeamView, private val apiService: APIService) {

    fun getTeams(nameLeague: String?) {

        apiService.teamList(nameLeague)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {
                            val responseString = it.string()
                            val jsonResponse = JSONObject(responseString)

                            val jsonTeamArray = jsonResponse.getJSONArray("teams")
                            val teamArrayResponse = Gson().fromJson(jsonTeamArray.toString(), Array<Team>::class.java).toList()

                            view.showTeam(teamArrayResponse)
                        },
                        {

                        }
                )

    }

}