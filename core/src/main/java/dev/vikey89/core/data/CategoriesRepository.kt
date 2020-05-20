package dev.vikey89.core.data

interface CategoriesRepository {
    fun getCategories(): List<Category>
}