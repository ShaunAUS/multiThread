package com.example.java_adv1.thread.join;

import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;

//join 특정시간 만큼만 대기
public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log("=========메인 시작========");

        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1, "thread-1");
        Thread thread2 = new Thread(sumTask2, "thread-2");
        thread1.start();
        thread2.start();

        thread1.join(1000);
        thread2.join(1000);

        log("sumTask1.result = " + sumTask1.result);
        log("sumTask2.result = " + sumTask2.result);

        int sumAll = sumTask1.result + sumTask2.result;
        log("sumTaks1 + sumTask2 = " + sumAll);

        log("==============메인 끝 =================");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            result = sum;

            log("작업끝 result =" + sum);
        }
    }
}
