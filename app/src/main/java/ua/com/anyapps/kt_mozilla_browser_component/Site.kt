package ua.com.anyapps.kt_mozilla_browser_component

import android.graphics.drawable.Drawable

data class Site(
    val title: String,
    val param: Target,
    val loginPage: String,
    val thumb: Int,
    val accounts: ArrayList<String>,
    val success: Boolean,
    val id: Long = 0
)