package com.hyx.threadtest;

import java.util.concurrent.Callable;

public class CallableTest implements Callable {

    private int value;

    public CallableTest(int value)
    {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception{
        //从零加到九
        int a = 0;
        for(int i = 0; i < 10; i++){
            a += i;
        }
        return a;
    }
}
