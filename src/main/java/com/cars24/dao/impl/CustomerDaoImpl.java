package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.CustomerProfileRequest;
import com.cars24.data.request.DeleteCustomerRequest;
import com.cars24.data.request.UpdateCustomerRequest;
import com.cars24.data.response.CustomerProfileResponse;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    private final static String INSERT_SUCCESS_MESSAGE="Customer added successfully";
    private final static String INSERT_ERROR_MESSAGE="Error while adding Customer";
    private Connection connection=DbUtil.getDbconnection();
//    @Override public String createCustomer(String name, String phone, String email, String address) {
//       String insertSQL= "INSERT INTO customers (customer_id,name, phone, email, address) VALUES"
//               +"("+0+","
//               +"'"+name+"'"+","
//               +"'"+phone+"'"+","
//               +"'"+email+"'"+","
//               +"'"+address+"'" +");";
//
//        System.out.println(insertSQL);
//        Connection connection= DbUtil.getDbconnection();
//        try {
//            Statement statement = connection.createStatement();
//            int rowsInserted = statement.executeUpdate(insertSQL);
//            System.out.println(rowsInserted + "rows inserted.");
//        } catch (Exception e) {
//            System.out.println("Error while inserting data to customer table");
//            e.printStackTrace();
//            //throw new RuntimeException(e);
//        }
//        return "";
//    }
//    public String createCustomerv2(String name, String phone, String email, String address){
//        String insert="INSERT INTO customers (name, phone, email, address) VALUES (?,?,?,?)";
//        Connection connection= DbUtil.getDbconnection();
//        try{
//            PreparedStatement preparedStatement=connection.prepareStatement(insert);
//            preparedStatement.setString(1,name);
//            preparedStatement.setString(2,phone);
//            preparedStatement.setString(3,email);
//            preparedStatement.setString(4,address);
//
//            int rowsInserted=preparedStatement.executeUpdate();
//            //System.out.println(rowsInserted+" rows inserted");
//            return INSERT_SUCCESS_MESSAGE;
//
//        } catch (Exception e) {
//            System.out.println("Error while inserting data to customer table");
//            e.printStackTrace();
//            return INSERT_ERROR_MESSAGE;
//        }
    public String createCustomerv2(AddCustomerReq addCustomerReq){
            Connection connection=DbUtil.getDbconnection();
        try{
            String insert="INSERT INTO customers (name, phone, email, address) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(insert);
            preparedStatement.setString(1,addCustomerReq.getName());
            preparedStatement.setString(2,addCustomerReq.getPhone());
            preparedStatement.setString(3,addCustomerReq.getEmail());
            preparedStatement.setString(4,addCustomerReq.getAddress());

            int rowsInserted=preparedStatement.executeUpdate();
            //System.out.println(rowsInserted+" rows inserted");
            return INSERT_SUCCESS_MESSAGE;
        } catch (Exception e) {
            //e.printStackTrace();
            return INSERT_ERROR_MESSAGE;
        }

    }
    public CustomerProfileResponse getCustomer(CustomerProfileRequest customerProfileRequest){
        String query = "SELECT name, phone, email, address FROM customers WHERE phone = ? AND email = ?";
        try {

             PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerProfileRequest.getPhone());
            preparedStatement.setString(2, customerProfileRequest.getEmail());
            CustomerProfileResponse response = new CustomerProfileResponse();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                response.setName(resultSet.getString("name"));
                response.setPhone(resultSet.getString("phone"));
                response.setEmail(resultSet.getString("email"));
                response.setAddress(resultSet.getString("address"));
//                String name = resultSet.getString("name");
//                String phone = resultSet.getString("phone");
//                String email = resultSet.getString("email");
//                String address = resultSet.getString("address");
//
//                System.out.println("name: "+name);
//                System.out.println("phone: "+phone);
//                System.out.println("email: "+email);
//                System.out.println("address: "+address);

            }
            return response;
        } catch (SQLException e) {
            System.err.println("Error while fetching customer profile: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        String updateSQL = "UPDATE customers SET phone = ?, address = ? WHERE name = ? AND email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(3, updateCustomerRequest.getName());
            preparedStatement.setString(2, updateCustomerRequest.getAddress());
            preparedStatement.setString(1, updateCustomerRequest.getPhone());
            preparedStatement.setString(4, updateCustomerRequest.getEmail());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return "Customer updated successfully!";
            } else {
                return "Customer not found for the provided phone and email.";
            }
        } catch (SQLException e) {
            return "Error while updating the customer: " + e.getMessage();
        }
    }
    public String deleteCustomer(DeleteCustomerRequest deleteCustomerRequest) {
        String deleteSQL = "DELETE FROM customers WHERE name = ? AND email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, deleteCustomerRequest.getName());
            preparedStatement.setString(2, deleteCustomerRequest.getEmail());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                return "Customer deleted successfully!";
            } else {
                return "No customer found with the given name or email.";
            }
        } catch (SQLException e) {
            return "Error while deleting the customer: " + e.getMessage();
        }
    }

}


