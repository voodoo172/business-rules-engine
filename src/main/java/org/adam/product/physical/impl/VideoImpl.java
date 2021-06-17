package org.adam.product.physical.impl;

import org.adam.product.AbstractProduct;
import org.adam.product.ProductType;
import org.adam.product.physical.Video;

import java.math.BigDecimal;

public class VideoImpl extends AbstractProduct implements Video {
    private final String title;

    public VideoImpl(final Long id, final String title, final BigDecimal cost) {
        super(id, cost);
        this.title = title;
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

    @Override
    public String getTitle() {
        return title;
    }
}
