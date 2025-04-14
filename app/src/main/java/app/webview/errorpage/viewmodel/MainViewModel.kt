package app.webview.errorpage.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.webview.errorpage.model.Item
import app.webview.errorpage.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository) : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    fun loadItems() {
        viewModelScope.launch {
            try {
                _items.value = repository.getItems()
            } catch (e: Exception) {
                Log.e("ItemViewModel", "Failed to load items", e)
            }
        }
    }
}

