package com.pluralsight;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        //calling readTransactions method from the Reader class
        Reader.readTransactions();
        //calling display method from the Home class
        Home.display();
    }
}
