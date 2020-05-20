package dev.vikey89.core.di

import android.app.Activity

fun Activity.provideCoreComponent(): CoreComponent {
    return if (this.applicationContext is CoreComponentProvider) {
        (this.applicationContext as CoreComponentProvider).provideCoreComponent()
    } else {
        throw IllegalStateException("Provide the application context which implement CoreComponentProvider")
    }
}