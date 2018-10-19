package tech.march.finalsepakbola.view.fragment.favorite.team


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
import tech.march.finalsepakbola.model.db.TeamDb
import tech.march.finalsepakbola.util.db
import tech.march.finalsepakbola.util.gone
import tech.march.finalsepakbola.view.adapter.FavoriteTeamAdapter
import tech.march.finalsepakbola.view.ui.FavoriteTeamUi

class FavoriteTeamFragment : Fragment() {

    private var favoTeams: MutableList<TeamDb> = mutableListOf()
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: FavoriteTeamAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initId()

        adapter = FavoriteTeamAdapter(favoTeams) {
            ctx.startActivity<DetailTeamsActivity>(getString(item_teamdetail_id) to
                    "${it.teamId}")
        }

        recyclerView.adapter = adapter
        showFavorite()
        swipeRefreshLayout.onRefresh {
            favoTeams.clear()
            showFavorite()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FavoriteTeamUi().createView(AnkoContext.create(ctx, this))
    }

    companion object {
        fun favoriteTeamsInstance(): FavoriteTeamFragment = FavoriteTeamFragment()
    }

    private fun initId() {
        swipeRefreshLayout = find(R.id.swipeRefreshFavoTeams)
        recyclerView = find(R.id.rvFavoTeams)
        progressBar = find(R.id.pbFavoTeams)
    }

    private fun showFavorite() {
        context?.db?.use {
            swipeRefreshLayout.isRefreshing = false
            progressBar.gone()
            val result = select(TeamDb.TABLE_TEAMS)
            val favorite = result.parseList(classParser<TeamDb>())
            favoTeams.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}
