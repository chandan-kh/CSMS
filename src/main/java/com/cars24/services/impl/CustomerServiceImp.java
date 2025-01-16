package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImp;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.validation.CustomerValidator;

import static com.cars24.validation.CustomerValidator.*;

public class CustomerServiceImp implements CustomerService {

    private CustomerDaoImp customerDao = new CustomerDaoImp();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        String resp = "";
        try {
            validateAddCustomerRequest(addCustomerReq);
            resp = customerDao.createCustomer(addCustomerReq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resp;
    }

    @Override
    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq) {
         try{
             validateGetCustomer(customerProfileReq);
             CustomerProfileRes resp = customerDao.getCustomer(customerProfileReq);
             return resp;
         }
         catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
         }

    }


    public String updateCustomer(UpdateCustomerReq updateCustomerReq){

        String resp = "";
        try {
            validateUpdateCustomer(updateCustomerReq);
            resp = customerDao.updateCustomer(updateCustomerReq);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resp;

    }

    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq){

        String resp = "";
        try {
            validateDeleteCustomer(deleteCustomerReq);
            resp = customerDao.deleteCustomer(deleteCustomerReq);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return resp;
    }


}
