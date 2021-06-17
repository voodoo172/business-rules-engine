package org.adam.product.physical.impl;

import org.adam.product.AbstractProduct;
import org.adam.product.ProductType;
import org.adam.product.physical.Video;

import java.math.BigDecimal;

public class VideoImpl extends AbstractProduct implements Video {
    public VideoImpl(final Long id, final BigDecimal cost) {
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
        return ProductType.VIDEO;
    }

    @Override
    public boolean isPhysical() {
        return true;
    }
}
