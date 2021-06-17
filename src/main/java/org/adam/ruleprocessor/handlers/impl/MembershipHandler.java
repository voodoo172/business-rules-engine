package org.adam.ruleprocessor.handlers.impl;

import org.adam.outputs.Output;
import org.adam.outputs.impl.MembershipActivation;
import org.adam.product.Product;
import org.adam.product.ProductType;
import org.adam.ruleprocessor.handlers.ProcessorComponent;

import java.util.List;

public class MembershipHandler implements ProcessorComponent {
    public MembershipHandler() {
    }

    @Override
    public List<Output> handleProduct(final Product product) {
        final boolean productIsCorrectType = checkProductIsCorrectType(product);
        if (productIsCorrectType) {
            final MembershipActivation membershipActivation = new MembershipActivation();
            return List.of(membershipActivation);
        }
        return List.of();
    }

    private boolean checkProductIsCorrectType(final Product product) {
        return product.getProductType() == ProductType.STANDARD_MEMBERSHIP && !product.isPhysical();
    }
}
