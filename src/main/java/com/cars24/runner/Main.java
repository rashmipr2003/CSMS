package com.cars24.runner;


import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.request.AddCustomerReq;
import com.cars24.data.request.CustomerProfileRequest;
import com.cars24.data.response.CustomerProfileResponse;
import com.cars24.services.CustomerService;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static com.cars24.util.DbUtil.getDbconnection;


public class Main {
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        boolean exit=true;
        
        while(exit){
            int choice = 0;
            System.out.println("enter choice");
            System.out.println("1: Add user \n2:Get user \n3:Update customer \n4: Delete customer \n0: exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    //call
                    Ui.addCustomer();
                    break;
                case 2:
                    Ui.getCustomer();
                    break;
                case 3:
                    Ui.updateCustomer();
                    break;
                case 4:
                    Ui.deleteCustomer();
                    break;
                case 0:
                    exit=false;
            }
        }
    }
}
