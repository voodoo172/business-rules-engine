package org.adam.outputs.impl;

import org.adam.outputs.Output;
import org.adam.outputs.OutputDestination;

import java.math.BigDecimal;

public class MembershipUpgrade implements Output {
    public MembershipUpgrade() {
    }

    @Override
    public Long getProductId() {
        return null;
    }

    @Override
    public OutputDestination getDestination() {
        return null;
    }

    @Override
    public BigDecimal getCommissionValue() {
        return null;
    }
}
