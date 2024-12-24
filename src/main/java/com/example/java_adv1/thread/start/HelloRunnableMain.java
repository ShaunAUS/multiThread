package com.example.java_adv1.thread.start;

public class HelloRunnableMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"Main thread starts ");

        // 작업과 스레드를 분리
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        thread.start();

        System.out.println(Thread.currentThread().getName()+"Main thread ends");
    }
}
