package dev.vikey89.core.data

class CategoriesRepositoryImpl : CategoriesRepository {

    override fun getCategories() = (1 until 100).map { it.toCategory() }
}
