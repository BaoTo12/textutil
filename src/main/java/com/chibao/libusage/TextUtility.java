package com.chibao.libusage;

public class TextUtility {

    public static String reverseString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        return new StringBuilder(text).reverse().toString();
    }

    public static int countWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("text must not be empty");
        }

      return trimmed.split("\\s+").length;
    }


}
