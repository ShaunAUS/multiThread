package com.example.java_adv1.thread.sync.test;


import static com.example.java_adv1.thread.util.MyLogger.log;

public class SyncTest2Main {
    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }

    //지역변수는 쓰레드의 개인 스택에 올라감으로 동시성 이슈 안생겨남
    //스택영역은 각각의 쓰레드들의 개인 저장공간
    static class MyCounter {

        public void count() {
            int localValue = 0; // 지역변수!
            for (int i = 0; i < 1000; i++) {
                localValue = localValue + 1;
            }
            log("결과: " + localValue);
        }
    }

}