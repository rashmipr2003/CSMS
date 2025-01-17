package com.cars24.runner;

import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.CustomerProfileRequest;
import com.cars24.data.request.DeleteCustomerRequest;
import com.cars24.data.request.UpdateCustomerRequest;
import com.cars24.data.response.CustomerProfileResponse;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.validation.CustomerValidation;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private static Scanner scanner  = new Scanner(System.in);
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static CustomerValidation customerValidation;

    static {
        customerValidation = new CustomerValidation();
    }
    public static void addCustomer()
    {
        System.out.println("Enter customer details");
        AddCustomerReq addCustomerReq = new AddCustomerReq();

        System.out.println("Enter name:");
        addCustomerReq.setName(scanner.next());

        System.out.println("Enter Phone:");
        addCustomerReq.setPhone(scanner.next());

        System.out.println("Enter email:");
        addCustomerReq.setEmail(scanner.next());

        System.out.println("Enter address:");
        addCustomerReq.setAddress(scanner.next());

        List<String> validationErrors = customerValidation.validateAddCustomerRequest(addCustomerReq);

        if (!validationErrors.isEmpty()) {

            for (String error : validationErrors) {
                System.out.println("Error: " + error);
            }
            return;
        }

        String res = customerService.registerCustomer(addCustomerReq);
        System.out.println(res);

    }

    public static void getCustomer()
    {
        CustomerProfileRequest customerProfileRequest=new CustomerProfileRequest();

        System.out.println("Search customer details");

        System.out.println("Enter Phone  : ");
        String phone=scanner.next();
        customerProfileRequest.setPhone(phone);

        System.out.println("Enter Email  : ");
        String email=scanner.next();
        customerProfileRequest.setEmail(email);

        CustomerProfileResponse response=customerService.getCustomerProfile(customerProfileRequest);
        System.out.println(response);
    }
    public static void updateCustomer() {
        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();


        System.out.println("Enter the customer's name:");
        String name = scanner.nextLine();
        updateCustomerRequest.setName(name);

        System.out.println("Enter the customer's email:");
        String email = scanner.nextLine();
        updateCustomerRequest.setEmail(email);

        System.out.println("Enter the new details (leave blank if unchanged):");
        System.out.print("New Phone: ");
        String phone = scanner.nextLine();
        updateCustomerRequest.setPhone(phone.isEmpty() ? null : phone);

        System.out.print("New Address: ");
        String address = scanner.nextLine();
        updateCustomerRequest.setAddress(address.isEmpty() ? null : address);

        List<String> validationErrors = customerValidation.validateUpdateCustomerRequest(updateCustomerRequest);

        if (!validationErrors.isEmpty()) {

            for (String error : validationErrors) {
                System.out.println("Error: " + error);
            }
            return;
        }

        String result = customerService.updateCustomerProfile(updateCustomerRequest);
        System.out.println(result);

    }



    public static void deleteCustomer(){
        DeleteCustomerRequest deleteCustomerRequest= new DeleteCustomerRequest();

        System.out.println("Enter name");
        String name=scanner.nextLine();
        deleteCustomerRequest.setName(name);

        System.out.println("Enter email");
        String email=scanner.nextLine();
        deleteCustomerRequest.setEmail(email);

        List<String> validationErrors = customerValidation.validateDeleteCustomerRequest(deleteCustomerRequest);

        if (!validationErrors.isEmpty()) {

            for (String error : validationErrors) {
                System.out.println("Error: " + error);
            }
            return;
        }

        String result = customerService.deleteCustomerProfile(deleteCustomerRequest);
        System.out.println(result);
    }
}
