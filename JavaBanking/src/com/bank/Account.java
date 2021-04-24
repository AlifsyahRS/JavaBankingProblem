package com.bank;

public class Account{

    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public boolean deposit(double amt){
        if(amt <= 0){
            return false;
        } else {
            balance += amt;
            return true;
        }
    }

    public boolean withdraw(double amt){
        balance -= amt;
        if (balance < 0 || amt <= 0){
            balance += amt;
            return false;
        } else {
            return true;
        }
    }

}