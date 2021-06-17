package org.adam.product;

import java.math.BigDecimal;

public abstract class AbstractProduct {
    public final Long id;
    public final BigDecimal cost;

    public AbstractProduct(final Long id, final BigDecimal cost) {
        this.id = id;
        this.cost = cost;
    }
}
