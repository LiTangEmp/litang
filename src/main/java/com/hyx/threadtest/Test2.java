package com.hyx.threadtest;
/**
 *类Runnable的测试类
 * 通过实现Runnable接口实现多线程
 **/

public class Test2 {
    public static void main(String[] args) {

        Thread t1 = new Thread(new RunnableTest(1), "线程1");
        Thread t2 = new Thread(new RunnableTest(2), "线程2");

        t1.start();
        t2.start();
    }
}
