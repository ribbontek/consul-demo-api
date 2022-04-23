package com.ribbontek.consuldemo.exception

import com.ribbontek.consuldemo.exception.model.ApiException
import com.ribbontek.consuldemo.exception.model.GenericException
import com.ribbontek.consuldemo.exception.model.MapNotFoundException
import com.ribbontek.consuldemo.exception.model.QuestNotFoundException
import com.ribbontek.consuldemo.exception.model.toApiExceptionResponseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler
    fun handleException(ex: Exception): ResponseEntity<ApiException> {
        return when (ex) {
            is QuestNotFoundException -> ex.toApiExceptionResponseEntity()
            is MapNotFoundException -> ex.toApiExceptionResponseEntity()
            else -> GenericException().toApiExceptionResponseEntity()
        }
    }
}
