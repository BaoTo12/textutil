package com.chibao.libusage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class TextUtilityDDTTest {

    public static Object[][] initDataReverseString() {
        return new Object[][]{
                {"hello", "olle"},
                {"world", "dlrow"},
                {"a", "a"},
                {"", ""},
                {null, null}
        };
    }

    @ParameterizedTest
    @MethodSource("initDataReverseString")
    void testReverseStringWithArgsRunWell(String input, String expectedInput){
        Assertions.assertThat(TextUtility.reverseString(input)).isEqualTo(expectedInput);
    }

    @ParameterizedTest
    @CsvSource({
            "hello world, 2",
            "single, 1",
            "'', 0",
            "   , 0",
            "null, 0",
            "Java, 1",
            "one two three four five, 5",
            "word-with-hyphen, 1",
            "  one   two   , 2",
            "  hello  world  how  are  you  , 5"
    })
    void testCountWords(String inputText, int expectedWordCount) {
        // Use AssertJ for the assertion
        if ("null".equals(inputText)) {
            Assertions.assertThat(TextUtility.countWords(null))
                    .isEqualTo(expectedWordCount);
        } else {
            Assertions.assertThat(TextUtility.countWords(inputText))
                    .isEqualTo(expectedWordCount);
        }
    }
}
