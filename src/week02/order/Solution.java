package week02.order;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numArray = new int[3];
        for(int i = 0; i < 3; i++){
            numArray[i] = in.nextInt();
        }
        Arrays.sort(numArray);
        System.out.println(numArray[0] + " " + numArray[1] + " " + numArray[2]);
    }
}