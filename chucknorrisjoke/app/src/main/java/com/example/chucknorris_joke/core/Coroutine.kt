package com.example.chucknorris_joke.core

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class Coroutine {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
    open val io: CoroutineContext by lazy { Dispatchers.IO }
}