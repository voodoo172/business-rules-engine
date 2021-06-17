package org.adam.ruleprocessor.impl;

import org.adam.outputs.Output;
import org.adam.product.Product;
import org.adam.product.ProductType;
import org.adam.ruleprocessor.RuleProcessor;
import org.adam.ruleprocessor.handlers.ProductHandler;
import org.adam.ruleprocessor.handlers.impl.BookHandler;
import org.adam.ruleprocessor.handlers.impl.MembershipHandler;
import org.adam.ruleprocessor.handlers.impl.VideoHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class RuleProcessorImpl implements RuleProcessor {

    private final Map<ProductType, ProductHandler> handlerMap = new HashMap<>();

    public RuleProcessorImpl() {
        initialiseHandlerMap();
    }

    private void initialiseHandlerMap() {
        handlerMap.put(ProductType.BOOK, new BookHandler());
        final MembershipHandler membershipHandler = new MembershipHandler();
        handlerMap.put(ProductType.STANDARD_MEMBERSHIP, membershipHandler);
        handlerMap.put(ProductType.ADVANCED_MEMBERSHIP, membershipHandler);
        handlerMap.put(ProductType.VIDEO, new VideoHandler());
    }

    @Override
    public List<Output> processPaymentForProduct(final Product product) {
        final ProductType productType = product.getProductType();
        final ProductHandler productHandler = handlerMap.get(productType);
        if (nonNull(productHandler)){
            return productHandler.handleProduct(product);
        }
        throw new IllegalArgumentException("product type not supported");
    }
}
