package xyz.jaybryantc.androidexam.people.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseItemViewHolder
import xyz.jaybryantc.androidexam.base.BaseListAdapter
import xyz.jaybryantc.androidexam.data.model.Person
import xyz.jaybryantc.androidexam.databinding.ItemPersonBinding
import xyz.jaybryantc.androidexam.people.view.PeopleFragmentDirections

class PersonAdapter : BaseListAdapter<Person>() {

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
        BaseItemViewHolder<Person>(binding) {

        override fun onBind(data: Person) {
            binding.apply {
                root.setOnClickListener {
                    it.findNavController().navigate(PeopleFragmentDirections.actionPeopleFragmentToPersonFragment(data))
                }
                tvName.text = "${data.firstName} ${data.lastName}"
                tvMobileNumber.text = data.mobileNumber
                tvInitial.text = data.firstName.first().toString()
            }
        }
    }
}
