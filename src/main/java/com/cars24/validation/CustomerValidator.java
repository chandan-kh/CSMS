package com.cars24.validation;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;

public class CustomerValidator {

    public static void validateAddCustomerRequest(AddCustomerReq addCustomerReq){

        validateName(addCustomerReq.getName());
        validateAddress(addCustomerReq.getAddress());
        validateEmail(addCustomerReq.getEmail());
        validatePhone(addCustomerReq.getPhone());

    }

    public static void validateDeleteCustomer(DeleteCustomerReq deleteCustomerReq){

        if(deleteCustomerReq.getPhone() == "" && deleteCustomerReq.getEmail() == ""){
            throw new IllegalArgumentException("Both the feilds phone and email are empty");
        }

        if(deleteCustomerReq.getEmail() != "") {
            validateEmail(deleteCustomerReq.getEmail());
        }
        if(deleteCustomerReq.getPhone() != "") {
            validatePhone(deleteCustomerReq.getPhone());
        }
    }

    public static void validateUpdateCustomer(UpdateCustomerReq updateCustomerReq){

        if(updateCustomerReq.getCurrPhone()=="" && updateCustomerReq.getCurrEmail()==""){
            throw new IllegalArgumentException("Both the feilds phone and email are empty");
        }

        if(updateCustomerReq.getCurrEmail() != "") {
            validateEmail(updateCustomerReq.getCurrEmail());
        }
        if(updateCustomerReq.getCurrPhone() != "") {
            validatePhone(updateCustomerReq.getCurrPhone());
        }
        if(updateCustomerReq.getName() != "") {
            validateName(updateCustomerReq.getName());
        }
        if(updateCustomerReq.getEmail() != "") {
            validateEmail(updateCustomerReq.getEmail());
        }
        if(updateCustomerReq.getPhone() != "") {
            validatePhone(updateCustomerReq.getPhone());
        }
        if(updateCustomerReq.getAddress() != "") {
            validateAddress(updateCustomerReq.getAddress());
        }

    }

    public static void validateGetCustomer(CustomerProfileReq customerProfileReq){

        if(customerProfileReq.getPhone() == "" && customerProfileReq.getEmail() == ""){
            throw new IllegalArgumentException("Both the feilds phone and email are empty");
        }

        if(customerProfileReq.getEmail() != "") {
            validateEmail(customerProfileReq.getEmail());
        }
        if(customerProfileReq.getPhone() != "") {
            validatePhone(customerProfileReq.getPhone());
        }
    }



    private static void validateName(String name){

        if(name==null){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(name.length() < 3 || name.length() > 100){
            throw new IllegalArgumentException("Name should be 3 characters minimum or 100 characters maximum");
        }

    }




    private static void validatePhone(String phone){
        if(phone.length()!=10){
            throw new IllegalArgumentException("Phone number should be of length 10");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    private static void validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }

        if (address.length() < 5 || address.length() > 255) {
            throw new IllegalArgumentException("Address must be between 5 and 255 characters");
        }
    }


}
