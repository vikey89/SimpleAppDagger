package dev.vikey89.categories.data

data class Category(val id: Int, val name: String)

fun Int.toCategory() = Category(this, "Category $this")