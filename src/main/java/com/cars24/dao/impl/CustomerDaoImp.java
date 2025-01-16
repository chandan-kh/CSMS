package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;


public class CustomerDaoImp implements CustomerDao {

    private final static String  SUCCESS_MESSAGE = "Customer operation successfully";
    private final static String ERROR_MESSAGE = "Error while processing request";

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


        public String updateCustomer(UpdateCustomerReq updateCustomerReq){
            Connection connection = DbUtil.getDbConnection();

            String fetchSQL = "SELECT name, phone, email, address FROM customers WHERE phone = ? OR email = ?";
            String updateSQL = "UPDATE customers SET name = ?, phone = ?, email = ?, address = ? WHERE phone = ? OR email = ?";

            try{

                PreparedStatement fetchStmt = connection.prepareStatement(fetchSQL);
                fetchStmt.setString(1, updateCustomerReq.getCurrPhone());
                fetchStmt.setString(2, updateCustomerReq.getCurrEmail());

                ResultSet rs = fetchStmt.executeQuery();

                if (!rs.next()) {
                    return "No customer found with given phone or email";
                }

                String name = updateCustomerReq.getName().isEmpty() ? rs.getString("name") : updateCustomerReq.getName();
                String phone = updateCustomerReq.getPhone().isEmpty() ? rs.getString("phone") : updateCustomerReq.getPhone();
                String email = updateCustomerReq.getEmail().isEmpty() ? rs.getString("email") : updateCustomerReq.getEmail();
                String address = updateCustomerReq.getAddress().isEmpty() ? rs.getString("address") : updateCustomerReq.getAddress();

                PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phone);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, updateCustomerReq.getCurrPhone());
                preparedStatement.setString(6, updateCustomerReq.getCurrEmail());

                int rowsInserted = preparedStatement.executeUpdate();
                if(rowsInserted > 0){
                    return SUCCESS_MESSAGE + ". Updation Success";
                }
                else{
                    return "No customer found with given phone or email";
                }

            } catch (SQLException e) {
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
               CustomerProfileRes resp = new CustomerProfileRes();
               ResultSet resultSet = preparedStatement.executeQuery();

               while(resultSet.next()){

//                   String name = resultSet.getString("name");
//                   String phone = resultSet.getString("phone");
//                   String email = resultSet.getString("email");
//                   String address = resultSet.getString("address");
//
                   resp.setName(resultSet.getString("name"));
                   resp.setEmail(resultSet.getString("email"));
                   resp.setPhone(resultSet.getString("phone"));
                   resp.setAddress(resultSet.getString("address"));

               }
               return resp;

           } catch (SQLException e) {
               System.out.println("Data not found");
               e.printStackTrace();
               return null;
           }
       }


       public String deleteCustomer(DeleteCustomerReq deleteCustomerReq){
           Connection connection = DbUtil.getDbConnection();
           String deleteSQL = "DELETE FROM customers WHERE phone = ? OR email = ?";
           try {
               PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
               preparedStatement.setString(1, deleteCustomerReq.getPhone());
               preparedStatement.setString(2, deleteCustomerReq.getEmail());

               int rowsDeleted = preparedStatement.executeUpdate();
               if (rowsDeleted > 0) {
                   return SUCCESS_MESSAGE + ". Deletion Success";
               } else {
                   return "No customer found with given phone or email";
               }
           } catch (SQLException e) {
               e.printStackTrace();
               return ERROR_MESSAGE;
           }
       }


}


