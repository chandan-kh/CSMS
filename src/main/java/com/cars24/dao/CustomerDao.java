package com.cars24.dao;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomerDao {

//    public String createCustomer(String name, String phone, String email , String address);
      public String createCustomer(AddCustomerReq addCustomerReq);
      public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq);

//    public void putCustomer();
//    public void updateCustomer();
//    public void deleteCustomer();


}
