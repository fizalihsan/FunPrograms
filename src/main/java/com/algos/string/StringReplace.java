package com.algos.string;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 5:53 PM
 */
public class StringReplace {

    public static void main(String[] args) {
        System.out.println(replaceAll("Hello, How are you?", 'l', "X")); //prints "Hello, How are you?"
    }

    /**
     * Replaces the given character 'match' with 'replacement' in the 'input' string. Scans from right-to-left for O(n) efficiency.
     * Left-to-right would lead to O(n^2).
     *
     * @param input
     * @param match
     * @param replacement
     * @return
     */
    static String replaceAll(String input, char match, String replacement) {
        char[] inputChars = input.toCharArray();
        int count = 0;

        for (char inputChar : inputChars) {
            if (inputChar == match) count++;
        }

        if (count > 0) {
            char[] replaceChars = replacement.toCharArray();
            int newLength = inputChars.length + (count * (replaceChars.length - 1));
            char[] resultChars = new char[newLength];

            int i = inputChars.length - 1;
            while (i >= 0) {
                if (inputChars[i] == match) {
                    for (int j = replaceChars.length - 1; j >= 0; j--) {
                        resultChars[--newLength] = replaceChars[j];
                    }
                } else {
                    resultChars[--newLength] = inputChars[i];
                }
                i--;
            }
            return new String(resultChars);
        }
        return input;
    }
}
