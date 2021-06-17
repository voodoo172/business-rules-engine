package org.adam.outputs.impl;

import org.adam.outputs.Output;
import org.adam.outputs.OutputDestination;

import java.math.BigDecimal;

public class PackingSlip implements Output {
    private final Long productId;
    private final OutputDestination destination;

    public PackingSlip(final Long productId, final OutputDestination destination) {
        this.productId = productId;
        this.destination = destination;
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
        return null;
    }
}
