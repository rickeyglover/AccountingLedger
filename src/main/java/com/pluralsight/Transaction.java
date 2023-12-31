package com.pluralsight;

//calling all classes needed for date and time
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    //declaring variables
    LocalDate date;
    LocalTime time;
    String description;
    String vendor;
    Double amount;

    //creating object to format time in that pattern
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    //constructor
    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String transactionDescription, String transactionVendor, double transactionAmount) {
        this.date = transactionDate;
        this.time = transactionTime;
        this.description = transactionDescription;
        this.vendor = transactionVendor;
        this.amount = transactionAmount;
    }

    //getters and setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDateTime getDateTime(){
        return LocalDateTime.of(this.getDate(), LocalTime.parse(this.getTime()));
    }

    public String getTime() {
        return time.format(fmt);
    }
    public void setTime(LocalTime time){
        this.time = time;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getVendor(){
        return vendor;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
}
