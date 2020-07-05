package xyz.jaybryantc.androidexam.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T> : RecyclerView.Adapter<BaseItemViewHolder<T>>() {
    private val data: MutableList<T> = mutableListOf()

    override fun onBindViewHolder(holder: BaseItemViewHolder<T>, position: Int) {
        if (data.isNotEmpty()) {
            holder.onBind(data[position])
        }
    }

    @SuppressWarnings("unused")
    fun addItems(items: List<T>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun updateItems(items: List<T>) {
        data.removeAll { true }
        addItems(items)
    }

    override fun getItemCount(): Int = data.size
}
