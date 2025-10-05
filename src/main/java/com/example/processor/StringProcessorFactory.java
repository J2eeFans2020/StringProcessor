package com.example.processor;

/**
 * @description: Factory class to create appropriate StringProcessor instances
 *
 * @author Dragon
 * @date 09/21/2025 15:37
 * @version 1.0
 */
public class StringProcessorFactory {

    /**
     * String Processor Type。
     */
    public enum StringProcessorType {
        REMOVAL, REPLACEMENT
    }

    /**
     * Creates a StringProcessor based on the specified type
     */
    public static StringProcessor createProcessor(StringProcessorType type) {
        switch (type) {
            case REMOVAL:
                return new StringRemovalProcessor();
            case REPLACEMENT:
                return new StringReplacementProcessor();
            default:
                throw new IllegalArgumentException("Unknown processor type: " + type);
        }
    }
}
