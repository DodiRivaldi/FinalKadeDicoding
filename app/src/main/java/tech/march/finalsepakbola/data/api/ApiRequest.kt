package tech.march.finalsepakbola.data.api

import java.net.URL

class ApiRequest {
    fun doRequest(url: String) : String {
        return URL(url).readText()
    }
}