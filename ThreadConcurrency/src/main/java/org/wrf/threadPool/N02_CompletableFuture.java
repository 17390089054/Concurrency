package org.wrf.threadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture基本用法 <br>
 *
 * @className: N02_CompletableFuture
 * @package: org.wrf.threadPool
 * @author: knight
 * @date: 2020-06-03 22:53:52
 */
public class N02_CompletableFuture {
    public static void main(String[] args) {
        long start,end;
 /*       start=System.currentTimeMillis();
        priceOfTM();
        priceOfTB();
        priceOfJD();
        end=System.currentTimeMillis();
        System.out.println("use serial method call!"+(end-start));*/

        start=System.currentTimeMillis();
        CompletableFuture<Double> futureTM=CompletableFuture.supplyAsync(()->priceOfTM());
        CompletableFuture<Double> futureTB=CompletableFuture.supplyAsync(()->priceOfTB());
        CompletableFuture<Double> futureJD=CompletableFuture.supplyAsync(()->priceOfJD());
        CompletableFuture.allOf(futureTM,futureTB,futureJD).join();

        CompletableFuture.supplyAsync(()->priceOfTM()).
                thenApply(String::valueOf)
                .thenApply(str->"price"+str)
                .thenAccept(System.out::println);

        end=System.currentTimeMillis();
        System.out.println("use completable future!"+(end-start));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double priceOfJD() {
        delay();
        return 3.00;
    }

    private static double priceOfTB() {
        delay();
        return 2.00;
    }

    private static double priceOfTM() {
        delay();
        return 1.00;
    }

    private static void delay() {
        int time=new Random().nextInt(500);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep!\n",time);
    }
}
