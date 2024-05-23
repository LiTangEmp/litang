package com.hyx.threadtest;

/**
 * RedPacket的测试类
 * 重写run方法实现多线程
 **/

public class Test {
    public static void main(String[] args) {

        RedPacket r1 = new RedPacket();
        RedPacket r2 = new RedPacket();
        RedPacket r3 = new RedPacket();
        RedPacket r4 = new RedPacket();
        RedPacket r5= new RedPacket();

        r1.setName("A");
        r2.setName("B");
        r3.setName("C");
        r4.setName("D");
        r5.setName("E");

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
    }
}
