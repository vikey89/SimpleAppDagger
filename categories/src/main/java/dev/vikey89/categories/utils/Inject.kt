package dev.vikey89.categories.utils

import dev.vikey89.categories.di.component.DaggerCategoryComponent
import dev.vikey89.categories.ui.CategoriesActivity
import dev.vikey89.core.di.provideCoreComponent

fun CategoriesActivity.inject() {

    DaggerCategoryComponent
        .builder()
        .coreComponent(provideCoreComponent())
        .build()
        .inject(this)
}