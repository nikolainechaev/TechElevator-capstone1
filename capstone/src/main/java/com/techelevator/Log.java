package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Log {

    final private String filename = "C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\Log.txt";
    final private File f = new File(filename);

    public void writeToFile(String action, BigDecimal deposit, BigDecimal remainder){

        try(final PrintWriter writer = new PrintWriter(new FileOutputStream(f,true))){

            LocalDateTime date = LocalDateTime.now();

            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            int hour = date.getHour();

            String morningOrNight = "";

            if(hour >= 12){
                morningOrNight = "PM";

            } else{
                morningOrNight = "AM";
            }

            hour %= 12;

            if(hour == 0){
                hour = 12;
            }

            int minute = date.getMinute();
            int second = date.getSecond();

            writer.printf("%02d/%02d/%d %02d:%02d:%02d %s %s $%.02f $%.02f\n",month,day,year,hour,minute,second,morningOrNight,action,deposit,remainder);

        } catch (FileNotFoundException e){
            System.out.println("File cannot be found");
        }

    }

}
