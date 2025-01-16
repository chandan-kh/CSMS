package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.impl.CustomerServiceImp;

import java.util.Scanner;

public class UI {

    private static Scanner scanner  = new Scanner(System.in);
    public static void addCustomer()
    {
        System.out.println("U Can Add Customer Here");
        AddCustomerReq req = new AddCustomerReq();

        System.out.println("Enter customer name");
        req.setName(scanner.nextLine().trim());
        System.out.println("Enter customer email");
        req.setEmail(scanner.nextLine().trim());
        System.out.println("Enter customer phone");
        req.setPhone(scanner.nextLine().trim());
        System.out.println("Enter customer address");
        req.setAddress(scanner.nextLine().trim());

        CustomerServiceImp cs = new CustomerServiceImp();
        String resp = cs.registerCustomer(req);

        System.out.println(resp);

    }

    public static void getCustomer()
    {
        System.out.println("Search customer details using email or phone");
        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
        System.out.println("Enter Email : ");
        customerProfileReq.setEmail(scanner.nextLine().trim());
        System.out.println("Enter Phone : ");
        customerProfileReq.setPhone(scanner.nextLine().trim());


        CustomerServiceImp cs = new CustomerServiceImp();
        CustomerProfileRes resp = cs.getCustomerProfile(customerProfileReq);

        System.out.println(resp.toString());

    }

    public static void updateCustomer(){

        System.out.println("Enter customer phone or email which you want to update :  ");
        System.out.println("(Note : If u want to keep any feild with same value then leave it blank !!) :  ");
        UpdateCustomerReq req = new UpdateCustomerReq();
        System.out.println("Enter Phone : ");
        req.setCurrPhone(scanner.nextLine().trim());
        System.out.println("Enter Email : ");
        req.setCurrEmail(scanner.nextLine().trim());

        System.out.println("Enter the updated details : ");
        System.out.println("Enter Name : ");
        req.setName(scanner.nextLine().trim());
        System.out.println("Enter Phone : ");
        req.setPhone(scanner.nextLine().trim());
        System.out.println("Enter Email : ");
        req.setEmail(scanner.nextLine().trim());
        System.out.println("Enter Address : ");
        req.setAddress(scanner.nextLine().trim());

        CustomerServiceImp cs = new CustomerServiceImp();
        String resp = cs.updateCustomer(req);

        System.out.println(resp);

    }

    public static void deleteCustomer(){

        System.out.println("Delete customer details using email or phone");
        DeleteCustomerReq deleteCustomerReq = new DeleteCustomerReq();
        System.out.println("Enter Email : ");
        deleteCustomerReq.setEmail(scanner.nextLine().trim());
        System.out.println("Enter Phone : ");
        deleteCustomerReq.setPhone(scanner.nextLine().trim());

        CustomerServiceImp cs = new CustomerServiceImp();
        String resp = cs.deleteCustomer(deleteCustomerReq);

        System.out.println(resp);

    }

}
