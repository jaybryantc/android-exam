package xyz.jaybryantc.androidexam.people.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import xyz.jaybryantc.androidexam.people.contract.PeopleContract
import xyz.jaybryantc.androidexam.people.presenter.PeoplePresenterImpl

@Module
@InstallIn(FragmentComponent::class)
object PeopleModule {

    @FragmentScoped
    @Provides
    fun providesPeoplePresenter(): PeopleContract.PeoplePresenter = PeoplePresenterImpl()
}
