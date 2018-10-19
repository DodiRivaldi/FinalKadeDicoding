package tech.march.finalsepakbola.view.fragment.match

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.view.adapter.ViewPagerAdapter

class MatchFragment : Fragment() {

    private lateinit var mToolbar: Toolbar
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(mToolbar)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.view_pager_layout, container, false)

        mTabLayout = v.findViewById(R.id.tabs_layout)
        mToolbar = v.findViewById(R.id.toolbar_layout)
        mViewPager = v.findViewById(R.id.pager_layout)

        mToolbar.setTitleTextColor(resources.getColor(colorWhite))

        mTabLayout.setTabTextColors(resources.getColorStateList(colorWhite))
        mTabLayout.setSelectedTabIndicatorColor(resources.getColor(colorWhite))
        setupViewPager(mViewPager)
        mTabLayout.setupWithViewPager(mViewPager)

        return v
    }


    companion object {
        fun matchesInstance(): MatchFragment = MatchFragment()
    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = fragmentManager?.let { ViewPagerAdapter(it) }

        val past = PastMatchesFragment.pastInstance()
        adapter?.addFragment(past, getString(R.string.title_past_fragment))

        val next = NextMatchesFragment.nextIntance()
        adapter?.addFragment(next, getString(R.string.title_next_fragment))

        pager?.adapter = adapter
    }
}
