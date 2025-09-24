package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Table {
    private final int size;
    private final List<Customer> customers;
    private static final String[] FOOD_MENU = {
        "Spaghetti", "Burger", "Sushi", "Pizza", "Salad", "Steak", "Pho", "Ramen"
    };

    public enum State {
        EMPTY,
        OCCUPIED,
        FULL
    }

    // Constructor with size parameter
    public Table(int size) {
        this.size = size;
        this.customers = new ArrayList<>();
    }

    // Add a customer if there's space
    public boolean addCustomer(Customer customer) {
        if (isFull()) {
            return false;
        }
        customers.add(customer);
        return true;
    }

    // Reset the table
    public void reset() {
        customers.clear();
    }

    // Get current state
    public State getState() {
        if (customers.isEmpty()) {
            return State.EMPTY;
        } else if (customers.size() >= size) {
            return State.FULL;
        } else {
            return State.OCCUPIED;
        }
    }

    // Check if table is empty
    public boolean isEmpty() {
        return customers.isEmpty();
    }

    // Check if table contains a specific customer
    public boolean containsCustomer(Customer customer) {
        return customers.contains(customer);
    }

    // Check if table is full
    public boolean isFull() {
        return customers.size() >= size;
    }

    // Generate random orders for all customers
    public List<String> getOrders() {
        List<String> orders = new ArrayList<>();
        Random random = new Random();

        for (Customer customer : customers) {
            String food = FOOD_MENU[random.nextInt(FOOD_MENU.length)];
            orders.add(customer.toString() + " ordered: " + food);
        }

        return orders;
    }
}