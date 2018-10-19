package tech.march.finalsepakbola.data.api.response

import com.google.gson.annotations.SerializedName
import tech.march.finalsepakbola.model.api.Match

data class MatchResponse(
        @SerializedName("events")
        val event: List<Match>,
        @SerializedName("event")
        val searchEvent: List<Match>
)