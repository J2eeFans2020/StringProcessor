package com.example.processor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: Processor that replaces sequences of 3 or more consecutive identical characters
 * with the previous character in the alphabet
 *
 * @author Dragon
 * @date 09/21/2025 15:40
 * @version 1.0
 */
public class StringReplacementProcessor implements StringProcessor {

    @Override
    public String process(String inputStr) {
        // check whether the input string is empty.
        if (inputStr == null || inputStr.isEmpty()) {
            return "";
        }

        // create a double-ended queue object for handling characters and character counting.
        Deque<CharacterCount> charCntStack = new ArrayDeque<>();
        for (char c : inputStr.toCharArray()) {
            if (!charCntStack.isEmpty() && charCntStack.peek().character == c) {
                charCntStack.peek().incrementCount();
            } else {
                charCntStack.push(new CharacterCount(c));
            }

            // Replace if count reaches 3
            while (!charCntStack.isEmpty() && charCntStack.peek().cnt >= 3) {
                CharacterCount removed = charCntStack.pop();
                char replacement = getPreviousCharacter(removed.character);
                
                if (replacement != 0) { // Check if replacement is valid
                    if (!charCntStack.isEmpty() && charCntStack.peek().character == replacement) {
                        charCntStack.peek().incrementCount();
                    } else {
                        charCntStack.push(new CharacterCount(replacement));
                    }
                }
            }
        }

        // Build the result string from the stack
        return buildResultString(charCntStack);
    }

    /**
     * Get the previous character in the alphabet (a -> no previous character)
     */
    private char getPreviousCharacter(char c) {
        if (c == 'a') {
            return 0; // No previous character
        }
        return (char) (c - 1);
    }

    private String buildResultString(Deque<CharacterCount> stack) {
        StringBuilder result = new StringBuilder();
        
        // Process stack in reverse order since we used push/pop
        stack.descendingIterator()
                .forEachRemaining(cc -> result.append(String.valueOf(cc.character).repeat(cc.cnt)));
             
        return result.toString();
    }

    /**
     * Helper class to track character and its consecutive count
     */
    private static class CharacterCount {
        char character;
        int cnt;

        CharacterCount(char character) {
            this.character = character;
            this.cnt = 1;
        }

        void incrementCount() {
            this.cnt++;
        }
    }
}
