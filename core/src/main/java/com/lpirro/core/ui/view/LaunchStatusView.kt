package com.lpirro.core.ui.view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.lpirro.core.R
import com.lpirro.core.databinding.ViewLaunchStatusBinding

class LaunchStatusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val binding =
        ViewLaunchStatusBinding.inflate(LayoutInflater.from(context))

    init {
        background = ContextCompat.getDrawable(context, R.drawable.status_bg)
        includeFontPadding = false
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
        updateColor(text.toString())
    }

    private fun updateColor(text: String?) {
        val textColor: Int
        val backgroundColor: Int

        with(text!!) {
            when {
                contains("flight", ignoreCase = true) -> {
                    textColor = context.getColorFromAttr(com.google.android.material.R.attr.colorOnPrimary)
                    backgroundColor = context.getColorFromAttr(com.google.android.material.R.attr.colorPrimary)
                }
                contains("go", ignoreCase = true) -> {
                    textColor = context.getColorFromAttr(R.attr.colorOnSuccessContainer)
                    backgroundColor = context.getColorFromAttr(R.attr.colorSuccessContainer)
                }
                contains("success", ignoreCase = true) -> {
                    textColor = context.getColorFromAttr(R.attr.colorOnSuccessContainer)
                    backgroundColor = context.getColorFromAttr(R.attr.colorSuccessContainer)
                }
                contains("failure", ignoreCase = true) -> {
                    textColor = context.getColorFromAttr(com.google.android.material.R.attr.colorOnErrorContainer)
                    backgroundColor = context.getColorFromAttr(com.google.android.material.R.attr.colorErrorContainer)
                }
                else -> {
                    textColor = context.getColorFromAttr(R.attr.colorOnWarningContainer)
                    backgroundColor = context.getColorFromAttr(R.attr.colorWarningContainer)
                }
            }
        }

        this.backgroundTintList = ColorStateList.valueOf(backgroundColor)
        this.setTextColor(textColor)
    }

    @ColorInt
    fun Context.getColorFromAttr(
        @AttrRes attrColor: Int,
        typedValue: TypedValue = TypedValue(),
        resolveRefs: Boolean = true
    ): Int {
        theme.resolveAttribute(attrColor, typedValue, resolveRefs)
        return typedValue.data
    }
}
