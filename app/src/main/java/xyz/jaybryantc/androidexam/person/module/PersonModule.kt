package xyz.jaybryantc.androidexam.person.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import xyz.jaybryantc.androidexam.person.contract.PersonContract
import xyz.jaybryantc.androidexam.person.presenter.PersonPresenterImpl

@Module
@InstallIn(FragmentComponent::class)
object PersonModule {

    @FragmentScoped
    @Provides
    fun providesPersonPresenter(): PersonContract.PersonPresenter = PersonPresenterImpl()
}
