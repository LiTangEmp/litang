package com.hyx.threadtest;

import java.util.Random;

/**
 * 表示一个发红包的线程类，继承自Thread类。
 * 红包总金额和红包个数为静态变量，所有线程共享。
 * 红包金额随机分配，保证每个红包金额不小于MIN值。
 */

public class RedPacket extends Thread{//继承Thread的方式实现多线程
    static double money = 100;//红包总金额
    static int count = 4;//红包个数

    static final double MIN = 0.01;//红包最小值

    /**
     * 抢红包的逻辑。
     * 当红包未被抢完时，计算并分配一个红包金额，然后减少剩余红包个数。
     * 抢到最后一个红包时，金额为剩余总金额。
     */


    @Override
    public void run() {
        synchronized (RedPacket.class){//synchronized关键字确保同一时间只有一个线程能执行run（）方法
            if (count == 0){
                System.out.println("红包已经抢完");
            }else {
                double prize = 0;
                if (count == 1){
                    prize = money;
                }else {
                    Random random = new Random();
                    double bounds = money - (count - 1) * MIN;//计算随机金额的范围
                    prize = random.nextDouble(bounds);//生成范围内的金额
                    if (prize < MIN){
                        prize = MIN;
                    }
                }
                money = money - prize;//减少剩余金额
                count--;
                System.out.println(getName() + "抢到" + prize);
            }
        }
    }

}
