package org.wrf.thread;

import java.util.concurrent.Callable;

/**
 *  Callable 接口实现 <br>
 *
 * @className: MyCallable
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 10:22:25
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value="value";
        System.out.println("Ready to start");
        Thread.currentThread().sleep(5000);
        System.out.println("task is done");
        return value;
    }
}
