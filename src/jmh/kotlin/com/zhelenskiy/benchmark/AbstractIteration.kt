package com.zhelenskiy.benchmark

import org.openjdk.jmh.annotations.*
import kotlin.random.Random

@State(Scope.Benchmark)
open class AbstractIteration {
    protected var start = 0

    @Param("10", "100", "1000", "10000", "100000")
    var length = 0
    protected var intSequence = sequenceOf<Int>()
    protected var objectSequence = sequenceOf<Value>()
    protected var intList = listOf<Int>()
    protected var objectList = listOf<Value>()
    protected var intArray = arrayOf<Int>()
    protected var objectArray = arrayOf<Value>()
    protected var specializedIntArray = intArrayOf()

    protected data class Value(val x: Int)
    
    protected fun filter(x: Int) = x % 2 == 0
    @Suppress("NOTHING_TO_INLINE")
    protected inline fun inlineFilter(x: Int) = x % 2 == 0
    
    protected fun filter(x: Value) = x.x % 2 == 0
    @Suppress("NOTHING_TO_INLINE")
    protected inline fun inlineFilter(x: Value) = x.x % 2 == 0
    
    protected fun map(x: Int) = x % 2 == 0
    @Suppress("NOTHING_TO_INLINE")
    protected inline fun inlineMap(x: Int) = x % 2 == 0
    
    protected fun map(x: Value) = x.x % 2 == 0
    @Suppress("NOTHING_TO_INLINE")
    protected inline fun inlineMap(x: Value) = x.x % 2 == 0

    @Setup(Level.Iteration)
    fun setUp() {
        start = Random.nextInt()
        val range = start..<(start + length)

        intSequence = range.asSequence()
        intList = range.toList()
        intArray = range.toList().toTypedArray()
        specializedIntArray = range.toList().toIntArray()

        objectList = intArray.map(::Value)
        objectArray = objectList.toTypedArray()
        objectSequence = objectArray.asSequence()
    }
}