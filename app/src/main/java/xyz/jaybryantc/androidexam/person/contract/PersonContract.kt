package xyz.jaybryantc.androidexam.person.contract

import xyz.jaybryantc.androidexam.base.IPresenter
import xyz.jaybryantc.androidexam.base.IView
import xyz.jaybryantc.androidexam.person.model.Detail

interface PersonContract {
    interface PersonPresenter : IPresenter {
        fun loadDetail()
    }

    interface PersonView : IView<PersonPresenter> {
        fun showPersonNameAsTitle(name: String)
        fun showDetail(details: List<Detail>)
        fun getFirstNameLabel(): String
        fun getLastNameLabel(): String
        fun getBirthdayLabel(): String
        fun getAgeLabel(): String
        fun getEmailAddressLabel(): String
        fun getMobileNumberLabel(): String
        fun getAddressLabel(): String
        fun getContactPersonLabel(): String
        fun getContactPersonPhoneNumber(): String
    }
}
