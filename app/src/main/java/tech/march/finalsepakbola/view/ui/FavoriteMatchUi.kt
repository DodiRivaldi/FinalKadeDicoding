package tech.march.finalsepakbola.view.ui

import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.util.ItemDecoration
import tech.march.finalsepakbola.view.fragment.favorite.match.FavoriteMatchFragment

class FavoriteMatchUi : AnkoComponent<FavoriteMatchFragment> {

    override fun createView(ui: AnkoContext<FavoriteMatchFragment>) = with(ui) {
        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            swipeRefreshLayout {
                id = R.id.swipeRefreshFavoMatch
                setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                recyclerView {
                    lparams(width = matchParent, height = wrapContent)
                    id = R.id.rvFavoMatch
                    layoutManager = LinearLayoutManager(ctx)
                    addItemDecoration(ItemDecoration(8))
                }
            }

            progressBar {
                id = R.id.pbFavoMatches
            }.lparams {
                centerHorizontally()
            }
        }
    }
}