package org.adam.outputs.impl;

import org.adam.outputs.Output;
import org.adam.outputs.OutputDestination;

import java.math.BigDecimal;

public class CommissionPayment implements Output {

    private final Long productId;
    private final OutputDestination destination;
    private final BigDecimal commissionValue;

    public CommissionPayment(Long productId, OutputDestination destination, BigDecimal commissionValue) {
        this.productId = productId;
        this.destination = destination;
        this.commissionValue = commissionValue;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public OutputDestination getDestination() {
        return destination;
    }

    @Override
    public BigDecimal getCommissionValue() {
        return commissionValue;
    }
}
