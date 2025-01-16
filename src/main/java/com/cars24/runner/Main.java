package com.cars24.runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner  = new Scanner(System.in);

        boolean exit = true;
        while(exit){

            System.out.println("Enter choice : 1) Add Customer , 2) Get Customer , 3) Update Customer , 4) Delete Customer , 0) Exit ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0 : exit = false;
                break;
                case 1: UI.addCustomer();
                break;
                case 2 : UI.getCustomer();
                break;
                case 3 : UI.updateCustomer();
                break;
                case 4 : UI.deleteCustomer();
                break;
            }

        }

        return;

    }
}
