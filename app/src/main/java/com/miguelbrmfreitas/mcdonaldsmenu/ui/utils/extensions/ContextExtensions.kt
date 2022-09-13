package com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.TypedValue

fun Context.runOnUiThread(f: Context.() -> Unit) {
    when {
        Looper.getMainLooper() === Looper.myLooper() -> f()
        else -> {
            Handler(Looper.getMainLooper()).post { f() }
        }
    }
}

fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dp,
    resources.displayMetrics
).toInt()