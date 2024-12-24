package com.example.java_adv1.thread.start;

import static com.example.java_adv1.thread.util.MyLogger.log;


//중첩클래스를 활용한 runnable 구현
public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main start()");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        log("main end()");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()o");
        }
    }

}
