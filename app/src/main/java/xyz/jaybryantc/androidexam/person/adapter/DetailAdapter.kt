package xyz.jaybryantc.androidexam.person.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseItemViewHolder
import xyz.jaybryantc.androidexam.base.BaseListAdapter
import xyz.jaybryantc.androidexam.databinding.ItemDetailBinding
import xyz.jaybryantc.androidexam.person.model.Detail

class DetailAdapter(details: List<Detail>) : BaseListAdapter<Detail, ItemDetailBinding>(details) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseItemViewHolder<Detail, ItemDetailBinding> {
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
        BaseItemViewHolder<Detail, ItemDetailBinding>(binding) {
        override fun onBind(detail: Detail) {
            binding.apply {
                tvInfoTitle.text = detail.infoTitle
            }
        }
    }
}
