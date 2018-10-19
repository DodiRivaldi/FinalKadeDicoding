package tech.march.finalsepakbola.view.fragment.match.next

import tech.march.finalsepakbola.model.api.Match

interface NextView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Match>?)
    fun errorMessage(message: String?)
}