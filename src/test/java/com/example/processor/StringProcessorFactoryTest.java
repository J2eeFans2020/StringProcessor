package com.example.processor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorFactoryTest {

    @Test
    void testCreateRemovalProcessor() {
        StringProcessor processor = StringProcessorFactory.createProcessor(StringProcessorFactory.StringProcessorType.REMOVAL);
        assertTrue(processor instanceof StringRemovalProcessor);
    }

    @Test
    void testCreateReplacementProcessor() {
        StringProcessor processor = StringProcessorFactory.createProcessor(StringProcessorFactory.StringProcessorType.REPLACEMENT);
        assertTrue(processor instanceof StringReplacementProcessor);
    }

    @Test
    void testCreateUnknownProcessor() {
        assertThrows(IllegalArgumentException.class, () -> 
            StringProcessorFactory.createProcessor(null));
    }
}
