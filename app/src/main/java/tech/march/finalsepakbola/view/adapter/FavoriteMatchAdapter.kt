package tech.march.finalsepakbola.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import tech.march.finalsepakbola.model.db.MatchDb
import tech.march.finalsepakbola.view.holder.MatchHolder
import tech.march.finalsepakbola.view.ui.MatchUi

class FavoriteMatchAdapter (private val favoriteMatches: List<MatchDb>,
                            private val listener: (MatchDb) -> Unit):
        RecyclerView.Adapter<MatchHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        return MatchHolder(MatchUi().createView(AnkoContext.
                create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: MatchHolder, position: Int) {
        holder.bindFavorite(favoriteMatches[position], listener)
    }

    override fun getItemCount(): Int = favoriteMatches.size
}