package org.wrf.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/**
 * 多个消费者 MultiConsumer<br>
 *
 * @className: N03_MultiConsumer
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 20:07:22
 */
public class N03_MultiConsumer {
    public static void main(String[] args) throws InterruptedException {
        LongEventFactory factory=new LongEventFactory();
        int bufferSize=1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI, new SleepingWaitStrategy());
        LongEventHandler h1=new LongEventHandler();
        LongEventHandler h2=new LongEventHandler();
        disruptor.handleEventsWith(h1,h2);
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //===============
        final int threadCount=10;
        CyclicBarrier barrier=new CyclicBarrier(threadCount);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            final int threadNum=i;
            service.submit(() -> {
                System.out.printf("Thread %s ready to start!\n",threadNum);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10; j++) {
                    ringBuffer.publishEvent((longEvent, l) -> {
                        longEvent.setValue(threadNum);
                        System.out.println("生产了"+threadNum);
                    });
                }
            });
        }
        service.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(LongEventHandler.count);
    }
}
