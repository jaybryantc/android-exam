package xyz.jaybryantc.androidexam.people.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import xyz.jaybryantc.androidexam.data.network.ApiResult.Error
import xyz.jaybryantc.androidexam.data.network.ApiResult.Success
import xyz.jaybryantc.androidexam.model.Person
import xyz.jaybryantc.androidexam.people.contract.PeopleContract
import xyz.jaybryantc.androidexam.repository.PeopleRepository

class PeoplePresenterImpl @Inject constructor(
    private val peopleRepository: PeopleRepository,
    override val coroutineContext: CoroutineContext
) : PeopleContract.PeoplePresenter, CoroutineScope {
    private var peopleView: PeopleContract.PeopleView? = null

    private var data: LiveData<List<Person>>? = null

    private val observer = Observer<List<Person>> {
        peopleView?.run {
            when {
                it.isNotEmpty() -> showList(it)
                else -> showError()
            }
        }
    }

    override fun loadPeople(forceLoad: Boolean) {
        launch {
            data = peopleRepository.getAllPeople()
            data?.run {
                observeForever(observer)
                if (forceLoad || value?.isEmpty() == true) {
                    loadPeople()
                }
            }
        }
    }

    private suspend fun loadPeople() {
        peopleView?.run {
            showLoading()
            when (val response = peopleRepository.loadPeople()) {
                is Error -> showError()
                is Success -> showList(response.result)
            }
        }
    }

    override fun setView(view: PeopleContract.PeopleView) {
        peopleView = view
    }

    override fun onDestroy() {
        data?.removeObserver(observer)
        peopleView = null
    }
}
