package xyz.jaybryantc.androidexam.feature.people.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseItemViewHolder
import xyz.jaybryantc.androidexam.base.BaseListAdapter
import xyz.jaybryantc.androidexam.databinding.ItemPersonBinding
import xyz.jaybryantc.androidexam.feature.people.view.PeopleFragmentDirections
import xyz.jaybryantc.androidexam.model.Person

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
            data.run {
                binding.apply {
                    root.run {
                        setOnClickListener {
                            it.findNavController()
                                .navigate(PeopleFragmentDirections.actionPeopleFragmentToPersonFragment(data))
                        }
                        val name = context.getString(
                            R.string.template_name,
                            firstName ?: "",
                            lastName ?: ""
                        )
                        tvName.text = name
                    }
                    tvMobileNumber.text = mobileNumber ?: ""
                    tvInitial.text = firstName?.first()?.toString() ?: ""
                }
            }
        }
    }
}
