package com.khinezaw;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws SQLException{
        BankingDao dao = BankingDaoFactory.getBankingDao();
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            Banking banking = new Banking();
            System.out.println("********************************");
            System.out.println("Select from the options below if you're a customer");
            System.out.println("********************************");
            System.out.println("1: Login");
            System.out.println("2: Apply for a new bank account");
            System.out.println("3: View the balance");
            System.out.println("4: Deposit into an account");
            System.out.println("5: Withdraw from an account");
            System.out.println("6: Transfer payment to an account");
            System.out.println("7: Accept payment from an account");
            System.out.println("8: Exist");
            System.out.println("********************************");
            System.out.println("Select from the options below if you're an employee");
            System.out.println("********************************");
            System.out.println("9: Approve or reject an account");
            System.out.println("10: Accept money from another account");
            System.out.println("11: View log of all transaction");
            System.out.println("12 : Exist");

            int input = getNumber();
            switch (input) {
                case 1: {
                    // Login
                    System.out.print("Enter username: ");
                    banking.setUsername(scanner.next());
                    System.out.print("Enter password: ");
                    banking.setPassword(scanner.next());
                    dao.addBanking(banking);
                    break;
                }
                case 2: {
                    // Apply
                    System.out.print("Enter Name: ");
                    banking.setName(scanner.next());
                    System.out.print("Enter Email: ");
                    banking.setEmail(scanner.next());
                    System.out.print("Welcome:");
                    dao.applyBanking(banking);
                    break;
                }
                case 3: {
                    // View
                    System.out.print("Enter Account Number: ");
                    banking = dao.viewBanking(getNumber());
                    if(banking.getName() == null) System.out.println("ID not found");
                    else System.out.println(banking.toString());
                    break;
                }
                case 4: {
                    // Deposit
                    System.out.print("Deposit: ");
                    int balance = scanner.nextInt();
                    dao.depositBanking(balance);
                    break;
                }
                case 5: {
                    // Withdraw
                    System.out.print("Withdraw: ");
                    int balance = scanner.nextInt();
                    dao.withdrawBanking(balance);
                    break;
                }
                case 6: {
                    // Transfer
                    System.out.print("Transfer: ");
                    int balance = scanner.nextInt();
                    dao.transferBanking(balance);
                    break;
                }
                case 7: {
                    // Accept
                    System.out.print("Accept: ");
                    int balance = scanner.nextInt();
                    dao.acceptBanking(balance);
                    break;
                }
                case 8: {
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                // Employee Account
                case 9: {
                    // Approve or Reject an account
                    System.out.print("Enter UserName: ");
                    String username = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();
                    Banking newBanking = new Banking(username, password);
                    System.out.println("Your account is being reviewed");
                    dao.addBanking(newBanking);
                    break;
                }
                case 10: {
                    // Accept money from another account
                    System.out.print("Accept Amount: ");
                    int balance = scanner.nextInt();
                    dao.acceptBanking(balance);
                    break;
                }
                case 11: {
                    // View log of transactions
                    System.out.print("Enter Account Number: ");
                    banking = dao.viewBanking(getNumber());
                    if(banking.getName() == null) System.out.println("ID not found");
                    else System.out.println(banking.toString());
                    break;
                }
                case 12: {
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("Choose between 1-11");
            }
        }
    }
    public static int getNumber(){
        int num;
        Scanner scanner = new Scanner(System.in);
        try{
            num = scanner.nextInt();
        } catch(InputMismatchException e){
            num = 0;
        }
        return num;
    }
}
