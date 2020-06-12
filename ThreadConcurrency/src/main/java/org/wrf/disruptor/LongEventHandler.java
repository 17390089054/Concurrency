package org.wrf.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 *  消息处理器 LongEventHandler <br>
 *
 * @className: LongEventHandler
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 00:29:17
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public static long count=0;

    /**
     * 消息处理方法
     * @param event
     * @param sequence
     * @param endOfBatch
     * @throws Exception
     */
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        count++;
        System.out.println("["+Thread.currentThread().getName()+"]"+event+"序号："+sequence);
    }
}
