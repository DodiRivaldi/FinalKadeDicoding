package tech.march.finalsepakbola.view.fragment.team

import tech.march.finalsepakbola.model.api.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Team>?)
}