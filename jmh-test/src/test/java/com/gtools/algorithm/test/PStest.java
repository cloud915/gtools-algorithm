package com.gtools.algorithm.test;

import com.gtools.algrithm.jmh.test.PS;
import org.openjdk.jmh.annotations.*;

public class PStest {
    @Benchmark
    @Warmup(iterations = 1, time = 3)
    @Fork(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1, time = 3)
    public void testForeach() {
        PS.foreach();
    }

}
