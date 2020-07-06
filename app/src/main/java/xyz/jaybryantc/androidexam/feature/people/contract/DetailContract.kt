package xyz.jaybryantc.androidexam.feature.people.contract

import xyz.jaybryantc.androidexam.interfaces.IPresenter
import xyz.jaybryantc.androidexam.interfaces.IView
import xyz.jaybryantc.androidexam.model.Detail
import xyz.jaybryantc.androidexam.model.Person

interface DetailContract {
    interface DetailView : IView {
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
    interface DetailPresenter : IPresenter<DetailView> {
        fun loadDetail(person: Person)
    }
}
