package com.fanhl.linrefreshlayout.sample

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class DefaultAdapter : BaseQuickAdapter<Int, BaseViewHolder>(R.layout.item_view) {
    override fun convert(helper: BaseViewHolder?, item: Int?) {
        helper?.itemView?.apply {  }
    }
}