package org.adam.product.impl;

import java.math.BigDecimal;

public abstract class AbstractProduct {
    final BigDecimal cost;

    public AbstractProduct(final BigDecimal cost) {
        this.cost = cost;
    }
}
