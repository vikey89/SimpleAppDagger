package dev.vikey89.categories.data

class CategoriesRepositoryImpl : CategoriesRepository {

    override fun getCategories() = (1 until 100).map { it.toCategory() }
}
