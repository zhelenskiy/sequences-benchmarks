package com.zhelenskiy.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import kotlin.random.Random

@State(Scope.Benchmark)
open class Creation {
    private var start = 0
    
    @Param("10", "100", "1000", "10000", "100000")
    var length = 0
    
    @Setup(Level.Iteration)
    fun setUp() {
        start = Random.nextInt()
    }
    
    @Benchmark
    fun intsList(bh: Blackhole) {
        bh.consume(List(length) { it + start })
    }
    
    @Benchmark
    fun intsArray(bh: Blackhole) {
        bh.consume(Array(length) { it + start })
    }
    
    @Benchmark
    fun objectsList(bh: Blackhole) {
        bh.consume(List(length) { Any() })
    }
    
    @Benchmark
    fun objectsArray(bh: Blackhole) {
        bh.consume(Array(length) { Any() })
    }
    
    @Benchmark
    fun intsSpecializedArray(bh: Blackhole) {
        bh.consume(IntArray(length) { it + start })
    }
}
