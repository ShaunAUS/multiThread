package com.example.java_adv1.thread.start;

import static com.example.java_adv1.thread.util.MyLogger.log;

//익명 클래스를 활용한 runnable 구현
public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main start()");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        log("main end()");
    }


}
