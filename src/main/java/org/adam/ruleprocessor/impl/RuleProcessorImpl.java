package org.adam.ruleprocessor.impl;

import org.adam.outputs.Output;
import org.adam.product.Product;
import org.adam.product.ProductType;
import org.adam.ruleprocessor.RuleProcessor;
import org.adam.ruleprocessor.handlers.ProcessorComponent;
import org.adam.ruleprocessor.handlers.impl.BookHandler;
import org.adam.ruleprocessor.handlers.impl.MembershipHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class RuleProcessorImpl implements RuleProcessor {

    private final Map<ProductType, ProcessorComponent> handlerMap = new HashMap<>();

    public RuleProcessorImpl() {
        initialiseHandlerMap();
    }

    private void initialiseHandlerMap() {
        handlerMap.put(ProductType.BOOK, new BookHandler());
        handlerMap.put(ProductType.STANDARD_MEMBERSHIP, new MembershipHandler());
    }

    @Override
    public List<Output> processPaymentForProduct(final Product product) {
        final ProductType productType = product.getProductType();
        final ProcessorComponent processorComponent = handlerMap.get(productType);
        if (nonNull(processorComponent)){
            return processorComponent.handleProduct(product);
        }
        throw new IllegalArgumentException("product type not supported");
    }
}
