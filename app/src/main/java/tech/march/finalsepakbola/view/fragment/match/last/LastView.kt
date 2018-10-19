package tech.march.finalsepakbola.view.fragment.match.last

import tech.march.finalsepakbola.model.api.Match

interface LastView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Match>?)
    fun errorMessage(message: String?)
}