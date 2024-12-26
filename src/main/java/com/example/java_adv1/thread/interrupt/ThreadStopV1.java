package com.example.java_adv1.thread.interrupt;

import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class ThreadStopV1 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();

        sleep(4000);
        log("작업중단 지시, runFlag=false");
        task.runFlag = false;
        log("작업종료");


    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("작업중");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }


    }


}
