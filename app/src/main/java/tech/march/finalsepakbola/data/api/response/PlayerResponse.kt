package tech.march.finalsepakbola.data.api.response

import com.google.gson.annotations.SerializedName
import tech.march.finalsepakbola.model.api.Player

data class PlayerResponse(
        val player: List<Player>,
        @SerializedName("players")
        val players: List<Player>
)