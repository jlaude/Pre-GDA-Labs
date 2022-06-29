package gdaAssessment.task2;

public class Solution {

    public static void swap (String strA, String strB, int strALength, int strBLength, int moveIndex) {

        if (moveIndex > strBLength) {
            return;
        }

        StringBuilder resultString =  new StringBuilder();
        // build beginning result string - for example if the input string is abc123 and the index is 1, string will be ab1c23; index is 2, result string is a1bc23, and so on
        resultString.append(strA.substring(0,strALength - moveIndex));
        resultString.append(strB.charAt(0));
        resultString.append(strA.substring(strALength - moveIndex));
        resultString.append(strB.substring(1));



        // iterating through each char in string B
        for (int characterBIndex = 1; characterBIndex <= strBLength - 1; characterBIndex++) {

            //moving each character one place at a time to the left, until it hits the move index
            for (int j = 0; j < moveIndex; j++) {
                char tempA = resultString.charAt(strALength + characterBIndex - j);
                char tempB = resultString.charAt(strALength + characterBIndex - j -1);

                resultString.setCharAt(strALength + characterBIndex - j, tempB);
                resultString.setCharAt(strALength + characterBIndex - j -1, tempA);

                //TODO add check to
                // Ensuring there are no repeated characters
               /* if (startIndexIterator > 1) {
                    char tempC = resultArray[startIndexIterator -2];
                    if (!(tempA == tempC || tempA == tempB)) {
                        System.out.println(resultString);
                    }
                } else if (!(tempA == tempB)){
                    System.out.println(resultString);
                }

                */
                System.out.println(resultString.toString());
            }

        }
        swap(strA, strB, strALength, strBLength, moveIndex + 1);

    }

    public static void main(String[] args) {
        String strA = "abc";
        String strB = "123";
        String str = strA + strB;

        //TODO - add check for if any adjacent characters are the same
        System.out.println(str);
        swap(strA, strB, strA.length(), strB.length(), 1);

    }
}
