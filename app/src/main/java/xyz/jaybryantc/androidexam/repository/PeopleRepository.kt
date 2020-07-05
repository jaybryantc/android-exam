package xyz.jaybryantc.androidexam.repository

import androidx.lifecycle.LiveData
import xyz.jaybryantc.androidexam.data.network.ApiResult
import xyz.jaybryantc.androidexam.model.Person

interface PeopleRepository {
    suspend fun getAllPeople(): LiveData<List<Person>>
    suspend fun loadPeople(): ApiResult<List<Person>>
}
