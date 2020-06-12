package org.wrf.thread;

/**
 * Interrupted基本用法 <br>
 *  调用interrupt(),通知线程中断
 *  1)
 *     如果线程处于被阻塞状态，那么线程将立刻退出被阻塞的状态，并抛出一个InterruptedException异常
 *  2)
 *      如果线程处于正常活动状态，那么将会该线程的中断标志位设置为true。被设置中断标志位的线程将会正常运行，不受影响。
 * @className: InterruptedDemo
 * @package: org.wrf.thread
 * @author: knight
 * @date: 2020-05-04 14:12:48
 */
public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable interruptDemo=new Runnable() {
            @Override
            public void run() {
                int i=0;
                //在正常运行任务时，经常检查本线程的中断标志位，如果被设置为中断标志位就自行停止
                while(!Thread.currentThread().isInterrupted()){
                    try {
                        //休眠100ms
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName()+"("+Thread.currentThread().getState()+")"+"do loop "+i);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName()+"("+Thread.currentThread().getState()+")"+ "catch InterruptedException");
                        //e.printStackTrace();
                    }
                }
            }
        };

        Thread t=new Thread(interruptDemo,"t");
        System.out.println(t.getName()+"("+t.getState()+") is new.");
        t.start();
        System.out.println(t.getName()+"("+t.getState()+") is started.");
        //主线程进入休眠300ms，中断线程t
        Thread.sleep(300);
        t.interrupt();
        System.out.println(t.getName()+"("+t.getState()+") is interrupted.");
        //主线程休眠300ms
        Thread.sleep(300);
        System.out.println(t.getName()+"("+t.getState()+") is interrupted now.");
    }
}
