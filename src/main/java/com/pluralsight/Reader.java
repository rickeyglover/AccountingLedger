package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import static com.pluralsight.Home.*;


public class Reader {

    //reads transaction data from file
    public static void readTransactions() throws IOException {
        //clears the existing data in the list to make way for the data to read from the csv file
        transactionA.clear();
        BufferedReader readFile = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
        String input;
        LocalDate transactionDate;
        LocalTime transactionTime;
        String transactionDescription;
        String transactionVendor;
        double transactionAmount;

        while ((input = readFile.readLine()) != null){
            //reads each line until there's no more lines
            String[] transactionList = input.split("\\|");
            if (!transactionList[0].equals("date")){
                //skips line that shows format
                transactionDate = LocalDate.parse(transactionList[0]);
                transactionTime = LocalTime.parse(transactionList[1]);
                transactionDescription = transactionList[2];
                transactionVendor = transactionList[3];

                if (!transactionList[4].isEmpty()){
                    //filters out empty values
                    transactionAmount = Double.parseDouble(transactionList[4]);
                    transactionA.add(new Transaction(transactionDate,transactionTime, transactionDescription, transactionVendor, transactionAmount));
                }

            }
        }
        readFile.close();
    }
}
