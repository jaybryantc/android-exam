package xyz.jaybryantc.androidexam.people.presenter

import xyz.jaybryantc.androidexam.people.contract.PeopleContract

class PeoplePresenterImpl : PeopleContract.PeoplePresenter {

    lateinit var peopleView: PeopleContract.PeopleView

    override fun loadPeople() {
        peopleView.showLoading()
    }

    override fun setView(view: PeopleContract.PeopleView) {
        peopleView = view
    }
}
