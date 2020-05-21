package dev.vikey89.categories.di.component

import dagger.Module
import dev.vikey89.categories.ui.detailcategory.di.DetailCategoryComponent
import dev.vikey89.categories.ui.listcategories.di.ListCategoriesComponent

@Module(
    subcomponents = [
        ListCategoriesComponent::class,
        DetailCategoryComponent::class
    ]
)
class CategorySubComponents