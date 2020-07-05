package xyz.jaybryantc.androidexam.feature.people.presenter

import xyz.jaybryantc.androidexam.feature.people.contract.DetailContract
import xyz.jaybryantc.androidexam.model.Detail
import xyz.jaybryantc.androidexam.model.Person
import xyz.jaybryantc.androidexam.util.format
import xyz.jaybryantc.androidexam.util.getElapsedYears

class DetailPresenterImpl : DetailContract.DetailPresenter {
    private var detailView: DetailContract.DetailView? = null

    override fun loadDetail(person: Person) {
        detailView?.apply {
            person.run {
                val first = firstName ?: ""
                val last = lastName ?: ""
                showPersonNameAsTitle("$first $last")
                val details = mutableListOf(
                    Detail(
                        getFirstNameLabel(),
                        first
                    ),
                    Detail(
                        getLastNameLabel(),
                        last
                    ),
                    Detail(
                        getBirthdayLabel(),
                        birthday?.format() ?: ""
                    ),
                    Detail(
                        getAgeLabel(),
                        birthday?.getElapsedYears()?.toString() ?: ""
                    ),
                    Detail(
                        getEmailAddressLabel(),
                        emailAddress ?: ""
                    ),
                    Detail(
                        getMobileNumberLabel(),
                        mobileNumber ?: ""
                    ),
                    Detail(
                        getAddressLabel(),
                        address ?: ""
                    ),
                    Detail(
                        getContactPersonLabel(),
                        contactPerson ?: ""
                    ),
                    Detail(
                        getContactPersonPhoneNumber(),
                        contactPhoneNumber ?: ""
                    )
                )
                showDetail(details)
            }
        }
    }

    override fun setView(view: DetailContract.DetailView) {
        detailView = view
    }

    override fun onDestroy() {
        detailView = null
    }
}
