package org.adam.product.impl;

import org.adam.product.Membership;

import java.math.BigDecimal;

public class AdvancedMembership extends AbstractProduct implements Membership {
    public AdvancedMembership(final BigDecimal cost) {
        super(cost);
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }
}
