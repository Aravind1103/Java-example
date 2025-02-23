package com.dp.decorator;

public class MagicString {
    private String string;

    public MagicString(String string) {
        this.string = string;
    }

    public long getNumberOfVowels() {
        return string.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".contains(c.toString()))
                .count();
    }

    @Override
    public String toString() {
        return string;
    }

    public int length() {
        return string.length();
    }

    public boolean isEmpty() {
        return string.isEmpty();
    }

    public char charAt(int index) {
        return string.charAt(index);
    }
}
