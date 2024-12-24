package com.example.java_adv1.thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"Main thread starts ");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName()+"Hello thread start호출 전");

        //이게 호출될때 쓰레드 스택영역이 생기며 그위로 스택 프레임 이 쌓이게 된다
        helloThread.start();

        System.out.println(Thread.currentThread().getName()+"Hello thread start호출 후");
        System.out.println(Thread.currentThread().getName()+"Main thread ends");

    }
}
