package aman.dev;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch!= null) {
            return branch.newCustomer(customerName, initialAmount);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }

    private Branch findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);

            if (branch.getName().equals(name)) {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String name,boolean printTransactions){
        Branch branch=findBranch(name);
        if(branch!=null){
            System.out.println("Customers detail for branch " + branch.getName() + "In Australia");
            ArrayList<Customer> branchCustomers=branch.getCustomers();
            for (int i = 0; i < branchCustomers.size() ; i++) {
                Customer customer= branchCustomers.get(i);
                System.out.println("Customer : "+ customer.getName()+  "[" + (i + 1) + "]");
                if(printTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions=customer.getTransactions();

                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }
            }

            return true;
        }

        return false;
    }
}

