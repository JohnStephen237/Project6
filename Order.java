/*
 * Class: CMSC203 30371
 * Instructor: Professor Thai
 * Description: Project 6
 * Due: 12/13/2024
 * Platform/compiler: Visual Studio Code
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Johan Mbouwa Fokoua
*/

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Size size;
    private Type type;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    // Constructor
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy of customer
        this.beverages = new ArrayList<>();
        this.orderNumber = generateRandomNumber();
    }

    // Generates a random number within the range 10000 to 90000
    private int generateRandomNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(80001); // Range: 10000 to 90000
    }

    // Adds a new coffee beverage
    public void addNewBeverage(String bevName, Type type, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    // Adds a new alcohol beverage
    public void addNewBeverage(String bevName, Type type, Size size) {
        beverages.add(new Alcohol(bevName, size));
    }

    // Adds a new smoothie beverage
    public void addNewBeverage(String bevName, Type type, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    // Returns the list of beverages
    public ArrayList<Beverage> getBeverageList() {
        return new ArrayList<>(beverages); // Return a copy to ensure immutability
    }
    

    // Overrides toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer Name: ").append(customer.getName()).append("\n");
        sb.append("Customer Age: ").append(customer.getAge()).append("\n");
        sb.append("Beverages: \n");
        for (Beverage bev : beverages) {
            sb.append(bev).append("\n");
        }
        return sb.toString();
    }

    // Overrides compareTo to compare based on order number
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }

    // Getters and setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Return deep copy of customer
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer); // Set with deep copy
    }

    public ArrayList<Beverage> getBeverages() {
        return new ArrayList<>(beverages); // Return copy of beverages list
    }

    // Additional methods as required
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }
}
