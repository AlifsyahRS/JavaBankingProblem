package com.bank;
import java.util.ArrayList;

public class Bank{
    private ArrayList<Customer> customerList = new ArrayList<>();
    private int numOfCustomers  = 0;
    private String bankName;



    public Bank(String bankName){
        this.bankName = bankName;
    }

    public void addCustomer(Customer newCustomer){

        for (int i = 0; i < numOfCustomers; i++){
            if (newCustomer.getFName().equals(customerList.get(i).getFName()) && newCustomer.getLName().equals(customerList.get(i).getLName())){
                System.out.println("A customer with that name already exists.");
                return;
            }
        }
        
        customerList.add(newCustomer);
        System.out.printf("Created a new customer named %s %s. Please proceed to login.\n", newCustomer.getFName(), newCustomer.getLName());
        numOfCustomers+=1;
    }
    
    public int getNumOfCustomers(){
        return numOfCustomers;
    }

    public Customer getCustomer(int index){
        return customerList.get(index);
    }

    // Returns true if the user-inputted credentials match the one in the ArrayList
    public boolean checkLogin(String custToString){
        ArrayList<String> toStringList = new ArrayList<>();
        for (Customer i : customerList){
            toStringList.add(i.toString());
        }

        return toStringList.contains(custToString);
    }

    public String toString(){
        return "Welcome to " + bankName + ".";
    }






}