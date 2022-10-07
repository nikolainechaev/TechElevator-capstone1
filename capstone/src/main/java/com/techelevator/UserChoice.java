package com.techelevator;

import java.util.Scanner;

public class UserChoice {

    Scanner userInput = new Scanner(System.in);
    private int choice = 0;
    private String slot = "";

    public int getMenuChoice(){

        String input = userInput.nextLine();

        try{

            choice = Integer.parseInt(input);

            if(choice > 3 || choice < 1){
                System.out.println("please enter a number 1-3");
                getMenuChoice();
            }
        } catch (IllegalArgumentException e){

            System.out.println("please enter a number 1-3");
            getMenuChoice();
        }

       return choice;
    }

    public int moneyDeposited() {
        String m = userInput.nextLine();
        try {
            choice = Integer.parseInt(m);
            if (choice < 1) {
                System.out.println("Must be at least 1");
                moneyDeposited();
            }

        }catch(IllegalArgumentException e){
            System.out.println("Must be at least 1");
            moneyDeposited();
        }
        return choice;

    }

    public String slotChosen(){
        slot = userInput.nextLine();

        return slot;
    }

    public int getMainMenuChoice(){

        String input = userInput.nextLine();

        try{

            choice = Integer.parseInt(input);

            if(choice > 4 || choice < 1){
                System.out.println("please enter a number 1-4");
                getMainMenuChoice();
            }
        } catch (IllegalArgumentException e){

            System.out.println("please enter a number 1-4");
            getMainMenuChoice();
        }

        return choice;
    }

}
