package xyz.jaybryantc.androidexam.people.contract

import xyz.jaybryantc.androidexam.base.IPresenter
import xyz.jaybryantc.androidexam.base.IView

interface PeopleContract  {
    interface PeoplePresenter: IPresenter {
        fun loadPeople()
    }
    interface PeopleView : IView<PeoplePresenter> {
        fun showList(people: List<String>)
        fun showError()
        fun showLoading()
    }
}
