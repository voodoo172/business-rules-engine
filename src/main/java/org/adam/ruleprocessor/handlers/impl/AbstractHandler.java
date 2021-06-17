package org.adam.ruleprocessor.handlers.impl;

import org.adam.outputs.Output;
import org.adam.outputs.impl.CommissionPayment;
import org.adam.outputs.OutputDestination;
import org.adam.outputs.impl.PackingSlip;
import org.adam.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHandler {
    List<Output> processPhysicalProduct(final Product product) {
        final ArrayList<Output> outputs = new ArrayList<>();
        final ArrayList<String> packingList = createPackingList(product);
        final PackingSlip packingSlip = new PackingSlip(product.getId(), OutputDestination.SHIPPING_DEPT, packingList);
        outputs.add(packingSlip);
        final CommissionPayment commissionPayment = new CommissionPayment(product.getId(), OutputDestination.AGENT, getCommissionValue(product));
        outputs.add(commissionPayment);
        return outputs;
    }

    private ArrayList<String> createPackingList(Product product) {
        final ArrayList<String> packingList = new ArrayList<>();
        packingList.add(product.getTitle());
        return packingList;
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
