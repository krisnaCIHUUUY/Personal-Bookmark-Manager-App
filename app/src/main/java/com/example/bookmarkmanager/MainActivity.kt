package com.example.bookmarkmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookmarkmanager.ui.theme.BookmarkManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookmarkManagerTheme {
                BookmarkApp()
            }
        }
    }
}

@Composable
fun BookmarkApp() {
    // Create navigation controller and shared ViewModel
    val navController = rememberNavController()
    val viewModel: BookmarkViewModel = viewModel()
    val bookmarks by viewModel.bookmarks.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val categories = bookmarks.map { it.category }.distinct().sorted()

    // NavHost swaps screens based on the current route
    NavHost(navController = navController, startDestination = BookmarkList) {
        composable<BookmarkList> {
            BookmarkListScreen(
                bookmarks = bookmarks,
                selectedCategory = selectedCategory,
                categories = categories,
                onCategorySelected = { viewModel.selectCategory(it) },
                onAddClick = { navController.navigate(AddBookmark) },
                onDeleteClick = { id -> viewModel.deleteBookmark(id) }
            )
        }
        composable<AddBookmark> {
            AddBookmarkScreen(
                onSave = { title, url, category ->
                    viewModel.addBookmark(title, url, category)
                    navController.popBackStack()
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}