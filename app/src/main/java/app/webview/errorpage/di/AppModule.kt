package app.webview.errorpage.di

import app.webview.errorpage.network.ApiService
import app.webview.errorpage.repository.ItemRepository
import app.webview.errorpage.viewmodel.ItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/") // Replace with your API
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single { ItemRepository(get()) }
    viewModel { ItemViewModel(get()) }
}
