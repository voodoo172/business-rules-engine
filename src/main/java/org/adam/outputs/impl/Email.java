package org.adam.outputs.impl;

import org.adam.outputs.Output;
import org.adam.outputs.OutputDestination;

import java.math.BigDecimal;

import static org.adam.outputs.OutputDestination.*;

public class Email implements Output {

    public Email() {
    }

    @Override
    public Long getProductId() {
        return null;
    }

    @Override
    public OutputDestination getDestination() {
        return CUSTOMER;
    }

    @Override
    public BigDecimal getCommissionValue() {
        return null;
    }
}
