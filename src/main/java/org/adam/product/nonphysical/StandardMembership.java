package org.adam.product.nonphysical;

import org.adam.product.AbstractProduct;
import org.adam.product.Product;
import org.adam.product.ProductType;

import java.math.BigDecimal;

public class StandardMembership extends AbstractProduct implements Product {

    public StandardMembership(Long id, BigDecimal cost) {
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
        return ProductType.STANDARD_MEMBERSHIP;
    }

    @Override
    public boolean isPhysical() {
        return false;
    }
}
