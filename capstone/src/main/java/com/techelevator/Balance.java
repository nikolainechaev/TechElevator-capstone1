package com.techelevator;

public class Balance {

    private double balance = 0;

    public double getBalance(){
        return this.balance;
    }

    public void depositMoney(int num){
        balance += num;
    }

    public void purchaseMade(double price){
        this.balance -= price;
    }

}
