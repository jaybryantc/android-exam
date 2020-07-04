package xyz.jaybryantc.androidexam.person.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.jaybryantc.androidexam.R
import xyz.jaybryantc.androidexam.base.BaseFragment
import xyz.jaybryantc.androidexam.databinding.FragmentPersonBinding
import xyz.jaybryantc.androidexam.person.adapter.DetailAdapter
import xyz.jaybryantc.androidexam.person.model.Detail

class PersonFragment : BaseFragment<FragmentPersonBinding>(R.layout.fragment_person) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Coco Martin"
        val details = mutableListOf<Detail>(
            Detail(getString(R.string.first_name), ""),
            Detail(getString(R.string.last_name), ""),
            Detail(getString(R.string.birthday), ""),
            Detail(getString(R.string.age), ""),
            Detail(getString(R.string.email_address), ""),
            Detail(getString(R.string.mobile_number), ""),
            Detail(getString(R.string.address), ""),
            Detail(getString(R.string.contact_person), ""),
            Detail(getString(R.string.contact_person_phone_number), "")
        )
        binding.apply {
            rvDetail.layoutManager = LinearLayoutManager(context)
            rvDetail.adapter = DetailAdapter(details)
        }
    }
}
