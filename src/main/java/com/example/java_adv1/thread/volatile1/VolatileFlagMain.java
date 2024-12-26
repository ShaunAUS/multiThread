package com.example.java_adv1.thread.volatile1;


import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;

//volatile 사용시 캐시메모리가 아닌 메인메모리에서 값을 읽어옴
public class VolatileFlagMain {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
        //boolean runFlag = true;
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
