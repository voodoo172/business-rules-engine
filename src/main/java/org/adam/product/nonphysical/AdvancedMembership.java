package org.adam.product.nonphysical;

import org.adam.product.AbstractProduct;
import org.adam.product.NonPhysicalProduct;

import java.math.BigDecimal;

public class AdvancedMembership extends AbstractProduct implements NonPhysicalProduct {

    public AdvancedMembership(Long id, BigDecimal cost) {
        super(id, cost);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }
}
