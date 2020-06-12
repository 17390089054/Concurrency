package org.wrf.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * LongEventFactory生产LongEvent消息 --生产者<br>
 *
 * @className: LongEventFactory
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 00:23:26
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
