package app.webview.errorpage.model

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val price: Double,
    val isAvailable: Boolean = true
)

