package com.fanhl.linrefreshlayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * 拉绳（下拉拉绳）RefreshLayout
 */
class DrawstringRefreshLayout @JvmOverloads constructor(
    @NonNull context: Context, @Nullable attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {
    /** the target of the gesture */
    private var mTarget: View? = null

    /** 下拉view */
    private val drawstringView by lazy { DrawstringView(context) }

    init {
        ensureTarget()
        addView(drawstringView)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val width = measuredWidth
        val height = measuredHeight
        if (childCount == 0) {
            return
        }
        if (mTarget == null) {
            ensureTarget()
        }
        if (mTarget == null) {
            return
        }

        val child = mTarget
        val childLeft = paddingLeft
        val childTop = paddingTop
        val childWidth = width - paddingLeft - paddingRight
        val childHeight = height - paddingTop - paddingBottom
        child?.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight)

        drawstringView.layout(
            100,
            100,
            200,
            200
        )
    }

    private fun ensureTarget() {
        if (mTarget == null) {
            for (i in 0 until childCount) {
                val child = getChildAt(i)
                if (child != drawstringView) {
                    mTarget = child
                    break
                }
            }
        }
    }
}