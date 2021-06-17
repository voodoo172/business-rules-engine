package org.adam.ruleprocessor.handlers.impl;

import org.adam.outputs.Output;
import org.adam.outputs.impl.PackingSlip;
import org.adam.product.Product;
import org.adam.product.ProductType;
import org.adam.ruleprocessor.handlers.ProductHandler;

import java.util.List;

public class VideoHandler extends AbstractHandler implements ProductHandler {

    public static final String LEARNING_TO_SKI = "Learning to Ski";
    public static final String FIRST_AID = "First Aid";

    public VideoHandler() {
    }

    @Override
    public List<Output> handleProduct(Product product) {
        final boolean productIsCorrectType = checkProductIsCorrectType(product);
        if (productIsCorrectType) {
            final List<Output> outputs = processPhysicalProduct(product);
            if (productIsSkiVideo(product)) {
                addFreeItem(outputs);
            }
            return outputs;
        }
        return List.of();
    }

    private void addFreeItem(List<Output> outputs) {
        final PackingSlip output = (PackingSlip) outputs.get(0);
        final List<String> items = output.getItems();
        items.add(FIRST_AID);
        output.setItems(items);
    }

    private boolean productIsSkiVideo(Product product) {
        return product.getTitle().equalsIgnoreCase(LEARNING_TO_SKI);
    }

    private boolean checkProductIsCorrectType(final Product product) {
        return product.getProductType() == ProductType.VIDEO && product.isPhysical();
    }
}
