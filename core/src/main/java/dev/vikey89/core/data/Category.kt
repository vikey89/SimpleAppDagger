package dev.vikey89.core.data

data class Category(val id: Int, val name: String)

fun Int.toCategory() = Category(this, "Category $this")