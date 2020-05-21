package dev.vikey89.categories.ui.detailcategory.di

import dev.vikey89.categories.di.component.DaggerCategoryComponent
import dev.vikey89.categories.ui.detailcategory.DetailCategoryFragment
import dev.vikey89.core.di.provideCoreComponent

fun DetailCategoryFragment.inject() {

    DaggerCategoryComponent
        .builder()
        .coreComponent(provideCoreComponent())
        .build()
        .detailCategoryComponent()
        .create()
        .inject(this)
}