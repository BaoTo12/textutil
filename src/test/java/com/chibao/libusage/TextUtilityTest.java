package com.chibao.libusage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class TextUtilityTest {
    @Test
    void testSuccessReverseStringWithHello() {
        Assertions.assertThat("hello").isEqualTo(TextUtility.reverseString("olleh"));
    }

    @Test
    void testSuccessReverseStringWithEmptyString() {
        Assertions.assertThat("").isEqualTo(TextUtility.reverseString(""));
    }

//    @Test
//    void testSuccessReverseStringWithSingleCharacter() {
//        Assertions.assertThat("a").isEqualTo(TextUtility.reverseString("a"));
//    }
//
//    @Test
//    void testFailureReverseStringWithHelloWorld() {
//        Assertions.assertThat("hello world").isEqualTo(TextUtility.reverseString("dlrow olleh"));
//    }

    @Test
    void testFailureReverseStringWithNullString() {
        Assertions.assertThatThrownBy(() -> TextUtility.reverseString(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testSuccessCountWordsWithHelloWorldJava() {
        Assertions.assertThat(TextUtility.countWords("Hello world Jav")).isEqualTo(3);
    }


//    @Test
//    void testSuccessCountWordsWithHelloWorldJavaAndLeadingSpaces() {
//        Assertions.assertThat(TextUtility.countWords("  Hello world Java  ")).isEqualTo(3);
//    }
//
//    @Test
//    void testSuccessCountWordsWithHelloWorldJavaAndMultiSpacesBetween() {
//        Assertions.assertThat(TextUtility.countWords("Hello   world     Java")).isEqualTo(3);
//    }



}