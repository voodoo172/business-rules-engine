package org.adam.product.impl;

import org.adam.product.Membership;

import java.math.BigDecimal;

public class StandardMembership extends AbstractProduct implements Membership  {
    public StandardMembership(BigDecimal cost) {
        super(cost);
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }
}
