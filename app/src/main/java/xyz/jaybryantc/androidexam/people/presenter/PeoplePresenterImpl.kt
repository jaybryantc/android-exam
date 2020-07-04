package xyz.jaybryantc.androidexam.people.presenter

import xyz.jaybryantc.androidexam.people.contract.PeopleContract

class PeoplePresenterImpl(private val view: PeopleContract.PeopleView) :
    PeopleContract.PeoplePresenter {

    override fun loadPeople() {
        view.showLoading()
    }
}
