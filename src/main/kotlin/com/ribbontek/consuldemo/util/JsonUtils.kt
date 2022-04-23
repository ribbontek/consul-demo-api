package com.ribbontek.consuldemo.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

private val objectMapper = ObjectMapper().apply {
    registerModule(JavaTimeModule())
    registerModule(KotlinModule())
    configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
}

fun <T> T.toJson(): String = objectMapper.writeValueAsString(this)

fun <T> String.fromJson(clazz: Class<T>): T = objectMapper.readValue(this, clazz)
