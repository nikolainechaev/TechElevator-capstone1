package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemStock {

    Map<Sellable, Integer> items = new HashMap<>();
    final private String DRINK = "Drink";
    final private String GUM = "Gum";
    final private String CANDY = "Candy";
    final private String CHIP = "Chip";
    final private int INITIAL_STOCK = 5;

    public Map<Sellable,Integer> getItems() {

        String filename = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv";
        File f = new File(filename);

        try(Scanner fileReader = new Scanner(f)){

            while(fileReader.hasNextLine()){

                String lineOfText = fileReader.nextLine();
                String[] values = lineOfText.split("\\|");
                String slot = values[0];
                String name = values[1];
                String cost = values[2];
                String type = values[3];
                BigDecimal num = new BigDecimal(cost);

//                double num = Double.parseDouble(cost);

                if(type.equals(DRINK)){

                    Drink d = new Drink();
                    d.setName(name);
                    d.setSlotNumber(slot);
                    d.setPrice(num);
                    items.put(d,INITIAL_STOCK);

                } else if(type.equals(GUM)){

                    Gum g = new Gum();
                    g.setName(name);
                    g.setSlotNumber(slot);
                    g.setPrice(num);
                    items.put(g,INITIAL_STOCK);

                } else if(type.equals(CANDY)){

                    Candy c = new Candy();
                    c.setName(name);
                    c.setSlotNumber(slot);
                    c.setPrice(num);
                    items.put(c,INITIAL_STOCK);

                } else if(type.equals(CHIP)){
                    Chip c = new Chip();
                    c.setName(name);
                    c.setSlotNumber(slot);
                    c.setPrice(num);
                    items.put(c,INITIAL_STOCK);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File cannot be found");
        }

        return items;
    }
}