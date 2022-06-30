package gdaAssessment.task2;

public class Solution {

    static class interleavedStrings {

        String strA;
        String strB;
        int strALength;
        int strBLength;

        public interleavedStrings(String strA, String strB) {
            this.strA = strA;
            this.strB = strB;
            this.strALength = strA.length();
            this.strBLength = strB.length();
        }

        public void interleave( int moveIndex) {


            // recursion stop condition when it's moved strB all the way through string A
            if (moveIndex > strALength) {
                return;
            }

            StringBuilder resultString = new StringBuilder();

            // build beginning result string - for example if the input string is abc123 and the index is 1, string will be ab1c23; index is 2, result string is a1bc23, and so on
            resultString.append(strA.substring(0, strALength - moveIndex));
            resultString.append(strB.charAt(0));
            resultString.append(strA.substring(strALength - moveIndex));
            resultString.append(strB.substring(1));


            /*
            // print the initial seeded result string
            if (checkNonRepeatingAdjacentChars(resultString.toString(), strALength - moveIndex)) {
                System.out.println(resultString);
            }
             */
            System.out.println(resultString);

            // iterating through the remaining chars in string B, moving them to the left one character at a time
            for (int characterBIndex = 1; characterBIndex <= strBLength - 1; characterBIndex++) {

                //moving each remaining character in strB one place at a time to the left, until it hits the move index
                swapChars(resultString, characterBIndex, moveIndex, 0);

            }
            interleave(moveIndex + 1);

        }

        public void swapChars (StringBuilder resultString, int characterBIndex, int moveIndex, int moveCharBLeftIterator) {

            // recursion stop condition when the character has been moved all the way through string A up to the current move Index
            if (moveCharBLeftIterator == moveIndex) {
                return;
            }

            char currentChar = resultString.charAt(strALength + characterBIndex - moveCharBLeftIterator);
            char prevChar = resultString.charAt(strALength + characterBIndex - moveCharBLeftIterator - 1);

            resultString.setCharAt(strALength + characterBIndex - moveCharBLeftIterator, prevChar);
            resultString.setCharAt(strALength + characterBIndex - moveCharBLeftIterator - 1, currentChar);

            /*
            // Ensuring there are no repeated characters
            if (checkNonRepeatingAdjacentChars(resultString.toString(), strALength + characterBIndex - moveCharBLeftIterator - 1)) {
                System.out.println(resultString);
            }
             */
            System.out.println(resultString);


            swapChars(resultString, characterBIndex, moveIndex, moveCharBLeftIterator + 1);
        }
    }

    public static void main(String[] args) {
        String strA = "abc";
        String strB = "cab";
        String str = strA + strB;

        //if (checkNonRepeatingAdjacentChars(str, strA.length())) {System.out.println(str);}
        System.out.println(str);

        interleavedStrings iLS = new interleavedStrings(strA, strB);
        // seeing the initial 'moveIndex' (moveIndex keeps track of how far the first character in strB has moved through strA)
        iLS.interleave(1);
    }

    public static boolean checkNonRepeatingAdjacentChars (String resultString, int locationOfCharB) {

        char currentChar = resultString.charAt(locationOfCharB);

        boolean result = false;

        if (locationOfCharB == resultString.length() - 1) {
            char prevChar = resultString.charAt(locationOfCharB - 1);
            if (!(currentChar == prevChar)) {
                result = true;
            }
        } else if (locationOfCharB >= 1) {
            char nextChar = resultString.charAt(locationOfCharB + 1);
            char prevChar = resultString.charAt(locationOfCharB - 1);
            if (!(currentChar == prevChar || currentChar == nextChar)) {
                result = true;
            }
        } else if (locationOfCharB == 0){
            char nextChar = resultString.charAt(locationOfCharB + 1);
            if (!(currentChar == nextChar)) {
                result = true;
            }
        }
        return result;
    }


}
