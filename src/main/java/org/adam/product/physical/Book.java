package org.adam.product.physical;

import org.adam.product.PhysicalProduct;

public interface Book extends PhysicalProduct {
    String getTitle();

    String getAuthor();
}
