package org.wrf.huawei;

/**
 * 华为面试题 <br>
 * 两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 *  然后要让这两个线程做到同时运行，交替输出，顺序打印。
 *  自定义实现自旋操作
 * @className: H06_Lock_Condition
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 21:16:40
 */
public class H07_Cas {
    enum ReadyToRun {T1,T2};
    //初始值
    static volatile ReadyToRun r=ReadyToRun.T1;
    public static void main(String[] args) {

        char [] c1="123456".toCharArray();
        char [] c2="ABCDEF".toCharArray();

        new Thread(()->{
            for (char c : c1) {
                while(r!=ReadyToRun.T1){}
                System.out.println(c);
                r=ReadyToRun.T2;
            }
        },"t1").start();

        new Thread(()->{
            for (char c : c2) {
                while(r!=ReadyToRun.T2){}
                System.out.println(c);
                r=ReadyToRun.T1;
            }
        },"t2").start();

    }
}
