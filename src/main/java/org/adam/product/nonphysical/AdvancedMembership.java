package org.adam.product.nonphysical;

import org.adam.product.Product;
import org.adam.product.ProductType;

import java.math.BigDecimal;

import static org.adam.product.ProductType.ADVANCED_MEMBERSHIP;

public class AdvancedMembership extends StandardMembership implements Product {

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

    @Override
    public ProductType getProductType() {
        return ADVANCED_MEMBERSHIP;
    }

    @Override
    public boolean isPhysical() {
        return false;
    }
}
