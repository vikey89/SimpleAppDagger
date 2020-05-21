package dev.vikey89.core.di

import android.app.Activity
import androidx.fragment.app.Fragment

fun Activity.provideCoreComponent(): CoreComponent {
    return if (this.applicationContext is CoreComponentProvider) {
        (this.applicationContext as CoreComponentProvider).provideCoreComponent()
    } else {
        throw IllegalStateException("Provide the application context which implement CoreComponentProvider")
    }
}

fun Fragment.provideCoreComponent(): CoreComponent {
    return if (this.activity?.applicationContext is CoreComponentProvider) {
        (this.activity?.applicationContext as CoreComponentProvider).provideCoreComponent()
    } else {
        throw IllegalStateException("Provide the application context which implement CoreComponentProvider")
    }
}