package com.pluralsight;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.text.DecimalFormat;


public class Home {
    public static Scanner myScanner = new Scanner(System.in);
    public static ArrayList<Transaction> TRANSACTION = new ArrayList<>();
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void display() throws IOException{

        //readTransactions();

        while(true){
            System.out.println("Welcome to Michael & Lewis");
            System.out.println("\t(D) - Add Deposit");
            System.out.println("\t(P) - Make a Payment(Debit)");;
            System.out.println("\t(L) - Ledger");
            System.out.println("\t(X) - Exit");

            System.out.println("Make a selection: ");
            String userInput = myScanner.nextLine().trim().toUpperCase();

            switch (userInput) {
                case "D":
                    addDeposit();
                    break;

                case "P":
                    makePayment();
                    break;

                case "L":
                    Ledger.display();
                    break;

                case "X":
                    System.exit(0);
                default:
                    System.out.println("Error, try again");
            }
        }
    }

    public static void addDeposit()throws  IOException{
        System.out.println("Name of the deposit? ");
        String description = myScanner.nextLine().trim();

        System.out.println("The name of the vendor? ");
        String vendor = myScanner.nextLine().trim();

        System.out.println("The amount? ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();
        String amountFormatted = df.format(amount);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));

        String date = String.valueOf(LocalDate.now());
        String time = fmt.format(LocalTime.now());

        bufferedWriter.newLine();
        bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amountFormatted);
        bufferedWriter.close();



    }
    public static void makePayment() throws IOException{
        System.out.println("What's the name of item ");
        String description = myScanner.nextLine().trim();

        System.out.println("What's the name of the vendor ");
        String vendor = myScanner.nextLine().trim();

        System.out.println("What's the amount? ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();
        amount *= -1;
        String amountFormatted = df.format(amount);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transactions.csv", true));

        String date = String.valueOf(LocalDate.now());
        String time = fmt.format(LocalTime.now());

        bufferedWriter.newLine();
        bufferedWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amountFormatted);

        bufferedWriter.close();
    }
}
