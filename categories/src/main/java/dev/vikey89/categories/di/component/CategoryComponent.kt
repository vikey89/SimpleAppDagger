package dev.vikey89.categories.di.component

import dagger.Component
import dev.vikey89.categories.di.CategoryScope
import dev.vikey89.categories.di.module.CategoryModule
import dev.vikey89.categories.ui.CategoryActivity
import dev.vikey89.categories.ui.detailcategory.di.DetailCategoryComponent
import dev.vikey89.categories.ui.listcategories.di.ListCategoriesComponent
import dev.vikey89.core.di.CoreComponent

@CategoryScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        CategoryModule::class,
        CategorySubComponents::class
    ]
)
interface CategoryComponent {

    fun inject(activity: CategoryActivity)

    fun listCategoriresComponent(): ListCategoriesComponent.Factory

    fun detailCategoryComponent(): DetailCategoryComponent.Factory

}