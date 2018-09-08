package com.nuryazid.latihanrx

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import com.nuryazid.latihanrx.adapter.OnClickItem
import com.nuryazid.latihanrx.adapter.TeamAdapter
import com.nuryazid.latihanrx.api.APIService
import com.nuryazid.latihanrx.obj.Team
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnClickItem, ListTeamView {

    private var teamArray: ArrayList<Team> = ArrayList()
    private lateinit var teamAdapter: TeamAdapter
    private lateinit var presenter: ListTeamPresenter

    override fun onClick(view: View, position: Int) {

    }

    override fun showTeam(teams: List<Team>?) {
        if (teams == null) return
        teamArray.addAll(teams)
        teamAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ListTeamPresenter(this, APIService.create())

        teamAdapter = TeamAdapter(this, teamArray)
        teamAdapter.onClickItem = this
        rvTeam.layoutManager = LinearLayoutManager(this)
        rvTeam.adapter = teamAdapter

        presenter.getTeams("English Premier League")
    }

}