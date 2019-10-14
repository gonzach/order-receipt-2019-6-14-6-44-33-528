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
        final char TAB = '\t';
        final char LINEFEED = '\n';

        receipt.append("======Printing Orders======\n")
                .append(order.getCustomerName())
                .append(order.getCustomerAddress());

        double taxRate = 0.10;
        double totalSaleTax = 0.0;
        double total = 0.0;
        double salesTax;

        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription()).append(TAB)
                    .append(lineItem.getPrice()).append(TAB)
                    .append(lineItem.getQuantity()).append(TAB)
                    .append(lineItem.totalAmount()).append(LINEFEED);

            salesTax = lineItem.totalAmount() * taxRate;
            totalSaleTax += salesTax;
            total += lineItem.totalAmount() + salesTax;
        }

        receipt.append("Sales Tax").append(TAB).append(totalSaleTax)
                .append("Total Amount").append(TAB).append(total);
        return receipt.toString();
    }
}