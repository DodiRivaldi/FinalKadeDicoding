package tech.march.finalsepakbola.view.fragment.favorite.match


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.model.db.MatchDb
import tech.march.finalsepakbola.util.db
import tech.march.finalsepakbola.util.gone
import tech.march.finalsepakbola.view.adapter.FavoriteMatchAdapter
import tech.march.finalsepakbola.view.ui.FavoriteMatchUi

class FavoriteMatchFragment : Fragment() {

    private var favoMatch: MutableList<MatchDb> = mutableListOf()
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: FavoriteMatchAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initId()

        adapter = FavoriteMatchAdapter(favoMatch) {
            ctx.startActivity<DetailMatchesActivity>(getString(item_eventdetail_id)
                    to "${it.eventId}",
                    getString(item_home_id) to "${it.homeTeamId}",
                    getString(item_away_id) to "${it.awayTeamId}")
        }

        recyclerView.adapter = adapter
        showFavorite()
        swipeRefreshLayout.onRefresh {
            favoMatch.clear()
            showFavorite()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FavoriteMatchUi().createView(AnkoContext.create(ctx, this))
    }

    companion object {
        fun favoriteMatchesInstance(): FavoriteMatchFragment = FavoriteMatchFragment()
    }

    private fun initId() {
        swipeRefreshLayout = find(R.id.swipeRefreshFavoMatch)
        recyclerView = find(R.id.rvFavoMatch)
        progressBar = find(R.id.pbFavoMatches)
    }

    private fun showFavorite() {
        context?.db?.use {
            swipeRefreshLayout.isRefreshing = false
            progressBar.gone()
            val result = select(MatchDb.TABLE_MATCHES)
            val favorite = result.parseList(classParser<MatchDb>())
            favoMatch.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}
