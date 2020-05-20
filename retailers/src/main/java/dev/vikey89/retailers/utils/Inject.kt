package dev.vikey89.retailers.utils

import dev.vikey89.core.di.provideCoreComponent
import dev.vikey89.retailers.di.component.DaggerRetailerComponent
import dev.vikey89.retailers.ui.RetailersActivity

fun RetailersActivity.inject() {

    DaggerRetailerComponent
        .builder()
        .coreComponent(provideCoreComponent())
        .build()
        .inject(this)
}