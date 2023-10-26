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

            System.out.print("Make a selection: ");
            String userInput = myScanner.next().trim().toUpperCase();

            switch (userInput) {
                case "D":
                    addDeposit();
                    break;

                case "P":
                    makePayment();
                    break;

                //case "L":
                   // Ledger.display();

                case "X":
                    myScanner.close();
                    return;
                default:
                    System.out.println("Error, try again");
            }
        }
    }
    public static void readTransactions() throws IOException {
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
    public static void addDeposit()throws  IOException{
        System.out.print("Name of the deposit ");
        String description = myScanner.next().trim();

        System.out.print("The name of the vendor? ");
        String vendor = myScanner.next().trim();

        System.out.print("The amount? ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();
        String amountFormatted = df.format(amount);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resoursces/transactions.csv", true));

        String date = String.valueOf(LocalDate.now());
        String time = fmt.format(LocalTime.now());

        bufferedWriter.write(date + "" + time + "" + description + "" + vendor + "" + amountFormatted + "\n");
        bufferedWriter.close();



    }
    public static void makePayment() throws IOException{
        System.out.print("What's the name of item");
        String description = myScanner.next().trim();

        System.out.print("What's the name of the vendor");
        String vendor = myScanner.next().trim();

        System.out.print("What's the amount? ");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();
        amount *= -1;
        String amountFormatted = df.format(amount);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/transaction.csv", true));

        String date = String.valueOf(LocalDate.now());
        String time = fmt.format(LocalTime.now());

        bufferedWriter.write(date + "" + time + "" + description + "" + vendor + "" + amountFormatted + "\n");

        bufferedWriter.close();
    }
}
