package com.example.bookmarkmanager

data class Bookmark (
    val id: String = java.util.UUID.randomUUID().toString(),
    val title: String,
    val url: String,
    val category: String
)