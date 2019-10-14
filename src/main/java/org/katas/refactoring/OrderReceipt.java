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

        receipt.append("======Printing Orders======\n")
                .append(order.getCustomerName())
                .append(order.getCustomerAddress());

        double taxRate = 0.10;
        double totalSaleTax = 0.0;
        double total = 0.0;
        double salesTax;

        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription()).append('\t')
                    .append(lineItem.getPrice()).append('\t')
                    .append(lineItem.getQuantity()).append('\t')
                    .append(lineItem.totalAmount()).append('\n');

            salesTax = lineItem.totalAmount() * taxRate;
            totalSaleTax += salesTax;
            total += lineItem.totalAmount() + salesTax;
        }

        receipt.append("Sales Tax").append('\t').append(totalSaleTax)
                .append("Total Amount").append('\t').append(total);
        return receipt.toString();
    }
}