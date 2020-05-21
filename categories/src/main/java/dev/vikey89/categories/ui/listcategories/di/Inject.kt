package dev.vikey89.categories.ui.listcategories.di

import dev.vikey89.categories.di.component.DaggerCategoryComponent
import dev.vikey89.categories.ui.listcategories.ListCategoriesFragment
import dev.vikey89.core.di.provideCoreComponent

fun ListCategoriesFragment.inject() {

    DaggerCategoryComponent
        .builder()
        .coreComponent(provideCoreComponent())
        .build()
        .listCategoriresComponent()
        .create()
        .inject(this)
}