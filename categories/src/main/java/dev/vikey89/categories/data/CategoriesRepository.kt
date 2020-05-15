package dev.vikey89.categories.data

interface CategoriesRepository {
    fun getCategories(): List<Category>
}