package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
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
        req.setName(scanner.next());
        System.out.println("Enter customer email");
        req.setEmail(scanner.next());
        System.out.println("Enter customer phone");
        req.setPhone(scanner.next());
        System.out.println("Enter customer address");
        req.setAddress(scanner.next());

        CustomerServiceImp cs = new CustomerServiceImp();
        cs.registerCustomer(req);

    }

    public static void getCustomer()
    {
        System.out.println("Search customer details");
        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
        System.out.println("Enter Email : ");
        customerProfileReq.setEmail(scanner.next());
        System.out.println("Enter Phone : ");
        customerProfileReq.setPhone(scanner.next());


        CustomerServiceImp cs = new CustomerServiceImp();
        CustomerProfileRes resp = cs.getCustomerProfile(customerProfileReq);

        System.out.println(resp.toString());

    }

    public static void updateCustomer(){

    }

    public static void deleteCustomer(){

    }

}
