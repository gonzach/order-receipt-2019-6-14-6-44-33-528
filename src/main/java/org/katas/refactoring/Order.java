package org.katas.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<OrderedItem> orderedItem;

    public Order(String customerName, String customerAddress, List<OrderedItem> orderedItem) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderedItem = orderedItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<OrderedItem> getLineItems() {
        return orderedItem;
    }
}
