package tech.march.finalsepakbola.data.api.response

import com.google.gson.annotations.SerializedName
import tech.march.finalsepakbola.model.api.Team

data class TeamResponse (
        @SerializedName("teams")
        val team: List<Team>
)