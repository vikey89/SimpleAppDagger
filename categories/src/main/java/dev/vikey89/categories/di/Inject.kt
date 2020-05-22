package dev.vikey89.categories.di

import dev.vikey89.categories.di.component.DaggerCategoryComponent
import dev.vikey89.categories.ui.CategoryActivity
import dev.vikey89.core.di.provideCoreComponent

fun CategoryActivity.inject() {

    DaggerCategoryComponent
        .builder()
        .coreComponent(provideCoreComponent())
        .build()
        .inject(this)
}