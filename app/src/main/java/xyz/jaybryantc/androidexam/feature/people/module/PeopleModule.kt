package xyz.jaybryantc.androidexam.feature.people.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.Dispatchers
import xyz.jaybryantc.androidexam.feature.people.contract.DetailContract
import xyz.jaybryantc.androidexam.feature.people.contract.PeopleContract
import xyz.jaybryantc.androidexam.feature.people.presenter.DetailPresenterImpl
import xyz.jaybryantc.androidexam.feature.people.presenter.PeoplePresenterImpl
import xyz.jaybryantc.androidexam.repository.PeopleRepository

@Module
@InstallIn(FragmentComponent::class)
object PeopleModule {
    @Provides
    fun providesPeoplePresenter(peopleRepository: PeopleRepository): PeopleContract.PeoplePresenter =
        PeoplePresenterImpl(peopleRepository, Dispatchers.Main)

    @FragmentScoped
    @Provides
    fun providesPersonPresenter(): DetailContract.DetailPresenter =
        DetailPresenterImpl()
}
