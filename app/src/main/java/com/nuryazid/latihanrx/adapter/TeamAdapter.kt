package com.nuryazid.latihanrx.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.nuryazid.latihanrx.R
import com.nuryazid.latihanrx.obj.Team
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_team.view.*
import java.util.*

/**
 * Created by nuryazid on 8/28/18.
 */

class TeamAdapter(private val context: Context, private val items: ArrayList<Team>) : RecyclerView.Adapter<TeamViewHolder>() {

    var onClickItem: OnClickItem? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(context).inflate(R.layout.item_team, parent, false))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {

        try {
            holder.tvTeamName.text = items[position].strTeam
            Picasso.get().load(items[position].strTeamBadge?:"null").into(holder.ivTeam)
            holder.itemView.setOnClickListener {
                if (onClickItem != null) {
                    onClickItem?.onClick(it, position)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTeamName: TextView = view.tvTeamName
    val ivTeam: ImageView = view.ivTeam
}

interface OnClickItem {
    fun onClick(view: View, position: Int)
}