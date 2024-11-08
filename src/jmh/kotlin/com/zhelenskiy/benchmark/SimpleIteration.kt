package com.zhelenskiy.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class SimpleIteration : AbstractIteration() {

    @Benchmark
    fun intsSequence(bh: Blackhole) {
        for (i in intSequence) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsSequence(bh: Blackhole) {
        for (i in objectSequence) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsList(bh: Blackhole) {
        for (i in intList) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsList(bh: Blackhole) {
        for (i in objectList) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsArray(bh: Blackhole) {
        for (i in intArray) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsArray(bh: Blackhole) {
        for (i in objectArray) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsSpecializedArray(bh: Blackhole) {
        for (i in specializedIntArray) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsIfWithProgression(bh: Blackhole) {
        for (i in start..<(start + length)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsIfWithSpecializedArray(bh: Blackhole) {
        for (i in specializedIntArray) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsIfWithSpecializedArray(bh: Blackhole) {
        for (o in objectArray) {
            bh.consume(o)
        }
    }
}
