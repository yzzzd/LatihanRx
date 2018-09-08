package com.nuryazid.latihanrx.obj

import com.google.gson.annotations.SerializedName

data class Team(
        @SerializedName("idTeam")
        var idTeam: String = "0",

        @SerializedName("strTeam")
        var strTeam: String? = null,

        @SerializedName("intFormedYear")
        var intFormedYear: String? = null,

        @SerializedName("strStadium")
        var strStadium: String? = null,

        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String? = null,

        @SerializedName("strTeamBadge")
        var strTeamBadge: String? = null,

        @SerializedName("strTeamJersey")
        var strTeamJersey: String? = null
)