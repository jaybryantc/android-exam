package xyz.jaybryantc.androidexam.person.presenter

import xyz.jaybryantc.androidexam.person.contract.PersonContract
import xyz.jaybryantc.androidexam.person.model.Detail

class PersonPresenterImpl(private val view: PersonContract.PersonView) : PersonContract.PersonPresenter {
    override fun loadDetail() {
        view.showPersonNameAsTitle("Coco Martin")
        val details = mutableListOf<Detail>(
            Detail(view.getFirstNameLabel(), ""),
            Detail(view.getLastNameLabel(), ""),
            Detail(view.getBirthdayLabel(), ""),
            Detail(view.getAgeLabel(), ""),
            Detail(view.getEmailAddressLabel(), ""),
            Detail(view.getMobileNumberLabel(), ""),
            Detail(view.getAddressLabel(), ""),
            Detail(view.getContactPersonLabel(), ""),
            Detail(view.getContactPersonPhoneNumber(), "")
        )
        view.showDetail(details)
    }
}
