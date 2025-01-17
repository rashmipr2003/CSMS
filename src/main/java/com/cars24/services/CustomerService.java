package com.cars24.services;

import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.CustomerProfileRequest;
import com.cars24.data.request.DeleteCustomerRequest;
import com.cars24.data.request.UpdateCustomerRequest;
import com.cars24.data.response.CustomerProfileResponse;

//should contain only business logic and dao contains all crud operations
public interface CustomerService {
     public String registerCustomer(AddCustomerReq addCustomerReq);

     public CustomerProfileResponse getCustomerProfile(CustomerProfileRequest customerProfileRequest);
     public String updateCustomerProfile(UpdateCustomerRequest updateCustomerRequest);
     public String deleteCustomerProfile(DeleteCustomerRequest deleteCustomerRequest);
}
