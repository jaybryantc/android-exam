package xyz.jaybryantc.androidexam.person.presenter

import xyz.jaybryantc.androidexam.model.Detail
import xyz.jaybryantc.androidexam.model.Person
import xyz.jaybryantc.androidexam.person.contract.PersonContract
import xyz.jaybryantc.androidexam.util.format
import xyz.jaybryantc.androidexam.util.getElapsedYears

class PersonPresenterImpl : PersonContract.PersonPresenter {
    private var personView: PersonContract.PersonView? = null

    override fun loadDetail(person: Person) {
        personView?.apply {
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

    override fun setView(view: PersonContract.PersonView) {
        personView = view
    }

    override fun onDestroy() {
        personView = null
    }
}
