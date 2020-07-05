package xyz.jaybryantc.androidexam.data.network.services

import retrofit2.http.GET
import xyz.jaybryantc.androidexam.data.model.Person

interface PeopleService {
    @GET("people")
    suspend fun getPeople(): List<Person>
}
