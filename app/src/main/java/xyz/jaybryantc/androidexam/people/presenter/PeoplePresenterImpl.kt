package xyz.jaybryantc.androidexam.people.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import xyz.jaybryantc.androidexam.data.model.Person
import xyz.jaybryantc.androidexam.data.repository.PeopleRepository
import xyz.jaybryantc.androidexam.data.network.ApiResult.Error
import xyz.jaybryantc.androidexam.data.network.ApiResult.Success
import xyz.jaybryantc.androidexam.people.contract.PeopleContract
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PeoplePresenterImpl @Inject constructor(private val peopleRepository: PeopleRepository,
                                              override val coroutineContext: CoroutineContext
) : PeopleContract.PeoplePresenter, CoroutineScope {
    private var peopleView: PeopleContract.PeopleView? = null

    private var data: LiveData<List<Person>>? = null

    private val observer = Observer<List<Person>> {
        peopleView?.let { view ->
            when {
                it.isNotEmpty() -> view.showList(it)
                else -> launch {
                    loadPeople()
                }
            }
        }
    }

    override fun loadPeople(forceLoad: Boolean) {
        launch {
            data = peopleRepository.getAllPeople()
            data?.observeForever(observer)
            if (forceLoad) {
              loadPeople()
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
