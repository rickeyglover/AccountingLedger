package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import static com.pluralsight.Home.*;


public class Reader {
    public static void readTransactions() throws IOException {
        TRANSACTION.clear();
        BufferedReader readFile = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
        String input;
        LocalDate transactionDate;
        LocalTime transactionTime;
        String transactionDescription;
        String transactionVendor;
        double transactionAmount;

        while ((input = readFile.readLine()) != null){
            String[] transactionList = input.split("\\|");
            if (!transactionList[0].equals("date")){
                transactionDate = LocalDate.parse(transactionList[0]);
                transactionTime = LocalTime.parse(transactionList[1]);
                transactionDescription = transactionList[2];
                transactionVendor = transactionList[3];

                if (!transactionList[4].isEmpty()){
                    transactionAmount = Double.parseDouble(transactionList[4]);
                    TRANSACTION.add(new Transaction(transactionDate,transactionTime, transactionDescription, transactionVendor, transactionAmount));
                }

            }
        }
        readFile.close();
    }
}
