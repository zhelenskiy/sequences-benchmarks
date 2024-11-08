package com.zhelenskiy.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class FilterIteration : AbstractIteration() {

    @Benchmark
    fun intsSequence(bh: Blackhole) {
        for (i in intSequence.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsSequence(bh: Blackhole) {
        for (i in objectSequence.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsList(bh: Blackhole) {
        for (i in intList.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsList(bh: Blackhole) {
        for (i in objectList.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsArray(bh: Blackhole) {
        for (i in intArray.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsArray(bh: Blackhole) {
        for (i in objectArray.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsSpecializedArray(bh: Blackhole) {
        for (i in specializedIntArray.filter(::filter)) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsIfWithProgression(bh: Blackhole) {
        for (i in start..<(start + length)) {
            if (filter(i)) {
                bh.consume(i)
            }
        }
    }
    
    @Benchmark
    fun intsIfWithSpecializedArray(bh: Blackhole) {
        for (i in specializedIntArray) {
            if (filter(i)) {
                bh.consume(i)
            }
        }
    }
    
    @Benchmark
    fun objectsIfWithSpecializedArray(bh: Blackhole) {
        for (o in objectArray) {
            if (filter(o)) {
                bh.consume(o)
            }
        }
    }
    
    @Benchmark
    fun intsIfWithSpecializedArrayInlined(bh: Blackhole) {
        for (i in specializedIntArray) {
            if (inlineFilter(i)) {
                bh.consume(i)
            }
        }
    }
    
    @Benchmark
    fun objectsIfWithSpecializedArrayInlined(bh: Blackhole) {
        for (o in objectArray) {
            if (inlineFilter(o)) {
                bh.consume(o)
            }
        }
    }
}
