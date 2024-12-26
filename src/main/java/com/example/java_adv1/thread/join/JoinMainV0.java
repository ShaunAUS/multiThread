package com.example.java_adv1.thread.join;

import javax.swing.plaf.TableHeaderUI;
import java.util.SimpleTimeZone;

import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;

public class JoinMainV0 {

    public static void main(String[] args) {
        log("start");

        Thread thread1 = new Thread(new Job());
        Thread thread2 = new Thread(new Job());

        thread1.start();
        thread2.start();

        log("end");
    }

    static class Job implements Runnable {
        @Override
        public void run() {
            log("작업시작");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("작업끝");
        }
    }
}
