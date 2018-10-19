package tech.march.finalsepakbola.view.fragment.favorite

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.view.adapter.ViewPagerAdapter
import tech.march.finalsepakbola.view.fragment.favorite.match.FavoriteMatchFragment
import tech.march.finalsepakbola.view.fragment.favorite.team.FavoriteTeamFragment

class FavoriteFragment: Fragment() {

    private lateinit var mToolbar: Toolbar
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(mToolbar)

        mToolbar.setTitleTextColor(resources.getColor(R.color.colorWhite))

        mTabLayout.setTabTextColors(resources.getColorStateList(R.color.colorWhite))
        mTabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.colorWhite))
        setupViewPager(mViewPager)
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.view_pager_layout, container, false)

        mTabLayout = v.findViewById(R.id.tabs_layout)
        mToolbar = v.findViewById(R.id.toolbar_layout)
        mViewPager = v.findViewById(R.id.pager_layout)

        return v
    }

    companion object {
        fun favoritesInstance() : FavoriteFragment = FavoriteFragment()
    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = fragmentManager?.let { ViewPagerAdapter(it) }

        val matches = FavoriteMatchFragment.favoriteMatchesInstance()
        adapter?.addFragment(matches, getString(R.string.matches))

        val teams = FavoriteTeamFragment.favoriteTeamsInstance()
        adapter?.addFragment(teams, getString(R.string.teams))

        pager.adapter = adapter
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        menu?.clear()
        super.onPrepareOptionsMenu(menu)
    }
}
