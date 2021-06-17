package org.adam.outputs;

import java.math.BigDecimal;

public interface Output {
    Long getProductId();

    OutputDestination getDestination();

    BigDecimal getCommissionValue();
}
