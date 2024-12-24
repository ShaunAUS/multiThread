package com.example.java_adv1.thread.start;

public class HelloThread extends Thread {


    //이게 호출될때 쓰레드 스택영역이 생기며 그위로 스택 프레임 이 쌓이게 된다
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
