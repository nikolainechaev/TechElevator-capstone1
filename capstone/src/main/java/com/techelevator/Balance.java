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

    public void getChange(){
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while(balance > .24){
            quarters++;
            balance -= .25;
        }

        while (balance > .09){
            dimes++;
            balance -= .10;
        }
        while (balance > .04){
            nickels++;
            balance -= .05;
        }
        System.out.println("Your Change is:");
        System.out.printf("Quarters - %d\nDimes - %d\nNickels - %d\n", quarters, dimes, nickels);
    }

}
