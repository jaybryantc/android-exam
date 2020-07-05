package xyz.jaybryantc.androidexam.people.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseFragment
import xyz.jaybryantc.androidexam.databinding.FragmentPeopleBinding
import xyz.jaybryantc.androidexam.model.Person
import xyz.jaybryantc.androidexam.people.adapter.PersonAdapter
import xyz.jaybryantc.androidexam.people.contract.PeopleContract

@AndroidEntryPoint
class PeopleFragment : BaseFragment<FragmentPeopleBinding>(R.layout.fragment_people),
    PeopleContract.PeopleView {

    @Inject
    lateinit var presenter: PeopleContract.PeoplePresenter

    private var adapter = PersonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.setView(this)
        presenter.loadPeople()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    private fun initViews() {
        binding.apply {
            srlRefresh.setOnRefreshListener {
                presenter.loadPeople(true)
            }
            rvPeople.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = this@PeopleFragment.adapter
            }
        }
    }

    override fun showList(people: List<Person>) {
        binding.apply {
            srlRefresh.isRefreshing = false
            hasData = true
            adapter.updateItems(people)
        }
    }

    override fun showError() {
        binding.apply {
            srlRefresh.isRefreshing = false
            if (adapter.itemCount != 0) {
                Snackbar.make(binding.root, R.string.error_no_people, Snackbar.LENGTH_SHORT).show()
            } else {
                drawable = R.drawable.ic_error
                hasData = false
                caption = getString(R.string.error_no_people)
            }
        }
    }

    override fun showLoading() {
        binding.apply {
            srlRefresh.isRefreshing = true
            if (adapter.itemCount == 0) {
                drawable = R.drawable.ic_loading
                hasData = false
                caption = getString(R.string.loading)
            }
        }
    }
}
