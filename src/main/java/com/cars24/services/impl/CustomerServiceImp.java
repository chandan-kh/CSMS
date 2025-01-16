package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImp;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.validation.CustomerValidator;

import static com.cars24.validation.CustomerValidator.validateAddCustomerRequest;

public class CustomerServiceImp implements CustomerService {

    private CustomerDaoImp customerDao = new CustomerDaoImp();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {
            validateAddCustomerRequest(addCustomerReq);
            customerDao.createCustomer(addCustomerReq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq) {
         return null;
    }


}
