package xyz.jaybryantc.androidexam.person.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseFragment
import xyz.jaybryantc.androidexam.databinding.FragmentPersonBinding
import xyz.jaybryantc.androidexam.person.adapter.DetailAdapter
import xyz.jaybryantc.androidexam.person.contract.PersonContract
import xyz.jaybryantc.androidexam.person.model.Detail
import javax.inject.Inject

@AndroidEntryPoint
class PersonFragment : BaseFragment<FragmentPersonBinding>(R.layout.fragment_person),
    PersonContract.PersonView {

    @Inject
    lateinit var presenter: PersonContract.PersonPresenter

    private val adapter = DetailAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.setView(this)
        arguments?.let {
            val args = PersonFragmentArgs.fromBundle(it)
            presenter.loadDetail(args.person)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroy()
    }

    private fun initViews() {
        binding.apply {
            rvDetail.layoutManager = LinearLayoutManager(context)
            rvDetail.adapter = this@PersonFragment.adapter
        }
    }

    override fun showPersonNameAsTitle(name: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = name
    }

    override fun showDetail(details: List<Detail>) {
        adapter.addItems(details)
    }

    override fun getFirstNameLabel(): String = getString(R.string.first_name)

    override fun getLastNameLabel(): String = getString(R.string.last_name)

    override fun getBirthdayLabel(): String = getString(R.string.birthday)

    override fun getAgeLabel(): String = getString(R.string.age)

    override fun getEmailAddressLabel(): String = getString(R.string.email_address)

    override fun getMobileNumberLabel(): String = getString(R.string.mobile_number)

    override fun getAddressLabel(): String = getString(R.string.address)

    override fun getContactPersonLabel(): String = getString(R.string.contact_person)

    override fun getContactPersonPhoneNumber(): String =
        getString(R.string.contact_person_phone_number)
}
