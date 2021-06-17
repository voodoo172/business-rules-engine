package org.adam.product.physical.impl;

import org.adam.product.AbstractProduct;
import org.adam.product.PhysicalProduct;

import java.math.BigDecimal;

public class VideoImpl extends AbstractProduct implements PhysicalProduct {
    public VideoImpl(final Long id, final BigDecimal cost) {
        super(id, cost);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }
}
