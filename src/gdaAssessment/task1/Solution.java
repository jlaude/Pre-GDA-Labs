package gdaAssessment.task1;

public class Solution {

    public static String[] findTargetWords(String[] input) {

        int indexOfMostVowels = 0;
        int countOfMostVowels = countVowels(input[0]);
        int indexOfMostNonAlphabetic = 0;
        int countOfMostNonAlphabetic = countNonAlphabeticChars(input[0]);
        int indexOfMostConsonants = 0;
        int countOfMostConsonants = input[0].length() - countOfMostVowels - countOfMostNonAlphabetic;

        // iterate through each string
        for (int i = 1; i < input.length; i++) {

            // getting the count of vowels in the current and previous strings in the input array
            int countOfVowels = countVowels(input[i]);

            // if the count of vowels in the current string are greater than the previous string, reassign the index which has the most vowels
            if (countOfVowels > countOfMostVowels) {
                indexOfMostVowels = i;
            }

            // getting the count of non-alphabetic characters
            int countOfNonAlphabetic = countNonAlphabeticChars(input[i]);
            if (countOfNonAlphabetic > countOfMostNonAlphabetic) {
                indexOfMostNonAlphabetic = i;
            }

            // Subtracting count of vowels and count of non alphabetic chars from length of string to get count of consonants

            int countOfConsonants = input[i].length() -  countOfVowels - countOfNonAlphabetic;
            if (countOfConsonants > countOfMostConsonants) {
                indexOfMostConsonants = i;
            }
        }
        return new String[] {input[indexOfMostConsonants], input[indexOfMostVowels], input[indexOfMostNonAlphabetic]};
    }

    public static int countVowels (String input) {
        char[] vowelArray = {'a','e','i','o','u','y'};
        long vowelCount = 0;
        // iterating through each vowel
        for (int i = 0; i < vowelArray.length; i++) {
            int finalI = i;
            // streaming filter to count how many occurrences of the vowel occur in the input string
            vowelCount = vowelCount + input.chars().filter(ch -> ch == vowelArray[finalI]).count();
        }
        return (int) vowelCount;
    }

    public static int countNonAlphabeticChars (String input) {
        // Stripping the input string of any
        String strippedInput = input.replaceAll("[a-zA-Z]*", "");
        // returning the amount of characters left in the array;
        return strippedInput.length();
    }

    public static void main(String[] args) {
        String[] result;
        result = findTargetWords(new String[] {"strengths", "ant 1", "turkey", "facetious"});
        System.out.println("Example 1 returned " + String.join(", ", result));
        result = findTargetWords(new String[] {"cat", "oat"});
        System.out.println("Example 2 returned " + String.join(", ", result));

    }
}
