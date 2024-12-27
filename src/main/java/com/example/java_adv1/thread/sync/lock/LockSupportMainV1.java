package com.example.java_adv1.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;


//lockSupport 는 스레드를 `WAITING` 상태로 변경
public class LockSupportMainV1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 준다.
        sleep(100);
        log("Thread-1 state: " + thread1.getState());

        log("main -> unpark(Thread-1)");

        // 1. unpark 사용 ->해당 쓰레드가 wating상태이기 때문에 혼자 못깨어남, uppart으로 wating 에서 runnable로 상태변경
        // 대기 중인 다른 스레드를 깨우는 것
        LockSupport.unpark(thread1);


        //thread1.interrupt(); // 2. interrupt() 사용, -> watting 상태에서 Runnable로 변경
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
