package org.adam.ruleprocessor.handlers.impl;

import org.adam.outputs.Output;
import org.adam.outputs.impl.CommissionPayment;
import org.adam.outputs.OutputDestination;
import org.adam.outputs.impl.PackingSlip;
import org.adam.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProcessor {
    List<Output> processPhysicalProduct(final Product product) {
        final ArrayList<Output> outputs = new ArrayList<>();
        final PackingSlip packingSlip = new PackingSlip(product.getId(), OutputDestination.SHIPPING_DEPT);
        outputs.add(packingSlip);
        final CommissionPayment commissionPayment = new CommissionPayment(product.getId(), OutputDestination.AGENT, getCommissionValue(product));
        outputs.add(commissionPayment);
        return outputs;
    }

    private BigDecimal getCommissionValue(final Product product) {
        if (product.isPhysical()) {
            BigDecimal multiplicand = switch (product.getProductType()) {
                case BOOK -> new BigDecimal("0.1");
                default -> new BigDecimal("0.05");
            };
            return product.getCost().multiply(multiplicand);

        }
        return BigDecimal.ZERO;
    }
}
