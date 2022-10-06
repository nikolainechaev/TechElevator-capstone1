package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PurchaseMenu {

    private Map<Sellable, Integer> itemsStock;
    private List<Sellable> items;
    private UserChoice uc = new UserChoice();
    private Balance b = new Balance();

    public PurchaseMenu(Map<Sellable, Integer> stock, List<Sellable> items){

        this.items = items;
        this.itemsStock = stock;

    }

    public void displayPurchaseMenu(){

        System.out.printf("Current Money Provided: $%.2f\n",b.getBalance());
        System.out.println();
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();

        int num = uc.getMenuChoice();

        if(num==1) {
            System.out.println("How much money do you want to deposit?");
            int number = uc.moneyDeposited();
            b.depositMoney(number);
            displayPurchaseMenu();
        }

        if(num == 2){

            for(Sellable s : items){
                System.out.printf("%s - %s - %.2f\n", s.getSlotNumber(), s.getName(), s.getPrice());
            }

            System.out.println("Enter Code: ");
            String slot = uc.slotChosen();

            for(Sellable key : itemsStock.keySet()){

                if(key.getSlotNumber().equals(slot)){

                    if(itemsStock.get(key) == 0){

                        System.out.println("Sorry, Item out of Stock!");
                        displayPurchaseMenu();

                    } else if(b.getBalance() < key.getPrice()){

                        System.out.println("Sorry, not enough money");
                        displayPurchaseMenu();

                    } else{

                        b.purchaseMade(key.getPrice());
                        System.out.printf("%s - %.2f - %.2f\n", key.getName(), key.getPrice(), b.getBalance());
                        int stock = itemsStock.get(key);
                        itemsStock.put(key, stock -1);
                        displayPurchaseMenu();

                    }

                }

            }

        }

    }

}
