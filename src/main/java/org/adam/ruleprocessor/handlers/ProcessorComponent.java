package org.adam.ruleprocessor.handlers;

import org.adam.outputs.Output;
import org.adam.product.Product;

import java.util.List;

public interface ProcessorComponent {
   List<Output> handleProduct(Product product);
}
