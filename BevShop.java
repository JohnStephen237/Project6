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

import com.bevshop.enums.Type; // Import Type enum
import com.bevshop.enums.Size; // Import Size enum
import com.bevshop.enums.Day; // Import Day enum
import java.util.ArrayList;
import java.util.List;

public class BevShop implements BevShopInterface {

    private static final int MAX_ALCOHOL_DRINKS = 3;
    private static final int MIN_AGE_FOR_ALCOHOL = 21;

    private int currentAlcoholCount;
    private List<Order> orders;

    public BevShop() {
        this.currentAlcoholCount = 0;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean validTime(int time) {
        return time >= 8 && time <= 23;
    }

    @Override
    public boolean isMaxAlcohol() {
        return currentAlcoholCount < MAX_ALCOHOL_DRINKS;
    }

    @Override
    public boolean isEligibleForAlcohol() {
        return currentCustomer.getAge() >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int orderTime, Day day, String customerName, int customerAge) {
        if (!validTime(orderTime)) {
            throw new IllegalArgumentException("Invalid order time. Orders can only be placed between 8:00 and 23:00.");
        }
        Customer customer = new Customer(customerName, customerAge);
        Order newOrder = new Order(orderTime, day, customer);
        orders.add(newOrder);
        currentAlcoholCount = 0; // Reset alcohol count for the new order
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (!eligibleForMore()) {
            throw new IllegalStateException("Cannot add more alcoholic beverages to the order.");
        }
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size);
        currentAlcoholCount++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index < 0 || index >= orders.size()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return orders.get(index);
    }

    @Override
    public Order getCurrentOrder() {
        if (orders.isEmpty()) {
            throw new IllegalStateException("No orders have been placed.");
        }
        return orders.get(orders.size() - 1);
    }   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale()).append("\n");
        return sb.toString();
    }

}
