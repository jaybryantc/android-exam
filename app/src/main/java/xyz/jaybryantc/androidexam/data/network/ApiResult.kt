package xyz.jaybryantc.androidexam.data.network

sealed class ApiResult<out T> {
    data class Success<out T>(val result: T): ApiResult<T>()
    object Error : ApiResult<Nothing>()
}
