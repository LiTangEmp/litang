package com.hyx.threadtest;

import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/**
 * 类CallableTest的测试类
 * 实现Callable实现多线程
 **/

public class Test3 {
    public static void main(String[] args){
        //创建Callable任务
        CallableTest t1 = new CallableTest(1);
        CallableTest t2 = new CallableTest(2);
        //将Callable包装成Runnabl额，因为Thread需要R而不是C
        //结果类型是一个Integer
        FutureTask<Integer> ft1 = new FutureTask<>(t1);
        FutureTask<Integer> ft2 = new FutureTask<>(t2);
        //创建并启动线程
        Thread thread1 = new Thread(ft1, "线程1");
        Thread thread2 = new Thread(ft2, "线程2");

        thread1.start();
        thread2.start();

        try{
            //打印结果
            System.out.println("thread1结果：" + ft1.get());
            System.out.println("thread2结果：" + ft2.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
