package com.ribbontek.consuldemo.handler

interface EventHandler<T> {
    fun handle(event: T)
}
