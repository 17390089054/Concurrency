package org.wrf.disruptor;

/**
 * 队列中需要处理的元素LongEvent <br>
 *
 * @className: LongEvent
 * @package: org.wrf.disruptor
 * @author: knight
 * @date: 2020-06-07 00:06:06
 */
public class LongEvent {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }
}
