package tech.march.finalsepakbola.view.activity.home

import android.support.design.R.attr.colorPrimary
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.design.bottomNavigationView
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.R.color.*
import tech.march.finalsepakbola.view.activity.home.HomeActivity

class HomeUi : AnkoComponent<HomeActivity> {

    override fun createView(ui: AnkoContext<HomeActivity>) = with(ui) {
        relativeLayout {
            lparams(width = matchParent, height = matchParent)

            frameLayout {
                id = R.id.container
            }.lparams(width = matchParent, height = matchParent) {
                above(R.id.bottom_layout)
            }

            linearLayout {
                id = R.id.bottom_layout
                orientation = LinearLayout.VERTICAL

                view {
                    background = resources.getDrawable(R.drawable.shadow)
                }.lparams(height = dip(4), width = matchParent)

                bottomNavigationView {
                    id = R.id.navigation
                    inflateMenu(R.menu.navigation)
                    itemBackgroundResource = colorWhite
                    backgroundColor = android.R.attr.windowBackground
                    itemTextColor = resources.getColorStateList(colorPrimary)
                    itemIconTintList = resources.getColorStateList(colorPrimaryDark)
                }.lparams(width = matchParent, height = wrapContent) {
                    marginEnd = dip(0)
                    marginStart = dip(0)
                }
            }.lparams(width = matchParent, height = wrapContent) {
                alignParentBottom()
            }
        }
    }
}