package xyz.jaybryantc.androidexam.people.contract

import xyz.jaybryantc.androidexam.interfaces.IPresenter
import xyz.jaybryantc.androidexam.interfaces.IView
import xyz.jaybryantc.androidexam.model.Person

interface PeopleContract {
    interface PeopleView : IView {
        fun showList(people: List<Person>)
        fun showError()
        fun showLoading()
    }
    interface PeoplePresenter : IPresenter<PeopleView> {
        fun loadPeople(forceLoad: Boolean = false)
    }
}
