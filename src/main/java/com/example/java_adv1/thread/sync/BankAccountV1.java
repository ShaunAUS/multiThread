package com.example.java_adv1.thread.sync;


import static com.example.java_adv1.thread.util.MyLogger.log;
import static java.lang.Thread.sleep;

public class BankAccountV1 implements BankAccount {

    volatile private int balance;

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

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

        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}