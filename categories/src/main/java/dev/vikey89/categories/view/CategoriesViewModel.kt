package dev.vikey89.categories.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.vikey89.categories.data.CategoriesRepository
import dev.vikey89.categories.data.Category

class CategoriesViewModel(
    private val categoryRepository: CategoriesRepository
) : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()

    val observerCategories: LiveData<List<Category>> = _categories

    fun load() {
        _categories.value = categoryRepository.getCategories()
    }
}