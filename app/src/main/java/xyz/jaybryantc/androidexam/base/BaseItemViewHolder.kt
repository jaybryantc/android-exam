package xyz.jaybryantc.androidexam.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseItemViewHolder<T, VDB : ViewDataBinding>(binding: VDB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(data: T)
}