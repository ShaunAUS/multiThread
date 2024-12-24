package com.example.java_adv1.thread.start;

import static com.example.java_adv1.thread.util.MyLogger.log;

//익명 클래스를 활용한 runnable 구현
public class InnerRunnableMainV3 {

    public static void main(String[] args) {
        log("main start()");


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });
        thread.start();

        log("main end()");
    }


}
