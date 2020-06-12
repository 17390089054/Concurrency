package org.wrf.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.concurrent.*;

/**
 * ProducerType生产者线程模式 <br>
 *
 * @className: N01_ProducerType
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 19:01:41
 */
public class N01_ProducerType {
    public static void main(String[] args) throws InterruptedException {
        //事件工厂
        LongEventFactory factory=new LongEventFactory();
        //确定环大小，必须为2的整数次幂
        int bufferSize=1024;
        //构建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());
        //连接Handler
        disruptor.handleEventsWith(new LongEventHandler());
        //开启Disruptor，开启所有线程
        disruptor.start();
        //从Disruptor获取RingBuffer用以publish
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        //=========================
        final int threadCount=50;
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

                for (int j = 0; j < 100; j++) {
                    ringBuffer.publishEvent((longEvent, l) -> {
                        longEvent.setValue(l);
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
