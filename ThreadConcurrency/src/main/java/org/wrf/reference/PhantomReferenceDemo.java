package org.wrf.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用PhantomReference <br>
 *
 * @className: PhantomReferenceDemo
 * @package: org.wrf.reference
 * @author: knight
 * @date: 2020-05-24 23:12:28
 */
public class PhantomReferenceDemo {
    private static final List<Object> LIST=new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE=new ReferenceQueue<>();
    public static void main(String[] args) {
        PhantomReference<M> phantomReference=new PhantomReference<>(new M(),QUEUE);
        new Thread(()->{
            while(true){
                LIST.add(new byte[1024*1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        new Thread(()->{
            while(true){
                Reference<? extends M> poll=QUEUE.poll();
                if(poll !=null){
                    System.out.println("-----虚引用对象被JVM回收了-----"+poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
