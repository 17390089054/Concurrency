package org.wrf.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/**
 * 消费者异常处理 ExceptionHandler<br>
 *
 * @className: N04_ExceptionHandler
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 20:30:09
 */
public class N04_ExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        LongEventFactory factory=new LongEventFactory();
        int bufferSize=1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI, new SleepingWaitStrategy());

        EventHandler h1=(event,sequence,end)->{
            System.out.println("消费者出现异常");
        };
        disruptor.handleEventsWith(h1);
        disruptor.handleExceptionsFor(h1).with(new ExceptionHandler<LongEvent>() {
            @Override
            public void handleEventException(Throwable throwable, long l, LongEvent longEvent) {
               throwable.printStackTrace();
            }

            @Override
            public void handleOnStartException(Throwable throwable) {
                System.out.println("Exception Start to Handle!");
            }

            @Override
            public void handleOnShutdownException(Throwable throwable) {
                System.out.println("Exception End to Handle!");
            }
        });

        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //================================
        final int threadCount=1;
        CyclicBarrier barrier=new CyclicBarrier(threadCount);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            final long threadNum=i;
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
