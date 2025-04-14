package app.webview.errorpage.network

import app.webview.errorpage.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getItems(): List<Item>
}