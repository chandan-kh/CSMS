package com.cars24.runner;

import com.cars24.config.DbConfig;
import com.cars24.dao.impl.CustomerDaoImp;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.services.impl.CustomerServiceImp;
import com.cars24.util.DbUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){

        System.out.println("Application Start");
        DbUtil.getDbConnection();

//        CustomerDaoImp c2 = new CustomerDaoImp();
//        c2.createCustomer("Shreyass" , "1234442324", "shreyas@gmail.com","Near Cars24 College");

//        AddCustomerReq addCustomerReq = new AddCustomerReq();
//        addCustomerReq.setName("");
//        addCustomerReq.setPhone("6756734823");
//        addCustomerReq.setEmail("tejas@gmail.com");
//        addCustomerReq.setAddress("Near HSR Layout");

//        CustomerServiceImp cs = new CustomerServiceImp();
//        cs.registerCustomer(addCustomerReq);


        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
        customerProfileReq.setEmail("john.doe@example.com");
        customerProfileReq.setPhone("9876543210");

        CustomerDaoImp cs1 = new CustomerDaoImp();
        cs1.getCustomer(customerProfileReq);

        System.out.println("Application Stoped");

    }
}
