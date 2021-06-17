package org.adam.logictests;

import org.adam.outputs.Output;
import org.adam.outputs.impl.PackingSlip;
import org.adam.product.physical.Book;
import org.adam.product.physical.impl.BookImpl;
import org.adam.ruleprocessor.RuleProcessor;
import org.adam.ruleprocessor.impl.RuleProcessorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.adam.outputs.OutputDestination.ROYALTY_DEPT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTests {
    private RuleProcessor ruleProcessor;

    @BeforeEach
    public void setupRuleProcessor() {
        ruleProcessor = new RuleProcessorImpl();
    }

    @Test
    public void physicalProductGeneratesPackingSlip() {
        final Book book = new BookImpl(123L, new BigDecimal("5.99"), "Peter Pan", "J. M. Barrie");
        final List<Output> outputs = ruleProcessor.processPaymentForProduct(book);
        assertTrue(outputs.stream()
                .anyMatch(object -> object instanceof PackingSlip));
    }

    @Test
    public void bookGeneratesDuplicatePackingSlip() {
        final Book book = new BookImpl(123L, new BigDecimal("5.99"), "Peter Pan", "J. M. Barrie");
        final List<Output> outputs = ruleProcessor.processPaymentForProduct(book);
        assertEquals(2, outputs.stream().filter(object -> object instanceof PackingSlip).count());
        assertTrue(outputs.stream().anyMatch(object -> object instanceof PackingSlip && object.getDestination() == ROYALTY_DEPT));
    }

    @Test
    public void membershipActivatesMembership() {
    }

    @Test
    public void membershipUpgradeUpgradesMembership() {
    }

    @Test
    public void membershipPaymentGeneratesCustomerEmail() {
    }

    @Test
    public void membershipUpgradeGeneratesCustomerEmail() {
    }

    @Test
    public void paymentForVideoGeneratesPackingSlipWithAdditionalVideo() {
    }


}
