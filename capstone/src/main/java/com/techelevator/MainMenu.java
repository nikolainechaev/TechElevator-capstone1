package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainMenu {

    private List<Sellable> items = new ArrayList<>();
    private Map<Sellable, Integer> itemStock;
    final private UserChoice uc = new UserChoice();

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
        System.out.println("(4) Sales Report");

        int num = uc.getMainMenuChoice();
        displayMenuLogic(num);
    }

    public void displayItems(){

        for(Sellable s : items){
            System.out.printf("%s - %s - %.2f\n", s.getSlotNumber(), s.getName(), s.getPrice());
        }
        System.out.println();
        displayMainMenu();
    }

    public void displayMenuLogic(int num){

        if(num == 1){
            displayItems();

        } else if(num == 2){

            PurchaseMenu p = new PurchaseMenu(itemStock, items);
            p.displayPurchaseMenu();

        } else if(num == 3){

            System.out.println("Have a good Day!");
            System.exit(0);

        } else{
            salesReport();
        }
    }

    public void salesReport(){

        int initialStock = 5;
        BigDecimal totalSales = BigDecimal.ZERO;

        for(Sellable key : itemStock.keySet()){

            int itemsSold = initialStock - itemStock.get(key);
            BigDecimal price = key.getPrice();
            BigDecimal i = new BigDecimal(itemsSold);

            price = price.multiply(i);
            totalSales = totalSales.add(price);

            System.out.println(key.getName() + " | " + itemsSold);
        }
        System.out.println();
        System.out.printf("**TOTAL SALES** $%.02f\n",totalSales);
        System.out.println();
        displayMainMenu();
    }

}
