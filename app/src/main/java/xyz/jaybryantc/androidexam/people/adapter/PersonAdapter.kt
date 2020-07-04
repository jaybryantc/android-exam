package xyz.jaybryantc.androidexam.people.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseItemViewHolder
import xyz.jaybryantc.androidexam.base.BaseListAdapter
import xyz.jaybryantc.androidexam.databinding.ItemPersonBinding

class PersonAdapter(data: List<String>) :
    BaseListAdapter<String, ItemPersonBinding>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPersonBinding>(
            inflater,
            R.layout.item_person,
            parent,
            false
        )
        return PersonItemViewHolder(binding)
    }
    
    inner class PersonItemViewHolder(private val binding: ItemPersonBinding) :
        BaseItemViewHolder<String, ItemPersonBinding>(binding) {

        override fun onBind(data: String) {
            binding.apply {
                root.setOnClickListener {
                    it.findNavController().navigate(R.id.action_peopleFragment_to_personFragment)
                }
                tvName.text = "Coco Martin"
                tvMobileNumber.text = "09122121211"
                tvInitial.text = "C"
            }
        }
    }
}
