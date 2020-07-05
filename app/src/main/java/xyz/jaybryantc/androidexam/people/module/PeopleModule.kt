package xyz.jaybryantc.androidexam.people.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.Dispatchers
import xyz.jaybryantc.androidexam.people.contract.PeopleContract
import xyz.jaybryantc.androidexam.people.presenter.PeoplePresenterImpl
import xyz.jaybryantc.androidexam.repository.PeopleRepository

@Module
@InstallIn(FragmentComponent::class)
object PeopleModule {
    @Provides
    fun providesPeoplePresenter(peopleRepository: PeopleRepository): PeopleContract.PeoplePresenter =
        PeoplePresenterImpl(peopleRepository, Dispatchers.Main)
}
