package xyz.jaybryantc.androidexam.interfaces

interface IPresenter<T : IView> {
    fun setView(view: T)
}
