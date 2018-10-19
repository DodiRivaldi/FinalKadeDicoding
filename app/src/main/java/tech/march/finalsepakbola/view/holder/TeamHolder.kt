package tech.march.finalsepakbola.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.model.api.Team
import tech.march.finalsepakbola.model.db.TeamDb

class TeamHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(R.id.team_badge)
    private val teamName: TextView = view.find(R.id.team_name)

    fun bindItem(teams: Team) {
        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailTeamsActivity>(
                    ctx.getString(item_teamdetail_id) to teams.teamId)
        }
    }

    fun bindFavorite(favorite: TeamDb, listener: (TeamDb) -> Unit) {
        Picasso.get().load(favorite.badgeTeam).into(teamBadge)
        teamName.text = favorite.teamName

        itemView.onClick {
            listener(favorite)
        }
    }
}