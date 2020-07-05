package xyz.jaybryantc.androidexam.data.repository

import androidx.lifecycle.LiveData
import xyz.jaybryantc.androidexam.data.model.Person
import xyz.jaybryantc.androidexam.data.network.ApiResult

interface PeopleRepository {
    fun getAllPeople(): LiveData<List<Person>>
    suspend fun loadPeople(): ApiResult<List<Person>>
}
