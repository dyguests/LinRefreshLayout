package com.fanhl.linrefreshlayout

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * 拉绳（下拉拉绳）RefreshLayout
 */
class DrawstringRefreshLayout @JvmOverloads constructor(
    @NonNull context: Context, @Nullable attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {
    private val drawstringView by lazy { DrawstringView(context) }

    init {
        addView(drawstringView)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        drawstringView.layout(
            100,
            100,
            200,
            200
        )
    }
}