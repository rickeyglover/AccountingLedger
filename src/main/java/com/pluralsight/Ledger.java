package com.pluralsight;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static com.pluralsight.Home.myScanner;
import static com.pluralsight.Home.TRANSACTION;
import static com.pluralsight.Home.*;

public class Ledger {

    public static ArrayList<Transaction> sortedTransaction = new ArrayList<>(TRANSACTION);
    public static void display() throws IOException{
        Reader.readTransactions();
        sortedTransaction.sort(Collections.reverseOrder(Comparator.comparing(Transaction::getDate)));

        while(true){
            System.out.println("What would you like to do?");
            System.out.println("\t(1) Display all entries");
            System.out.println("\t(2) Deposits");
            System.out.println("\t(3) Payments");
            System.out.println("\t(4) Reports");
            System.out.println("\t(5) Home");

            System.out.println("Make your selection: ");
            String userInput = myScanner.nextLine().trim().toUpperCase();

            switch (userInput){
                case "1":
                    displayAll();
                    break;
                case "2":
                    displayDeposit();
                    break;
                case "3":
                    displayPayments();
                    break;
                case "4":
                    displayReports();
                    break;
                case "5":
                    Home.display();
                    break;
                default:
                    System.out.println("Error, try again.");
            }
        }
    }
    public static void displayAll(){
        for(Transaction t : sortedTransaction){
            System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount $%.2f\n",
                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
        }
    }
    public static void displayDeposit(){
        for(Transaction t : sortedTransaction){
            if(t.amount > 0) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount $%.2f\n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        }
    }
    public static void displayPayments(){
        for(Transaction t : sortedTransaction){
            if(t.amount < 0){
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f\n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            }
        }
    }
    public static void displayReports() throws IOException{
        while (true) {
            System.out.println("\t(1) Month to Date");
            System.out.println("\t(2) Previous Month");
            System.out.println("\t(3) Year to Date");
            System.out.println("\t(4) Previous Year");
            System.out.println("\t(5) Search by Vendor");
            System.out.println("\t(6) Back to Ledger");
            System.out.println("\t(7) Home");

            System.out.print("Make your selection: ");
            String userChoice = myScanner.nextLine().trim();

            switch (userChoice) {
                case "1":
                    displayMonthToDate();
                    break;

                case "2":
                    displayPreviousMonth();
                    break;
                case "3":
                    //displayYearToDate();
                    break;
                case "4":
                    //PreviousYear();
                    break;
                case "5":
                    //SearchVendor();
                    break;
                case "6":
                    //BackToLedger();
                    break;
                case "7":
                    Home.display();
                    break;
                default:
                    System.out.println("Error, try again");

            }
        }

    }
    public static LocalDate today = LocalDate.now();
    public static Month currentMonth = Month.from(today);
    public static Year currentYear = Year.from(today);
    public static Month previousMonth = currentMonth.minus(1);
    public static Year previousYear = currentYear.minusYears(1);


    public static void displayMonthToDate(){
        for(Transaction t : sortedTransaction){
            LocalDate transactionDate = t.getDate();
            Year transactionYear = Year.from(transactionDate);
            Month transactionMonth = Month.from(transactionDate);
            if(transactionYear.equals(currentYear) && transactionMonth.equals(currentMonth)){
                System.out.printf("date|%s|time|%s|description|%s|vendor|%s|amount|$%.2f%n",
                        transactionDate, t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());;
            }
        }
    }
    public static void displayPreviousMonth() {
        for (Transaction t : sortedTransaction) {
        }
    }
}
