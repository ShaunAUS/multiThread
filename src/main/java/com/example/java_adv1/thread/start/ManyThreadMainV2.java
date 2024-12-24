package com.example.java_adv1.thread.start;

import static com.example.java_adv1.thread.util.MyLogger.log;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        log("main() start");


        HelloRunnable helloRunnable = new HelloRunnable();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(helloRunnable);
            thread.start();
        }

        log("main() end");
    }
}
