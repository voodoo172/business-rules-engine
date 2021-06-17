package org.adam.product.impl;

import org.adam.product.PhysicalProduct;

import java.math.BigDecimal;

public class Video extends AbstractProduct implements PhysicalProduct {
    public Video(BigDecimal cost) {
        super(cost);
    }

    @Override
    public BigDecimal getCost() {
        return null;
    }
}
