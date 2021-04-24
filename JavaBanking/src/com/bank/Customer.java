package com.bank;


public class Customer{
    private final String fName;
    private final String lName;
    private final Account myAcc = new Account(0);
    private String pin; // Pin to add security to the bank

    public Customer(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }

    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }

    public Account getAccount(){
        return myAcc;
    }

    public String getPin() {return pin;}

    public boolean setPin(String myPin){
        // Fails if the inputted pin is the same as the current pin
        if(myPin.equals(pin)){
            return false;
        }
        pin = myPin;
        return true;
    }

    // Using toString() for comparison
    public String toString(){
        return "{First name: " + fName + ", Last name: " + lName + ", Pin: " + pin + "}";
    }
}