package com.cars24.services;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomerService {

    public String registerCustomer(AddCustomerReq addCustomerReq);
    public CustomerProfileRes getCustomerProfile(CustomerProfileReq customerProfileReq);
    public String updateCustomer(UpdateCustomerReq updateCustomerReq);
    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq);

}
