package tech.march.finalsepakbola.view.activity.home

import android.app.ActionBar
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.view.fragment.favorite.FavoriteFragment
import tech.march.finalsepakbola.view.fragment.match.MatchFragment
import tech.march.finalsepakbola.view.fragment.team.TeamFragment

class HomeActivity : AppCompatActivity() {
    lateinit var toolBar: ActionBar
    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HomeUi().setContentView(this)

        bottomNavigation = find(R.id.navigation)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            addFragment(MatchFragment.matchesInstance())
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_matches -> {
                val matchFragment = MatchFragment.matchesInstance()
                addFragment(matchFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_teams -> {
                val teamsFragment = TeamFragment.teamsInstance()
                addFragment(teamsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorites -> {
                val favoFragment = FavoriteFragment.favoritesInstance()
                addFragment(favoFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
