package com.miguelbrmfreitas.domain.repositories

import java.lang.Exception

sealed class ApiResult<out T> {
    data class Success<T>(val data: T?, val token: String) : ApiResult<T>()
    data class Failure(val exception: Exception): ApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success data: $data]"
            is Failure -> "Error exception: $exception]"
        }
    }
}