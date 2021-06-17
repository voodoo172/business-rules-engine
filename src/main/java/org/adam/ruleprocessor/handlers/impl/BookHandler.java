package org.adam.ruleprocessor.handlers.impl;

import org.adam.outputs.Output;
import org.adam.outputs.OutputDestination;
import org.adam.outputs.impl.PackingSlip;
import org.adam.product.Product;
import org.adam.product.ProductType;
import org.adam.ruleprocessor.handlers.ProductHandler;

import java.util.List;

public class BookHandler extends AbstractHandler implements ProductHandler {

    public BookHandler() {
    }

    @Override
    public List<Output> handleProduct(final Product product) {
        final boolean productIsCorrectType = checkProductIsCorrectType(product);
        if (productIsCorrectType) {
            final List<Output> outputs = processPhysicalProduct(product);
            final PackingSlip packingSlipForRoyaltyDept = createPackingSlipForRoyaltyDept(product);
            outputs.add(packingSlipForRoyaltyDept);
            return outputs;
        }
        return List.of();
    }

    private PackingSlip createPackingSlipForRoyaltyDept(final Product product) {
        return new PackingSlip(product.getId(), OutputDestination.ROYALTY_DEPT, List.of(product.getTitle()));
    }

    private boolean checkProductIsCorrectType(final Product product) {
        return product.getProductType() == ProductType.BOOK && product.isPhysical();
    }
}
