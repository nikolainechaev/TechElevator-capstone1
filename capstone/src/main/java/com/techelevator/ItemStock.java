package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemStock {

    Map<Sellable, Integer> items = new HashMap<>();
    final private String DRINK = "Drink";
    final private String GUM = "Gum";
    final private String CANDY = "Candy";
    final private String CHIP = "Chip";

    public Map<Sellable,Integer> getItems() {

        String filename = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv";
        File f = new File(filename);

        try(Scanner fileReader = new Scanner(f)){

            while(fileReader.hasNextLine()){

                String lineOfText = fileReader.nextLine();
                String[] values = lineOfText.split("\\|");

                double num = Double.parseDouble(values[2]);

                if(values[3].equals(DRINK)){

                    Drink d = new Drink();
                    d.setName(values[1]);
                    d.setSlotNumber(values[0]);
                    d.setPrice(num);
                    items.put(d,5);

                } else if(values[3].equals(GUM)){

                    Gum g = new Gum();
                    g.setName(values[1]);
                    g.setSlotNumber(values[0]);
                    g.setPrice(num);
                    items.put(g,5);

                } else if(values[3].equals(CANDY)){

                    Candy c = new Candy();
                    c.setName(values[1]);
                    c.setSlotNumber(values[0]);
                    c.setPrice(num);
                    items.put(c,5);

                } else if(values[3].equals(CHIP)){
                    Chip c = new Chip();
                    c.setName(values[1]);
                    c.setSlotNumber(values[0]);
                    c.setPrice(num);
                    items.put(c,5);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File cannot be found");
        }

        return items;
    }

}
