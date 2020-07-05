package xyz.jaybryantc.androidexam.data.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import xyz.jaybryantc.androidexam.data.network.services.PeopleService
import xyz.jaybryantc.androidexam.data.model.Person
import xyz.jaybryantc.androidexam.data.database.PersonDao
import xyz.jaybryantc.androidexam.data.network.ApiResult
import java.io.IOException
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(private val service: PeopleService, private val dao: PersonDao):
    PeopleRepository {
    override fun getAllPeople(): LiveData<List<Person>> {
        return dao.getAllPersons()
    }

    override suspend fun loadPeople() : ApiResult<List<Person>> {
        var result: ApiResult<List<Person>> = ApiResult.Error
        try {
            val people = service.getPeople()
            withContext(Dispatchers.IO) {
                dao.insertPersons(service.getPeople())
            }
            result = ApiResult.Success(people)
        } catch (e: HttpException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }
}
