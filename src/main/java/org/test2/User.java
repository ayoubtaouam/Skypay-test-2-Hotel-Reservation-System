package org.test2;

public class User {
    private final int id;
    private int balance;

    public User(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public int getId() {
        return id;
    }
}
