package xyz.jaybryantc.androidexam.people.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseFragment
import xyz.jaybryantc.androidexam.databinding.FragmentPeopleBinding
import xyz.jaybryantc.androidexam.people.adapter.PersonAdapter

class PeopleFragment : BaseFragment<FragmentPeopleBinding>(R.layout.fragment_people) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvPeople.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = PersonAdapter(emptyList())
            }
            hasData = true
            caption = getString(R.string.loading)
            srlRefresh.isRefreshing = true
        }
    }
}
