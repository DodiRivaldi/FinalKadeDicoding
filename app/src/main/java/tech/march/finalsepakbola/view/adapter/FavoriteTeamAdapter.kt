package tech.march.finalsepakbola.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import tech.march.finalsepakbola.model.db.TeamDb
import tech.march.finalsepakbola.view.holder.TeamHolder
import tech.march.finalsepakbola.view.ui.TeamUi

class FavoriteTeamAdapter(private val favoriteMatches: List<TeamDb>,
                          private val listener: (TeamDb) -> Unit):
        RecyclerView.Adapter<TeamHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(TeamUi().createView(AnkoContext.
                create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bindFavorite(favoriteMatches[position], listener)
    }

    override fun getItemCount(): Int = favoriteMatches.size
}