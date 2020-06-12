package org.wrf.huawei;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 华为面试题 <br>
 * 两个线程，第一个线程是从1到26，第二个线程是从A到一直到Z，
 * 然后要让这两个线程做到同时运行，交替输出，顺序打印。
 * PipedStream 实现交替输出
 * @className: H09_PipedStream
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 22:02:08
 */
public class H09_PipedStream {
    public static void main(String[] args) throws IOException {
        char []c1="123456".toCharArray();
        char []c2="ABCDEF".toCharArray();

        PipedInputStream input1=new PipedInputStream();
        PipedInputStream input2=new PipedInputStream();
        PipedOutputStream output1=new PipedOutputStream();
        PipedOutputStream output2=new PipedOutputStream();

        input1.connect(output2);
        input2.connect(output1);

        String msg="Your Turn";

        new Thread(()->{
            byte[] buffer=new byte[9];
            try{
                for (char c : c1) {
                    input1.read(buffer);
                    if(new String(buffer).equals(msg)){
                        System.out.println(c);
                    }
                    output1.write(msg.getBytes());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            byte[] buffer=new byte[9];
            try{
                for (char c : c2) {
                    System.out.println(c);
                    output2.write(msg.getBytes());
                    input2.read(buffer);
                    if(new String(buffer).equals(msg)){
                        continue;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();
    }

}
