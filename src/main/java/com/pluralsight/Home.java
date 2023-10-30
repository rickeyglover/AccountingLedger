package com.pluralsight;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.text.DecimalFormat;


public class Home {
    //declaring static variables

    public static Scanner myScanner = new Scanner(System.in);
    //takes user inputs
    public static ArrayList<Transaction> transactionA = new ArrayList<>();
    //stores instances of the Transaction class
    public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
    //for time formatting
    public static DecimalFormat df = new DecimalFormat("0.00");
    //for formatting decimal numbers

    //display method to main menu
    public static void display() throws IOException{

        //prompts user for input
        while(true){
            System.out.println("Welcome to Michael & Lewis");
            System.out.println("\t(D) - Add Deposit");
            System.out.println("\t(P) - Make a Payment(Debit)");
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
        //method for adding deposit
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
    //method for making payment
    public static void makePayment() throws IOException{
        System.out.println("What's the name of item ");
        String description = myScanner.nextLine().trim();

        System.out.println("What's the name of the vendor ");
        String vendor = myScanner.nextLine().trim();

        System.out.println("What's the amount? ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();
        //multiply by negative 1 to show negative values for payments
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
