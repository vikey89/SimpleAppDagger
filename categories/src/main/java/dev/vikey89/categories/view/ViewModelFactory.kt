package dev.vikey89.categories.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.vikey89.categories.data.CategoriesRepositoryImpl

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            return createCategoriesViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

    private fun createCategoriesViewModel(): CategoriesViewModel {
        return CategoriesViewModel(categoryRepository = CategoriesRepositoryImpl())
    }
}