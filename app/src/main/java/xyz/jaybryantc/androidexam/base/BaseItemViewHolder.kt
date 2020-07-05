package xyz.jaybryantc.androidexam.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseItemViewHolder<T>(binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(data: T)
}
