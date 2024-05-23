package com.hyx.threadtest;

public class RunnableTest implements Runnable{

    private int count = 10;

    public RunnableTest(int count){//实现Runnable接口实现多线程
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ":" + count--);
        }
    }
}
