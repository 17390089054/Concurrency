package org.wrf.jmh;

import org.openjdk.jmh.annotations.*;

/**
 * JMH 微基准测试 <br>
 *
 * @className: PSTest
 * @package: org.wrf.jmh
 * @author: knight
 * @date: 2020-06-06 17:23:48
 */
public class PSTest {
    @Benchmark
    @Warmup(iterations = 1,time = 3) //预热，预热次数，预热时长
    @Fork(5)    //模拟线程数
    @BenchmarkMode(Mode.Throughput) //测试模式  Throughput代码吞吐量
    @Measurement(iterations = 1,time = 3) //测试运行次数，方法调用次数
    public void testForEach(){
        PS.foreach();
    }

}
