package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainMenu {

    List<Sellable> items = new ArrayList<>();
    Map<Sellable, Integer> itemStock;
    UserChoice uc = new UserChoice();

    //                     Key      Value
    public MainMenu(Map<Sellable, Integer> stock){

        this.itemStock = stock;
        createList();

    }

    public void createList(){

        for (Sellable key : itemStock.keySet()) {
            items.add(key);
        }

    }

    public void displayMainMenu(){

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        int num = uc.getMenuChoice();
        displayMenuLogic(num);
    }

    public void displayItems(){

        for(Sellable s : items){
            System.out.printf("%s - %s - %.2f\n", s.getSlotNumber(), s.getName(), s.getPrice());
        }
    }

    public void displayMenuLogic(int num){

        if(num == 1){
            displayItems();
        } else if(num == 2){

            PurchaseMenu p = new PurchaseMenu(itemStock, items);
            p.displayPurchaseMenu();

        } else{
            System.out.println("Have a good Day!");
        }

    }
}
