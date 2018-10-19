package tech.march.finalsepakbola.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import tech.march.finalsepakbola.R
import tech.march.finalsepakbola.model.api.Match
import tech.march.finalsepakbola.model.db.MatchDb
import java.text.SimpleDateFormat
import java.util.*

class MatchHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val timeSchedule: TextView = view.find(R.id.time_schedule)
    private val homeTeam: TextView = view.find(R.id.tvHomeTeam)
    private val homeScore: TextView = view.find(R.id.tvHomeScore)
    private val awayScore: TextView = view.find(R.id.tvAwayScore)
    private val awayTeam: TextView = view.find(R.id.tvAwayTeam)

    fun bindItem(match: Match) {

        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(match.dateEvent)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = match.strHomeTeam
        homeScore.text = match.intHomeScore
        awayScore.text = match.intAwayScore
        awayTeam.text = match.strAwayTeam

        val ctx = itemView.context

        itemView.setOnClickListener {
            ctx.startActivity<DetailMatchesActivity>(
                    ctx.getString(R.string.item_eventdetail_id) to match.idEvent,
                    ctx.getString(R.string.item_home_id) to match.idHomeTeam,
                    ctx.getString(R.string.item_away_id) to match.idAwayTeam)
        }
    }

    fun bindFavorite(favoriteMatches: MatchDb, listener:(MatchDb) -> Unit) {
        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(favoriteMatches.eventTime)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = favoriteMatches.homeTeam
        homeScore.text = favoriteMatches.homeScore
        awayScore.text = favoriteMatches.awayScore
        awayTeam.text = favoriteMatches.awayScore

        itemView.onClick {
            listener(favoriteMatches)
        }

    }
}