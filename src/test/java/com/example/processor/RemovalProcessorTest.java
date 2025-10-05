package com.example.processor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemovalProcessorTest {

    private final StringProcessor processor = new StringRemovalProcessor();

    @Test
    void testExampleFromProblem() {
        assertEquals("e", processor.process("aabcccbbaddde"));
    }

    @Test
    void testNoConsecutiveCharacters() {
        assertEquals("abcdefg", processor.process("abcdefg"));
    }

    @Test
    void testExactlyThreeConsecutive() {
        assertEquals("abc", processor.process("aaabbbccc"));
    }

    @Test
    void testMoreThanThreeConsecutive() {
        assertEquals("", processor.process("aaaa"));
    }

    @Test
    void testMultipleSequences() {
        assertEquals("aabb", processor.process("aabbbccdddeeff"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", processor.process(""));
    }

    @Test
    void testNullInput() {
        assertEquals("", processor.process(null));
    }

    @Test
    void testReactionAfterRemoval() {
        // After removing "ccc", "bbb" becomes consecutive
        assertEquals("a", processor.process("abbbccc"));
    }
}
