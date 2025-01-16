package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;


public class CustomerDaoImp implements CustomerDao {

    private final static String  SUCCESS_MESSAGE = "Customer add successfully";
    private final static String ERROR_MESSAGE = "Error while adding customer";

    @Override
//    public String createCustomer(String name, String phone, String email, String address) {
//
//        Connection connection = DbUtil.getDbConnection();
////        String insertSQL =
////                "INSERT INTO customers (name,phone,email,address) VALUES"
////                        + "("+ "'" + name + "' ," + "'" + phone + "' , '" + email + "' ,'" + address + "'" + ");";
////        System.out.println(insertSQL);
//
//        String insertSQL = "INSERT INTO customers (name,phone,email,address) VALUES (?,?,?,?)";
//
//        try{
//            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
//            preparedStatement.setString(1,name);
//            preparedStatement.setString(2,phone);
//            preparedStatement.setString(3,email);
//            preparedStatement.setString(4,address);
//
//            int rowsInserted = preparedStatement.executeUpdate();
////            System.out.println(rowsInserted + " row(s) inserted");
//            return SUCCESS_MESSAGE;
//        }
//
////        try {
////            Statement statement = connection.createStatement();
////            int rowsInserted = statement.executeUpdate(insertSQL);
////            System.out.println(rowsInserted + " row(s) inserted.");
////        }
//            catch (SQLException e){
////            System.out.println("Error while inserting data to customer table " + e);
//            e.printStackTrace();
//            return ERROR_MESSAGE;
//        }

       public String createCustomer(AddCustomerReq addCustomerReq){
           Connection connection = DbUtil.getDbConnection();
           String insertSQL = "INSERT INTO customers (name,phone,email,address) VALUES (?,?,?,?)";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setString(1,addCustomerReq.getName());
                preparedStatement.setString(2, addCustomerReq.getPhone());
                preparedStatement.setString(3, addCustomerReq.getEmail());
                preparedStatement.setString(4, addCustomerReq.getAddress());

                int rowsInserted = preparedStatement.executeUpdate();
    //            System.out.println(rowsInserted + " row(s) inserted");
                return SUCCESS_MESSAGE;
           }
           catch (SQLException e){
               e.printStackTrace();
               return ERROR_MESSAGE;
           }

       }


       public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq){
           Connection connection = DbUtil.getDbConnection();
           String selectSQL = "SELECT name, phone, email, address FROM CUSTOMERS WHERE phone = ? or email = ?";
           try{
               PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
               preparedStatement.setString(1,customerProfileReq.getPhone());
               preparedStatement.setString(2,customerProfileReq.getEmail());

               // Execute query
               ResultSet resultSet = preparedStatement.executeQuery();

               while(resultSet.next()){
                   String name = resultSet.getString("name");
                   String phone = resultSet.getString("phone");
                   String email = resultSet.getString("email");
                   String address = resultSet.getString("address");

                   System.out.println("Name:" + name);
                   System.out.println("Phone" + phone);
                   System.out.println("Email" + email);
                   System.out.println("Address" + address);
               }
               return null;
           } catch (SQLException e) {
               e.printStackTrace();
               return null;
           }
       }
}