package com.example.java_adv1.thread.start;

import static com.example.java_adv1.thread.util.MyLogger.log;

//익명 클래스를 활용한 runnable 구현
public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        log("main start()");


        Thread thread = new Thread(() -> log("run()"));
        thread.start();

        log("main end()");
    }


}
