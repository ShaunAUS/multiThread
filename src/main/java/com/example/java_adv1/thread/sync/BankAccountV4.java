package com.example.java_adv1.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;


public class BankAccountV4 implements BankAccount {

    private int balance;

    //구현체
    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        // ReentrantLock 이용하여 lock을 걸기
        //여기서 사용하는 락은 객체 내부에 있는 모니터 락이 아니다! `Lock` 인터페이스와 `ReentrantLock` 이 제공하는 기능임
        //모니터 락과 `BLOCKED` 상태는 `synchronized` 에서만 사용된다.
/*
        스레드에 인터럽트가 발생하면 순간 대기 상태를 빠져나오는 것은 맞다.
        그래서 아주 짧지만 `WAITING` `RUNNABLE` 이 된다. 그런데 `lock()` 메서드 안에서 해당 스레드를 다시
        `WAITING` 상태로 강제로 변경해버린다. 이런 원리로 인터럽트를 무시하는 것이다
*/

        lock.lock();
        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            // 잔고가 출금액 보다 많으면, 진행
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            try {
                sleep(1000); // 출금에 걸리는 시간으로 가정
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        } finally {
            lock.unlock(); // ReentrantLock 이용하여 lock 해제
        }
        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock(); // ReentrantLock 이용하여 lock을 걸기
        try {
            return balance;
        } finally {
            lock.unlock(); // ReentrantLock 이용하여 lock 해제
        }
    }
}
