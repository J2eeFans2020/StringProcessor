package com.example.processor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringReplacementProcessorTest {

    private final StringProcessor processor = new StringReplacementProcessor();

    @Test
    void testExampleFromProblem() {
        assertEquals("e", processor.process("abcccbaddde"));
    }

    @Test
    void testCccReplacedByB() {
        assertEquals("ba", processor.process("cccbbb"));
    }

    @Test
    void testBbbReplacedByA() {
        assertEquals("ab", processor.process("bbbccc"));
    }

    @Test
    void testAaaReplacedByNothing() {
        assertEquals("", processor.process("aaaa"));
    }

    @Test
    void testMultipleReplacements() {
        // abcccbad -> abbbad -> aaad -> d
        assertEquals("d", processor.process("abcccbad"));
    }

    @Test
    void testReplacementCausesNewSequence() {
        // aaaabbbbb -> a + bbbbb -> a + a (since bbbbb -> bbb after first replacement, then a)
        assertEquals("a", processor.process("aaaabbbbb"));
    }

    @Test
    void testNoConsecutiveCharacters() {
        assertEquals("abcdef", processor.process("abcdef"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", processor.process(""));
    }

    @Test
    void testNullInput() {
        assertEquals("", processor.process(null));
    }
}
