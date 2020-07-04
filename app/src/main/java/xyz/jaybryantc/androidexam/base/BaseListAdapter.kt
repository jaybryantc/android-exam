package xyz.jaybryantc.androidexam.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T, VDH : ViewDataBinding>(private val data: List<T>) :
    RecyclerView.Adapter<BaseItemViewHolder<T, VDH>>() {

    override fun onBindViewHolder(holder: BaseItemViewHolder<T, VDH>, position: Int) {
        if (data.isNotEmpty()) {
            holder.onBind(data[position])
        }
    }

    override fun getItemCount(): Int = data.size
}
