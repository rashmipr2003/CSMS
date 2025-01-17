package com.cars24.validation;

import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.DeleteCustomerRequest;
import com.cars24.data.request.UpdateCustomerRequest;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidation {

    public List<String> validateAddCustomerRequest(AddCustomerReq addCustomerReq) {
        List<String> errorMessages = new ArrayList<>();

        validateCustomerName(addCustomerReq.getName(), errorMessages);

        validateCustomerPhone(addCustomerReq.getPhone(), errorMessages);

        validateCustomerEmail(addCustomerReq.getEmail(), errorMessages);

        return errorMessages;
    }

    public List<String> validateUpdateCustomerRequest(UpdateCustomerRequest updateCustomerRequest) {
        List<String> errorMessages = new ArrayList<>();

        validateCustomerName(updateCustomerRequest.getName(), errorMessages);

        validateCustomerEmail(updateCustomerRequest.getEmail(), errorMessages);

        if (updateCustomerRequest.getPhone() != null && !updateCustomerRequest.getPhone().isEmpty()) {
            validateCustomerPhone(updateCustomerRequest.getPhone(), errorMessages);
        }

        return errorMessages;
    }

    public List<String> validateDeleteCustomerRequest(DeleteCustomerRequest deleteCustomerRequest) {
        List<String> errorMessages = new ArrayList<>();

        if (deleteCustomerRequest.getName() == null && deleteCustomerRequest.getEmail() == null) {
            errorMessages.add("At least one of the fields (Name or Email) must be provided to delete a customer.");
        }

        return errorMessages;
    }

    private void validateCustomerName(String name, List<String> errorMessages) {
        if (name == null || name.isEmpty()) {
            errorMessages.add("Name cannot be empty.");
        } else if (name.length() < 3 || name.length() > 100) {
            errorMessages.add("Name should be between 3 and 100 characters.");
        }
    }

    private void validateCustomerPhone(String phone, List<String> errorMessages) {
        if (phone == null || phone.isEmpty()) {
            errorMessages.add("Phone number cannot be empty.");
        } else {
            String regex = "^[6-9]\\d{9}$";
            if (!phone.matches(regex)) {
                errorMessages.add("Phone number must be a 10-digit number starting with 6, 7, 8, or 9.");
            }
        }
    }

    private void validateCustomerEmail(String email, List<String> errorMessages) {
        if (email == null || email.isEmpty()) {
            errorMessages.add("Email cannot be empty.");
        } else {
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            if (!email.matches(emailRegex)) {
                errorMessages.add("Invalid email format.");
            }
        }
    }
}
