package org.adam.product.impl;

import org.adam.product.PhysicalProduct;

import java.math.BigDecimal;

public class Book extends AbstractProduct implements PhysicalProduct {
    public Book(BigDecimal cost) {
        super(cost);
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }
}
