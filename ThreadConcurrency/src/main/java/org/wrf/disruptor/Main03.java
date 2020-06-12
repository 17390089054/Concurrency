package org.wrf.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import java.io.IOException;

/**
 * HandleEventWith lambda写法<br>
 *
 * @className: Main03
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 17:17:50
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        //创建event factory
        //LongEventFactory factory=new LongEventFactory();
        //确定RingBuffer，必须是2的整数次方
        int bufferSize=1024;
        //创建Disruptor
        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(LongEvent::new,bufferSize, DaemonThreadFactory.INSTANCE);
        //连接handler
        disruptor.handleEventsWith((longEvent, l, b) -> System.out.println("Event:"+longEvent));
        //启动Disruptor，开启所有线程
        disruptor.start();
        //从Disruptor中获取RingBuffer用于发布
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //发布所有事件
        ringBuffer.publishEvent((longEvent, l) -> longEvent.setValue(l));

        System.in.read();
    }
}
