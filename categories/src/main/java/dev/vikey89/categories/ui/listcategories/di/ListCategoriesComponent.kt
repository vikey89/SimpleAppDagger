package dev.vikey89.categories.ui.listcategories.di

import dagger.Subcomponent
import dev.vikey89.categories.di.CategoryScope
import dev.vikey89.categories.ui.listcategories.ListCategoriesFragment

@Subcomponent(
    modules = [
        ListCategoriesModule::class
    ]
)
interface ListCategoriesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ListCategoriesComponent
    }

    @CategoryScope
    fun inject(fragment: ListCategoriesFragment)
}