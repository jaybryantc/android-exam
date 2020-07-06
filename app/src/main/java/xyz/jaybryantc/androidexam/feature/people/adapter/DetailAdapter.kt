package xyz.jaybryantc.androidexam.feature.people.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseItemViewHolder
import xyz.jaybryantc.androidexam.base.BaseListAdapter
import xyz.jaybryantc.androidexam.databinding.ItemDetailBinding
import xyz.jaybryantc.androidexam.model.Detail

class DetailAdapter : BaseListAdapter<Detail>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseItemViewHolder<Detail> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemDetailBinding>(
            inflater,
            R.layout.item_detail,
            parent,
            false
        )
        return DetailItemViewHolder(binding)
    }

    inner class DetailItemViewHolder(private val binding: ItemDetailBinding) :
        BaseItemViewHolder<Detail>(binding) {
        override fun onBind(data: Detail) {
            binding.apply {
                tvInfoTitle.text = data.infoTitle
                tvInfo.text = data.info
            }
        }
    }
}
