package org.wrf.juc;

import java.sql.SQLOutput;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  ExchangerDemo <br>
 *
 * @className: ExchangerDemo
 * @package: org.wrf.juc
 * @author: knight
 * @date: 2020-05-15 22:23:10
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            try {
                String girl= exchanger.exchange("我其实暗恋你很久了.....");
                System.out.println("女生说："+girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                System.out.println("女生正在慢慢从教室走出来.....");
                String boy=exchanger.exchange("我很喜欢你");
                System.out.println("男生说："+boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
