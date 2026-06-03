package com.example.bookmarkmanager

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine

class BookmarkViewModel: ViewModel() {
    private val _bookmarks = MutableStateFlow<List<Bookmark>>(
        listOf(
            Bookmark(title = "Kotlin Docs", url = "https://kotlinlang.org", category = "Development"),
            Bookmark(title = "Android Developers", url = "https://developer.android.com", category = "Development"),
            Bookmark(title = "Compose Samples", url = "https://github.com/android/compose-samples", category = "Learning")
        )
    )
    val bookmarks: StateFlow<List<Bookmark>> = _bookmarks.asStateFlow()

    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: StateFlow<String?> = _selectedCategory.asStateFlow()

    val filteredBookmarks: StateFlow<List<Bookmark>> = MutableStateFlow(emptyList<Bookmark>()).also { flow ->
        // Note: In a real app you would use combine() in a coroutine scope.
        // For simplicity, filtering is done in the composable using derivedStateOf.
    }

    val categories: StateFlow<List<String>>
        get() = MutableStateFlow(
            _bookmarks.value.map { it.category }.distinct().sorted()
        )

    fun addBookmark(title: String , url: String, category: String){
        val newBookmark = Bookmark(title = title, url = url, category = category);

        _bookmarks.value = _bookmarks.value + newBookmark
    }

    fun deleteBookmark(id: String){
        _bookmarks.value = _bookmarks.value.filter { it.id != id }
    }

    fun selectCategory(category: String?) {
        _selectedCategory.value = category
    }
}