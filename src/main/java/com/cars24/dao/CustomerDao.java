package com.cars24.dao;
//dao--data access object
import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.CustomerProfileRequest;
import com.cars24.data.request.DeleteCustomerRequest;
import com.cars24.data.request.UpdateCustomerRequest;
import com.cars24.data.response.CustomerProfileResponse;

public interface CustomerDao {
    //public String createCustomer(String name, String phone,String email, String address);
    //public String createCustomerv2(String name, String phone, String email, String address);
    public String createCustomerv2(AddCustomerReq addCustomerReq);
    public CustomerProfileResponse getCustomer(CustomerProfileRequest customerProfileRequest);
    public String updateCustomer(UpdateCustomerRequest updateCustomerRequest);
    public String deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);
}
