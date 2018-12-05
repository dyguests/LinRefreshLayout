package com.fanhl.linrefreshlayout.sample.widget

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout

class ChildDrawingOrderTestView @JvmOverloads constructor(
    @NonNull context: Context, @Nullable attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    init {
        isChildrenDrawingOrderEnabled = true
    }

    override fun getChildDrawingOrder(childCount: Int, i: Int): Int {
        return 1-i
    }
}