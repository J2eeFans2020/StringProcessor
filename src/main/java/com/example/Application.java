package com.example;

import com.example.processor.StringProcessor;
import com.example.processor.StringProcessorFactory;
import com.example.processor.StringProcessorFactory.StringProcessorType;

import java.util.Scanner;

/**
 * @description: Main application class to demonstrate the character processing functionality
 *
 * @author Dragon
 * @date 09/21/2025 15:36
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string to process (only a-z characters):");
            String input = scanner.nextLine();
            
            // Validate input
            if (!input.matches("[a-z]*")) {
                System.out.println("Error: Input must contain only lowercase letters (a-z)");
                return;
            }
            
            // Process with removal processor (Stage 1)
            StringProcessor removalProcessor = StringProcessorFactory.createProcessor(StringProcessorType.REMOVAL);
            String removalResult = removalProcessor.process(input);
            System.out.println("Stage 1 (Removal) Result: " + removalResult);
            
            // Process with replacement processor (Stage 2)
            StringProcessor replacementProcessor = StringProcessorFactory.createProcessor(StringProcessorType.REPLACEMENT);
            String replacementResult = replacementProcessor.process(input);
            System.out.println("Stage 2 (Replacement) Result: " + replacementResult);
        }
    }
}
