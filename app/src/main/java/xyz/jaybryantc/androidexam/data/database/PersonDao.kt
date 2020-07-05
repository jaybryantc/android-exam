package xyz.jaybryantc.androidexam.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xyz.jaybryantc.androidexam.data.model.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    fun getAllPersons(): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersons(person: List<Person>)
}
