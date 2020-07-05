package xyz.jaybryantc.androidexam.person.contract

import xyz.jaybryantc.androidexam.interfaces.IPresenter
import xyz.jaybryantc.androidexam.interfaces.IView
import xyz.jaybryantc.androidexam.model.Detail
import xyz.jaybryantc.androidexam.model.Person

interface PersonContract {
    interface PersonView : IView {
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
    interface PersonPresenter :
        IPresenter<PersonView> {
        fun loadDetail(person: Person)
    }
}
