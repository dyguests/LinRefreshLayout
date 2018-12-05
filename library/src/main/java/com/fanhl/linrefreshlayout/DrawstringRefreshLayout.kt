package com.fanhl.linrefreshlayout

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.core.view.NestedScrollingParent

/**
 * 拉绳（下拉拉绳）RefreshLayout
 *
 * see [androidx.swiperefreshlayout.widget.SwipeRefreshLayout]
 */
class DrawstringRefreshLayout @JvmOverloads constructor(
    @NonNull context: Context, @Nullable attrs: AttributeSet? = null
) : ViewGroup(context, attrs), NestedScrollingParent {
    /** the target of the gesture */
    private var mTarget: View? = null

    /** 下拉view */
    private val drawstringView by lazy { DrawstringView(context) }
    /** 下拉view的绘制顺序（之后统一改名） */
    private var mCircleViewIndex = -1

    init {
        isChildrenDrawingOrderEnabled = true

        ensureTarget()

        addView(drawstringView)
    }

    override fun getChildDrawingOrder(childCount: Int, i: Int): Int {
        return if (mCircleViewIndex < 0) {
            i
        } else if (i == childCount - 1) {
            // Draw the selected child last
            mCircleViewIndex
        } else if (i >= mCircleViewIndex) {
            // Move the children after the selected child earlier one
            i + 1
        } else {
            // Keep the children before the selected child the same
            i
        }
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
            0,
            0,
            width,
            200
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        ensureTarget()
        if (mTarget == null) {
            ensureTarget()
        }
        if (mTarget == null) {
            return
        }
        mTarget?.measure(
            View.MeasureSpec.makeMeasureSpec(
                measuredWidth - paddingLeft - paddingRight,
                View.MeasureSpec.EXACTLY
            ), View.MeasureSpec.makeMeasureSpec(
                measuredHeight - paddingTop - paddingBottom, View.MeasureSpec.EXACTLY
            )
        )
//        drawstringView.measure(
//            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY),
//            View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.EXACTLY)
//        )
        mCircleViewIndex = -1
        // Get the index of the circleview.
        for (index in 0 until childCount) {
            if (getChildAt(index) === drawstringView) {
                mCircleViewIndex = index
                break
            }
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        ensureTarget()

        return super.onInterceptTouchEvent(ev)
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