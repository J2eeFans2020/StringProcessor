package com.example.processor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: Processor that removes sequences of 3 or more consecutive identical characters
 *
 * @author Dragon
 * @date 09/21/2025 15:38
 * @version 1.0
 */
public class StringRemovalProcessor implements StringProcessor {

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

            // Remove if count reaches 3
            assert charCntStack.peek() != null;
            if (charCntStack.peek().cnt >= 3) {
                charCntStack.pop();
            }
        }

        // Build the result string from the stack
        return buildResultString(charCntStack);
    }

    private String buildResultString(Deque<CharacterCount> stackCnt) {
        StringBuilder result = new StringBuilder();
        
        // Process stack in reverse order since we used push/pop
        stackCnt.descendingIterator()
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
