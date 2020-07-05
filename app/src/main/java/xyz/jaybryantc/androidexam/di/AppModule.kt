package xyz.jaybryantc.androidexam.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.jaybryantc.androidexam.BuildConfig
import xyz.jaybryantc.androidexam.data.network.services.PeopleService
import xyz.jaybryantc.androidexam.data.database.PeopleDatabase
import xyz.jaybryantc.androidexam.data.database.PersonDao
import xyz.jaybryantc.androidexam.data.repository.PeopleRepository
import xyz.jaybryantc.androidexam.data.repository.PeopleRepositoryImpl
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PeopleApiBaseUrl

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Provides
    fun providePeopleRepository(service: PeopleService, personDao: PersonDao): PeopleRepository =
        PeopleRepositoryImpl(service, personDao)
}

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    private lateinit var peopleDatabase: PeopleDatabase

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): PeopleDatabase {
        peopleDatabase = PeopleDatabase.getInstance(context)
        return peopleDatabase
    }

    @Provides
    fun providesPersonDao(database: PeopleDatabase): PersonDao = database.personDao
}

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {
    @PeopleApiBaseUrl
    @Provides
    fun providePeopleApiUrl(): String = BuildConfig.PEOPLE_API_URL

    @Provides
    fun providesPeopleApi(@PeopleApiBaseUrl peopleApiBaseUrl: String): PeopleService =
        Retrofit.Builder().baseUrl(peopleApiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(PeopleService::class.java)
}
