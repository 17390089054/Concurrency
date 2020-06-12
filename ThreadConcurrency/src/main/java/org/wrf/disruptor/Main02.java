package org.wrf.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * Disruptor-EventTranslator <br>
 *
 * @className: Main02
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 16:42:50
 */
public class Main02 {
    public static void main(String[] args) {
        //创建EventFactory
        LongEventFactory factory=new LongEventFactory();
        //确定RingBuffer，必须是2的整数次幂
        int bufferSize=1024;
        //创建Disruptor
        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(factory,bufferSize, DaemonThreadFactory.INSTANCE);
        //连接Handler
        disruptor.handleEventsWith(new LongEventHandler());
        //开启Disruptor，所有线程运行
        disruptor.start();
        //从Disruptor中获取RingBuffer用来publish
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        // 无参   ----------------
        EventTranslator<LongEvent> translator1= (longEvent, l) -> longEvent.setValue(8888L);
        ringBuffer.publishEvent(translator1);

        // 一个参数 ---------------
        EventTranslatorOneArg<LongEvent,Long> translator2= (longEvent, l, aLong) -> longEvent.setValue(aLong);
        ringBuffer.publishEvent(translator2,7777L);

        //两个参数  ------------
        EventTranslatorTwoArg<LongEvent,Long,Long> translator3= (longEvent, l, aLong, aLong2) -> longEvent.setValue(aLong);
        ringBuffer.publishEvent(translator3,10000L,10000L);

        //三个参数  -------------
        EventTranslatorThreeArg<LongEvent,Long,Long,Long> translator4= (longEvent, l, aLong, aLong2, aLong3) -> longEvent.setValue(aLong+aLong2+aLong3);
        ringBuffer.publishEvent(translator4,10000L,10000L,10000L);

        //无限参数  ------------
        EventTranslatorVararg<LongEvent> translator5= (longEvent, l, objects) -> {
            long result=0;
            for (Object o:objects){
                long sequence=(Long) o;
                result+=sequence;
            }
        };
        ringBuffer.publishEvent(translator5,10000L,10000L,10000L,10000L);
    }
}
