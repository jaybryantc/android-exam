package xyz.jaybryantc.androidexam.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import xyz.jaybryantc.androidexam.data.database.dao.PersonDao
import xyz.jaybryantc.androidexam.data.database.entity.PersonEntity
import xyz.jaybryantc.androidexam.util.Converters

const val DATABASE_VERSION = 1
const val DATABASE_NAME: String = "people_database.db"

@Database(entities = [PersonEntity::class], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PeopleDatabase : RoomDatabase() {

    abstract val personDao: PersonDao

    companion object {
        @Volatile
        private var INSTANCE: PeopleDatabase? = null

        fun getInstance(context: Context): PeopleDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        PeopleDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
