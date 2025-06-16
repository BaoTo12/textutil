package com.chibao.libusage;

public class TextUtility {

    public static String reverseString(String text) {
        if (text == null) {
            return null;
        }
        return new StringBuilder(text).reverse().toString();
    }

    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("\\s+");

        if (words.length == 1 && words[0].isEmpty()) {
            return 0;
        }

        return words.length;
    }


}
