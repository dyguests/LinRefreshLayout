package com.fanhl.linrefreshlayout.sample

import android.annotation.SuppressLint
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_view.view.*
import org.jetbrains.anko.imageResource

class DefaultAdapter : BaseQuickAdapter<Int, BaseViewHolder>(R.layout.item_view) {
    @SuppressLint("SetTextI18n")
    override fun convert(helper: BaseViewHolder?, item: Int?) {
        helper?.itemView?.apply {
            img_cover.imageResource = R.mipmap.ic_launcher
            tv_title.text = "Title$item"
            tv_content.text = "Content$item ${System.currentTimeMillis()}"
        }
    }
}