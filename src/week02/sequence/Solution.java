package week02.sequence;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputNumber = in.nextInt();
        int[] seqArray = new int[inputNumber];
        int counter = 0;
        for (int i = 1; counter < seqArray.length; i++){
            for (int j = 1; j <= i && counter < seqArray.length; j++){
                seqArray[counter] = i;
                counter ++;
            }

        }
        for (int j : seqArray) {
            System.out.print(j + " ");
        }
    }
}