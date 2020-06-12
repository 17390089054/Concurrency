package org.wrf.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 模拟银行转账<br>
 *
 * @className: Account
 * @package: org.wrf.synchronize
 * @author: knight
 * @date: 2020-05-02 11:04:11
 */
public class Account {
    private String name;
    private double balance;

    public synchronized void set(String name,double balance){
        this.name=name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }

    //不加synchronized关键字可能会产生脏读
    public synchronized double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account account=new Account();
        new Thread(()->account.set("zhangshan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangshan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("zhangshan"));
    }
}

