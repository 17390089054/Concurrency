package org.wrf.threadPool;

import java.util.concurrent.*;

/**
 * 自定义拒绝策略 RejectHandler <br>
 *
 * @className: N08_MyRejectHandler
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-06 10:20:09
 */
public class N08_MyRejectHandler {
    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6), Executors.defaultThreadFactory(), new MyHandler());
        for (int i = 0; i < 12; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        service.shutdown();
    }

    static class MyHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if(threadPoolExecutor.getQueue().size() < 10000){
                System.out.println("space not  enough");
            }
        }
    }
}
