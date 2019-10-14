package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();
        final char TAB = '\t', LINEFEED = '\n';
        double taxRate = 0.10, totalSaleTax = 0.0, total = 0.0, salesTax;

        receipt.append("======Printing Orders======\n")
                .append(order.getCustomerName())
                .append(order.getCustomerAddress());

        for (OrderedItem orderedItem : order.getLineItems()) {
            receipt.append(orderedItem.getDescription()).append(TAB)
                    .append(orderedItem.getPrice()).append(TAB)
                    .append(orderedItem.getQuantity()).append(TAB)
                    .append(orderedItem.totalAmount()).append(LINEFEED);

            salesTax = orderedItem.totalAmount() * taxRate;
            totalSaleTax += salesTax;
            total += orderedItem.totalAmount() + salesTax;
        }

        receipt.append("Sales Tax").append(TAB).append(totalSaleTax)
                .append("Total Amount").append(TAB).append(total);
        return receipt.toString();
    }
}