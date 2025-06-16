package com.chibao.libusage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class TextUtilityDDTTest {

    public static Object[][] initDataReverseString() {
        return new Object[][] {
                {"hello", "olleh"},
                {"world", "dlrow"},
                {"a",     "a"},
                {"",      ""}
        };
    }

    @ParameterizedTest
    @MethodSource("initDataReverseString")
    void testReverseStringValidInputs(String input, String expected) {
        Assertions.assertThat(TextUtility.reverseString(input))
                .isEqualTo(expected);
    }



    @ParameterizedTest
    @CsvSource({
            "hello world,        2",
            "single,             1",
            "Java,               1",
            "one two three four five, 5",
            "word-with-hyphen,   1",
            "  one   two   ,     2",
            "  hello  world  how  are  you  , 5"
    })
    void testCountWordsValidInputsRunsWell(String input, int expectedCount) {

        Assertions.assertThat(TextUtility.countWords(input))
                .isEqualTo(expectedCount);
    }



    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { "   " })
    void testCountWordsNullOrBlankThrowsIllegalArgumentException(String input) {
        Assertions.assertThatThrownBy(() -> TextUtility.countWords(input))
                .isInstanceOf(IllegalArgumentException.class)
                .satisfies(ex -> {
                    if (input == null) {
                        Assertions.assertThat(ex).hasMessage("text must not be null");
                    } else {
                        Assertions.assertThat(ex).hasMessage("text must not be empty");
                    }
                });
    }
}
