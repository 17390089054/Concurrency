package org.wrf.thread;

/**
 * 获取线程返回值 <br>
 *     1.主线程循环等待直至子线程执行完毕
 *     2.调用子线程join()方法阻塞当前线程，直至子线程完成
 *     3.Callable接口实现，通过FutureTask接口获取返回值
 *
 * @className: CycleWait
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 10:06:49
 */
public class CycleWait implements Runnable {
    private String value;
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value="thread end";
    }

    public static void main(String[] args) {
        CycleWait c=new CycleWait();
        Thread t=new Thread(c);
        t.start();
        //1.主线程等待法获取线程返回值
        /*while(c.value==null){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //2.主线程阻塞等待
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("value:"+c.value);

    }
}
