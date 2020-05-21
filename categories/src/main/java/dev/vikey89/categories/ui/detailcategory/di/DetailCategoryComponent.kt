package dev.vikey89.categories.ui.detailcategory.di

import dagger.Subcomponent
import dev.vikey89.categories.ui.detailcategory.DetailCategoryFragment

@Subcomponent(
    modules = [
        DetailCategoryModule::class
    ]
)
interface DetailCategoryComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailCategoryComponent
    }

    fun inject(fragment: DetailCategoryFragment)
}