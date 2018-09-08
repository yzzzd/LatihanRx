package com.nuryazid.latihanrx.obj

import com.google.gson.annotations.SerializedName

data class TeamResponse (
    @SerializedName("teams")
    val teams: List<Team>? = null
)