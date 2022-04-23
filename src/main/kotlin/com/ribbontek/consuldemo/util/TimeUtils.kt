package com.ribbontek.consuldemo.util

import java.time.ZoneOffset
import java.time.ZonedDateTime

fun ZonedDateTime.toUtc(): ZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC)
fun utc(): ZonedDateTime = ZonedDateTime.now(ZoneOffset.UTC)
