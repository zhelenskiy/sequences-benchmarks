package com.zhelenskiy.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class NestedIteration: AbstractIteration() {

    @Benchmark
    fun intsSequence(bh: Blackhole) {
        for (i in intSequence.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun objectsSequence(bh: Blackhole) {
        for (i in objectSequence.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun intsList(bh: Blackhole) {
        for (i in intList.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun objectsList(bh: Blackhole) {
        for (i in objectList.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun intsArray(bh: Blackhole) {
        for (i in intArray.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun objectsArray(bh: Blackhole) {
        for (i in objectArray.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun intsSpecializedArray(bh: Blackhole) {
        for (i in specializedIntArray.filter(::filter).map(::map)) {
            bh.consume(i)
        }
    }

    @Benchmark
    fun intsIfWithProgression(bh: Blackhole) {
        for (i in start..<(start + length)) {
            if (filter(i)) {
                bh.consume(map(i))
            }
        }
    }

    @Benchmark
    fun intsIfWithSpecializedArray(bh: Blackhole) {
        for (i in specializedIntArray) {
            if (filter(i)) {
                bh.consume(map(i))
            }
        }
    }

    @Benchmark
    fun objectsIfWithSpecializedArray(bh: Blackhole) {
        for (o in objectArray) {
            if (filter(o)) {
                bh.consume(map(o))
            }
        }
    }

    @Benchmark
    fun intsIfWithSpecializedArrayInlined(bh: Blackhole) {
        for (i in specializedIntArray) {
            if (inlineFilter(i)) {
                bh.consume(inlineMap(i))
            }
        }
    }

    @Benchmark
    fun objectsIfWithSpecializedArrayInlined(bh: Blackhole) {
        for (o in objectArray) {
            if (inlineFilter(o)) {
                bh.consume(inlineMap(o))
            }
        }
    }
    
    @Benchmark
    fun intsSequenceWithManualComposition(bh: Blackhole) {
        val processedSequence = sequence {
            for (i in intSequence) {
                if (filter(i)) {
                    yield(map(i))
                }
            }
        }
        for (i in processedSequence) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun intsListWithManualComposition(bh: Blackhole) {
        val processedList = buildList {
            for (i in intList) {
                if (inlineFilter(i)) {
                    add(inlineMap(i))
                }
            }
        }
        for (i in processedList) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun objectsSequenceWithManualComposition(bh: Blackhole) {
        val processedSequence = sequence {
            for (o in objectSequence) {
                if (filter(o)) {
                    yield(map(o))
                }
            }
        }
        for (o in processedSequence) {
            bh.consume(o)
        }
    }
    
    @Benchmark
    fun objectsListWithManualComposition(bh: Blackhole) {
        val processedList = buildList {
            for (o in objectList) {
                if (inlineFilter(o)) {
                    add(inlineMap(o))
                }
            }
        }
        for (o in processedList) {
            bh.consume(o)
        }
    }
}
