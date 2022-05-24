package week04.rotate;

import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static int[] rotateArray(int[] inputArray, int rotateTimes) {
        int rotations = rotateTimes % inputArray.length;
        int[] resultArray = new int[inputArray.length];

        System.arraycopy(inputArray, 0, resultArray, 0, inputArray.length);

        for (int n = 0; n < rotations; n++) {

            int last = resultArray[resultArray.length - 1];

            for (int j = resultArray.length - 1; j >= 0; j--) {
                if (j == 0) {
                    resultArray[j] = last;
                } else {
                    resultArray[j] = resultArray[j - 1];
                }

            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        in.nextLine();
        int[][] caseArray = new int[cases][];
        int[] rotateTimesArray = new int[cases];
        for (int i =0; i < cases; i++) {
            rotateTimesArray[i] = in.nextInt();
            int arrayLen = in.nextInt();
            int[] tempArray = new int[arrayLen];
            for (int j=0; j < arrayLen; j++) {

                tempArray[j] = in.nextInt();

            }
            caseArray[i] = tempArray;
            in.nextLine();
        }
        in.close();
        int caseNum = 1;
        for (int i =0; i < cases ; i++) {
            System.out.print("Case #" + caseNum + ": ");

            int[] resultArray;

            if (rotateTimesArray[i] % caseArray[i].length == 0) resultArray = caseArray[i];
            else {
                resultArray = rotateArray(caseArray[i], rotateTimesArray[i]);
            }

            String resultString = Arrays.toString(resultArray).replaceAll("\\[|\\]|,", "");
            System.out.printf(resultString + "%n");
            caseNum++;
        }
    }
}