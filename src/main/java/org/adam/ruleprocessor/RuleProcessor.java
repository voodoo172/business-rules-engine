package org.adam.ruleprocessor;

import org.adam.outputs.Output;
import org.adam.product.Product;

import java.util.List;

public interface RuleProcessor {
    List<Output> processPaymentForProduct(Product product);
}
