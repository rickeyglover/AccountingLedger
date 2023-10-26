package com.pluralsight;
import java.io.IOException;
import static com.pluralsight.Home.*;
public class Main {
    public static void main(String[] args) throws IOException{
        Reader.readTransactions();
        Home.display();
    }
}
