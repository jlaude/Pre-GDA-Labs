package week02.largest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arrayLen = in.nextInt();
        int[] inputArray = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++){
            inputArray[i] = in.nextInt();
        }
        Arrays.sort(inputArray);
        System.out.println(inputArray[arrayLen -1]);
    }
}