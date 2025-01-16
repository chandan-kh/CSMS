package com.cars24.validation;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidator {

    public static void validateAddCustomerRequest(AddCustomerReq addCustomerReq){

        validateName(addCustomerReq.getName());
        validateAddress(addCustomerReq.getAddress());
        validateEmail(addCustomerReq.getEmail());
        validatePhone(addCustomerReq.getPhone());

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

        }
    }

    private static void validateEmail(String email){

    }

    private static void validateAddress(String address){

    }

}
