package com.example.processor;

/**
 * @description: Interface for processing strings with consecutive characters
 * with the previous character in the alphabet
 *
 * @author Dragon
 * @date 09/21/2025 15:36
 * @version 1.0
 */
@FunctionalInterface
public interface StringProcessor {

    /**
     * building string processor object.
     *
     * @param inputStr string processor type
     * @return process result.
     */
    String process(String inputStr);
}
