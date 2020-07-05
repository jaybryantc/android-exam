package xyz.jaybryantc.androidexam.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import xyz.jaybryantc.androidexam.data.database.dao.PersonDao
import xyz.jaybryantc.androidexam.data.database.entity.PersonEntity
import xyz.jaybryantc.androidexam.data.network.ApiResult
import xyz.jaybryantc.androidexam.data.network.dto.PersonDTO
import xyz.jaybryantc.androidexam.data.network.services.PeopleService
import xyz.jaybryantc.androidexam.model.Person
import xyz.jaybryantc.androidexam.util.mapList

class PeopleRepositoryImpl @Inject constructor(private val service: PeopleService, private val dao: PersonDao) :
    PeopleRepository {
    override suspend fun getAllPeople(): LiveData<List<Person>> {
        var people: List<Person> = mutableListOf()
        withContext(Dispatchers.IO) {
            people = dao.getAllPersons().mapList()
        }
        return MutableLiveData(people)
    }

    override suspend fun loadPeople(): ApiResult<List<Person>> {
        var result: ApiResult<List<Person>> = ApiResult.Error
        try {
            val peopleFromApi = service.getPeople()
            withContext(Dispatchers.IO) {
                val personEntries = peopleFromApi.mapList<PersonDTO, PersonEntity>()
                dao.insertPersons(personEntries)
            }
            val people = peopleFromApi.mapList<PersonDTO, Person>()
            result = ApiResult.Success(people)
        } catch (e: HttpException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }
}
