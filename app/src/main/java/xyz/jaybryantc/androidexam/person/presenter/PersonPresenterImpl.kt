package xyz.jaybryantc.androidexam.person.presenter

import xyz.jaybryantc.androidexam.person.contract.PersonContract
import xyz.jaybryantc.androidexam.person.model.Detail

class PersonPresenterImpl : PersonContract.PersonPresenter {

    lateinit var personView: PersonContract.PersonView

    override fun loadDetail() {
        personView.showPersonNameAsTitle("Coco Martin")
        val details = mutableListOf<Detail>(
            Detail(personView.getFirstNameLabel(), ""),
            Detail(personView.getLastNameLabel(), ""),
            Detail(personView.getBirthdayLabel(), ""),
            Detail(personView.getAgeLabel(), ""),
            Detail(personView.getEmailAddressLabel(), ""),
            Detail(personView.getMobileNumberLabel(), ""),
            Detail(personView.getAddressLabel(), ""),
            Detail(personView.getContactPersonLabel(), ""),
            Detail(personView.getContactPersonPhoneNumber(), "")
        )
        personView.showDetail(details)
    }

    override fun setView(view: PersonContract.PersonView) {
        personView = view
    }
}
