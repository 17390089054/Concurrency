package org.wrf.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.util.concurrent.Executors;

/**
 * Disruptor应用示例 <br>
 *
 * @className: Main01
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 00:40:21
 */
public class Main01 {
    public static void main(String[] args) {
        //定义消息工厂
        LongEventFactory  factory=new LongEventFactory();
        //确定环大小，必须是2的整数次方
        int bufferSize=1024;
        //构建Disruptor
        Disruptor<LongEvent> disruptor=new Disruptor<>(factory,bufferSize, Executors.defaultThreadFactory());
        //连接Handler处理器
        disruptor.handleEventsWith(new LongEventHandler());
        //开启Disruptor，启动所有线程运行
        disruptor.start();

        //从Disruptor获取RingBuffer用来发布
        RingBuffer<LongEvent> ringBuffer=disruptor.getRingBuffer();

        //官方例程
        long sequence = ringBuffer.next();
        try{
            //从Disruptor获取消息项Entry
            LongEvent event = ringBuffer.get(sequence);
            //从当前sequence开始
            event.setValue(8888L);
        }finally {
            ringBuffer.publish(sequence);
        }
    }


}
