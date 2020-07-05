package xyz.jaybryantc.androidexam.data.network.services

import retrofit2.http.GET
import xyz.jaybryantc.androidexam.data.network.dto.PersonDTO

interface PeopleService {
    @GET("people")
    suspend fun getPeople(): List<PersonDTO>
}
