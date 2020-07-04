package xyz.jaybryantc.androidexam.person.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseFragment
import xyz.jaybryantc.androidexam.databinding.FragmentPersonBinding
import xyz.jaybryantc.androidexam.person.adapter.DetailAdapter
import xyz.jaybryantc.androidexam.person.contract.PersonContract
import xyz.jaybryantc.androidexam.person.model.Detail
import xyz.jaybryantc.androidexam.person.presenter.PersonPresenterImpl

class PersonFragment : BaseFragment<FragmentPersonBinding>(R.layout.fragment_person), PersonContract.PersonView {

    lateinit var presenter: PersonContract.PersonPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = PersonPresenterImpl(this)
        presenter.loadDetail()
    }

    override fun showPersonNameAsTitle(name: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = name
    }

    override fun showDetail(details: List<Detail>) {
        binding.apply {
            rvDetail.layoutManager = LinearLayoutManager(context)
            rvDetail.adapter = DetailAdapter(details)
        }
    }

    override fun getFirstNameLabel(): String = getString(R.string.first_name)

    override fun getLastNameLabel(): String = getString(R.string.last_name)

    override fun getBirthdayLabel(): String = getString(R.string.birthday)

    override fun getAgeLabel(): String = getString(R.string.age)

    override fun getEmailAddressLabel(): String = getString(R.string.email_address)

    override fun getMobileNumberLabel(): String = getString(R.string.mobile_number)

    override fun getAddressLabel(): String = getString(R.string.address)

    override fun getContactPersonLabel(): String = getString(R.string.contact_person)

    override fun getContactPersonPhoneNumber(): String = getString(R.string.contact_person_phone_number)
}
