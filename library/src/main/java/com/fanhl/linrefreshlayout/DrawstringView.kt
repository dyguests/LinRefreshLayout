package com.fanhl.linrefreshlayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import androidx.annotation.Nullable

/**
 * 拉绳View
 */
class DrawstringView(
    context: Context, @Nullable attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint by lazy {
        Paint().apply {
            color = Color.BLACK
        }
    }

    private var mListener: Animation.AnimationListener? = null

    private var scrollOffset = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.RED)
        canvas.drawCircle(width / 2f, scrollOffset, 10f, paint)
    }

    /**
     * 这里设置下拉的偏移值
     */
    fun setPullDownOffset(scrollOffset: Float) {
        this.scrollOffset = scrollOffset
        postInvalidate()
    }

    fun setAnimationListener(listener: Animation.AnimationListener?) {
        mListener = listener
    }
}