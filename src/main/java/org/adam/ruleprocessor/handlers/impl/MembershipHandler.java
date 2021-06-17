package org.adam.ruleprocessor.handlers.impl;

import org.adam.outputs.Output;
import org.adam.outputs.impl.Email;
import org.adam.outputs.impl.MembershipActivation;
import org.adam.outputs.impl.MembershipUpgrade;
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
            return switch (product.getProductType()) {
                case STANDARD_MEMBERSHIP -> processMemberActivation(product);
                case ADVANCED_MEMBERSHIP -> processMemberUpgrade(product);
                default -> throw new UnsupportedOperationException("Unsupported Product");
            };
        }
        return List.of();
    }

    private List<Output> processMemberActivation(final Product product) {
        return List.of(new MembershipActivation(), createEmail(product));
    }

    private List<Output> processMemberUpgrade(final Product product) {
        return List.of(new MembershipUpgrade(), createEmail(product));
    }

    Email createEmail(final Product product) {
        return new Email();
    }

    private boolean checkProductIsCorrectType(final Product product) {
        return (product.getProductType() == ProductType.STANDARD_MEMBERSHIP
                || product.getProductType() == ProductType.ADVANCED_MEMBERSHIP) && !product.isPhysical();
    }
}
