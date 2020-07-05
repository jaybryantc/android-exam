package xyz.jaybryantc.androidexam.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xyz.jaybryantc.androidexam.data.database.entity.PersonEntity

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    fun getAllPersons(): List<PersonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersons(person: List<PersonEntity>)
}
