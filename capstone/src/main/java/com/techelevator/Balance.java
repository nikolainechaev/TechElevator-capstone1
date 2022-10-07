package com.techelevator;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void depositMoney(BigDecimal num){
        balance = balance.add(num);
    }

    public void purchaseMade(BigDecimal price){
        balance = balance.subtract(price);
    }

    public void getChange(){
        BigDecimal quarterValue = new BigDecimal(".25");
        BigDecimal dimeValue = new BigDecimal(".1");
        BigDecimal nickelValue = new BigDecimal(".05");
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while(balance.compareTo(quarterValue) >= 0){
            quarters++;
            balance = balance.subtract(quarterValue);
        }

        while (balance.compareTo(dimeValue) >= 0){
            dimes++;
            balance = balance.subtract(dimeValue);
        }

        while (balance.compareTo(nickelValue) >= 0){
            nickels++;
            balance = balance.subtract(nickelValue);
        }

        System.out.println("Your Change is:");
        System.out.printf("Quarters - %d\nDimes - %d\nNickels - %d\n", quarters, dimes, nickels);
    }

}

