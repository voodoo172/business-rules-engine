package org.adam.product;

import java.math.BigDecimal;

public interface Product {
    Long getId();

    BigDecimal getCost();

    ProductType getProductType();

    boolean isPhysical();

    String getTitle();
}
