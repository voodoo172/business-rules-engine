package org.adam.outputs.impl;

import org.adam.outputs.Output;
import org.adam.outputs.OutputDestination;

import java.math.BigDecimal;
import java.util.List;

public class PackingSlip implements Output {
    private final Long productId;
    private final OutputDestination destination;
    private List<String> items;

    public PackingSlip(final Long productId, final OutputDestination destination, List<String> items) {
        this.productId = productId;
        this.destination = destination;
        this.items = items;
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
