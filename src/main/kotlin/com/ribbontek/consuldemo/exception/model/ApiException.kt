package com.ribbontek.consuldemo.exception.model

import com.ribbontek.consuldemo.util.toUtc
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.time.ZonedDateTime

data class ApiException(
    val code: HttpStatus,
    val message: String? = null,
    val time: ZonedDateTime
)

fun AppException.toApiExceptionResponseEntity(): ResponseEntity<ApiException> =
    ResponseEntity(this.toApiException(), this.code)

fun AppException.toApiException(): ApiException =
    ApiException(code = code, message = message, time = ZonedDateTime.now().toUtc())
