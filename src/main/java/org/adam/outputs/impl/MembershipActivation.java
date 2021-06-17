package org.adam.outputs.impl;

import org.adam.product.NonPhysicalProduct;
import org.adam.product.AbstractProduct;

import java.math.BigDecimal;

public class MembershipActivation extends AbstractProduct implements NonPhysicalProduct {
    public MembershipActivation(final Long id, final BigDecimal cost) {
        super(id, cost);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public BigDecimal getCost() {
        return null;
    }
}
