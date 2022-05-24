package week04.extremes;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void normalizeArray(int[] inputArray, int size) {
        Arrays.sort(inputArray);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        in.nextLine();
        int[][] caseArray = new int[cases][];
        for (int i =0; i < cases; i++) {
            int caseLen = in.nextInt();
            int[] tempArray = new int[caseLen];
            for (int j=0; j < caseLen; j++) {

                tempArray[j] = in.nextInt();

            }
            caseArray[i] = tempArray;
            in.nextLine();
        }
        in.close();
        int caseNum = 1;
        for (int i =0; i < cases ; i++) {
            System.out.print("Case #" + caseNum + ": ");

            normalizeArray(caseArray[i],cases);
            int min = caseArray[i][0];
            int max = caseArray[i][caseArray[i].length - 1];

            int minCounter = 0;
            int maxCounter = 0;

            if (min == max) {
                for (int num : caseArray[i]) {
                    minCounter++;
                }
            } else {

                for (int num : caseArray[i]) {
                    if (num == min) {
                        minCounter++;
                    } else {
                        break;
                    }
                }
                for (int k = caseArray[i].length -1; k >=0; k--) {
                    if (caseArray[i][k] == max) {
                        maxCounter++;
                    } else {
                        break;
                    }
                }
            }


            int resultCounter = minCounter + maxCounter;
            caseNum++;
            System.out.printf(resultCounter + "%n");
        }
    }
}