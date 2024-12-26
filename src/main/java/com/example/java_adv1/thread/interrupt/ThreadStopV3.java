package com.example.java_adv1.thread.interrupt;

import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;

public class ThreadStopV3 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task,"work");
        thread.start();

        sleep(100);
        log("작업중단 지시 thread interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());


    }

    static class MyTask implements Runnable {


        @Override
        public void run() {

            while(!Thread.currentThread().isInterrupted()) {
                log("작업중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원정리");
                Thread.sleep(1000); // 인터럽트 상태가 true인 상태에서 만나면 예외터짐
                log("자원종료");
            } catch (InterruptedException e) {
                // 여기 들어오면 인터럽트 상태 다시 풀림
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
                log("interrupt message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
        }


    }


}
