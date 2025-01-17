package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.CustomerProfileRequest;
import com.cars24.data.request.DeleteCustomerRequest;
import com.cars24.data.request.UpdateCustomerRequest;
import com.cars24.data.response.CustomerProfileResponse;
import com.cars24.services.CustomerService;
import com.cars24.validation.CustomerValidation;

//need to do data sanitization
public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao=new CustomerDaoImpl();
    private CustomerValidation customerValidation=new CustomerValidation();

    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {

        //service depends on object of dao
        try{
            customerValidation.validateAddCustomerRequest(addCustomerReq);
            customerDao.createCustomerv2(addCustomerReq);//dependency
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        return "";
    }
    public CustomerProfileResponse getCustomerProfile(CustomerProfileRequest customerProfileRequest){
        CustomerProfileResponse res=customerDao.getCustomer(customerProfileRequest);
        return res;
    }
    public String updateCustomerProfile(UpdateCustomerRequest updateCustomerRequest){
        String response=customerDao.updateCustomer(updateCustomerRequest);
        return response;
    }
    public String deleteCustomerProfile(DeleteCustomerRequest deleteCustomerRequest){
        String response=customerDao.deleteCustomer(deleteCustomerRequest);
        return response;
    }
}
