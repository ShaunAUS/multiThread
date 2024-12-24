package com.example.java_adv1.thread.start;


public class DaeMonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "Main thread starts ");

        DaeMonThread daeMonThread = new DaeMonThread();
        daeMonThread.setDaemon(true);// 데몬스레드 여부, 데몬스레드는 10초를 기다리지 않고 메인스레드가 종료되버림
        daeMonThread.start();

        System.out.println(Thread.currentThread().getName() + "Main thread ends");


    }

    static class DaeMonThread extends Thread {


        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");

            try {
                Thread.sleep(10000); //10초
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run()");
        }
    }


}
