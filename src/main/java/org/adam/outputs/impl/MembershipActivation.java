package org.adam.outputs.impl;

import org.adam.product.Membership;
import org.adam.product.impl.AbstractProduct;

import java.math.BigDecimal;

public class MembershipActivation extends AbstractProduct implements Membership {
    public MembershipActivation(BigDecimal cost) {
        super(cost);
    }

    @Override
    public BigDecimal getCost() {
        return null;
    }
}
