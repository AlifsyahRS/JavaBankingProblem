package com.bank;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {
        Bank myBank = new Bank("BCA");
        boolean active = true;
        Scanner scanner = new Scanner(System.in);
        Customer currentCustomer = new Customer(null, null);

        while (active){
            System.out.println(myBank.toString() + " How can we help you?");
            System.out.print("1. Create Account\n2. Login\n3. Deposit\n4. Withdraw\n5. Check Balance\n6. Change Pin\n7. Log Out\n8. Exit\nEnter your choice: ");
            String userInput = scanner.next();

            switch (userInput){
                case "1":
                    if (currentCustomer.getFName() != null){
                        System.out.println("Already logged in.");
                    } else {
                        System.out.print("Enter your first name: ");
                        String fNameReg = scanner.next();
                        System.out.print("Enter your last name: ");
                        String lNameReg = scanner.next();
                        System.out.print("Enter your pin: ");
                        String pinReg = scanner.next();
                        Customer newCust = new Customer(fNameReg, lNameReg);
                        newCust.setPin(pinReg);
                        myBank.addCustomer(newCust);
                    }
                    break;
                case "2":
                    if (currentCustomer.getFName() != null){
                        System.out.println("Already logged in.");
                    } else {
                        System.out.print("Enter your first name: ");
                        String fNameLog = scanner.next();
                        System.out.print("Enter your last name: ");
                        String lNameLog = scanner.next();
                        System.out.print("Enter your pin: ");
                        String pinLog = scanner.next();
                        String toStringFormat = "{First name: " + fNameLog + ", Last name: " + lNameLog + ", Pin: " + pinLog + "}";
                        if(myBank.checkLogin(toStringFormat)){
                            for(int i = 0; i < myBank.getNumOfCustomers(); i++){
                                if(myBank.getCustomer(i).toString().equals(toStringFormat)){
                                    currentCustomer = myBank.getCustomer(i);
                                }
                            }
                            System.out.printf("Login Successful. Welcome Mr./Mrs. %s.\n", lNameLog);
                        } else {
                            System.out.println("Invalid name or password. Please try again.");
                        }
                    }

                    break;
                case "3":
                    if (currentCustomer.getFName() == null){
                        System.out.println("You are currently not logged in, Please create a new account or log in.");
                    } else {
                        System.out.print("Enter the amount you would like to deposit: ");
                        double depAmt = scanner.nextDouble();
                        if(currentCustomer.getAccount().deposit(depAmt)){
                            System.out.println("Successfully deposited " + depAmt + " to your account.");
                        } else {
                            System.out.println("Invalid amount to deposit.");
                        }
                    }
                    break;
                case "4":
                    if (currentCustomer.getFName() == null){
                        System.out.println("You are currently not logged in, Please create a new account or log in.");
                    } else {
                        System.out.print("Enter the amount you would like to withdraw: ");
                        double withAmt = scanner.nextDouble();
                        if(currentCustomer.getAccount().withdraw(withAmt)){
                            System.out.println("Successfully withdrew " + withAmt + " from your account.");
                        } else {
                            System.out.println("Invalid amount to withdraw.");
                        }
                    }
                    break;
                case "5":
                    if(currentCustomer.getFName() == null){
                        System.out.println("You are currently not logged in. Please create a new account or log in.");
                    } else {
                        System.out.println("You currently have " + currentCustomer.getAccount().getBalance() + " in your account.");
                    }
                    break;
                case "6":
                    if(currentCustomer.getFName() == null){
                        System.out.println("You are currently not logged in. Please create a new account or log in.");
                    } else {
                        System.out.print("Enter your current pin: ");
                        String currentPin = scanner.next();
                        if(currentCustomer.getPin().equals(currentPin)){
                            System.out.print("Enter your new pin: ");
                            String newPin = scanner.next();
                            if(currentCustomer.setPin(newPin)){
                                System.out.println("Pin successfully changed");
                            } else {
                                System.out.println("Error: The new pin is the same with the current pin.");
                            }
                        } else {
                            System.out.println("Invalid pin.");
                        }
                    }
                    break;
                case "7":
                    if(currentCustomer.getFName() == null){
                        System.out.println("You are currently not logged in. Please create a new account or log in.");
                    } else {
                        currentCustomer = new Customer(null,null);
                        System.out.println("User logged out.");
                    }
                    break;
                case "8":
                    scanner.close();
                    active=false;
                    System.out.println("Successful shutdown. Thank you for using our program.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;

            }
        }

    }
}
