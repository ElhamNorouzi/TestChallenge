package app.webview.errorpage.repository

import app.webview.errorpage.model.Item
import app.webview.errorpage.network.ApiService

class ItemRepository(private val apiService: ApiService) {
    suspend fun getItems(): List<Item> = apiService.getItems()
}
