package com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions

import android.content.Context
import android.os.Handler
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageUrl(
    context: Context,
    url: String
) {
        Handler().postDelayed({
            context.runOnUiThread {
                Glide
                    .with(this)
                    .asDrawable()
                    .load(url)
                    .apply(RequestOptions().override(context.dpToPx(100.0f), context.dpToPx(100.0f)))
                    .into(this@setImageUrl)
            }
        }, 0)
}