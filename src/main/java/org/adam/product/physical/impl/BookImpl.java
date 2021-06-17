package org.adam.product.physical.impl;

import org.adam.product.AbstractProduct;
import org.adam.product.ProductType;
import org.adam.product.physical.Book;

import java.math.BigDecimal;

import static org.adam.product.ProductType.BOOK;

public class BookImpl extends AbstractProduct implements Book {

    private final String title;
    private final String author;

    public BookImpl(final Long id, final BigDecimal cost, final String title, final String author) {
        super(id, cost);
        this.title = title;
        this.author = author;
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
        return BOOK;
    }

    @Override
    public boolean isPhysical() {
        return true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
