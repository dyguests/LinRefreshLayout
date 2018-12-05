package com.fanhl.linrefreshlayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

/**
 * 拉绳View
 */
class DrawstringView(
    context: Context, @Nullable attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.RED)
    }

    /**
     * 这里设置下拉的偏移值
     */
    fun setPullDownOffset(offset: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}