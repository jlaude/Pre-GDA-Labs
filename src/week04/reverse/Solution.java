package week04.reverse;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static ArrayList<String> reverseString(String input) {
        String[] strToArray = input.split("\\s+");
        //StringBuilder sb = new StringBuilder(input);
        ArrayList<String> reversedResult = new ArrayList<>();
        for (String current : strToArray) {
            StringBuilder sb = new StringBuilder(current).reverse();
            reversedResult.add(sb.toString());
        }
        return reversedResult;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseLen = in.nextInt();
        in.nextLine();
        String[] caseArray = new String[caseLen];
        for (int i =0; i < caseLen; i++) {
            caseArray[i] = in.nextLine();
        }
        in.close();
        int caseNum = 1;
        for (int i =0; i < caseLen ; i++) {
            System.out.print("Case #" + caseNum + ":");
            for (String word : reverseString(caseArray[i])) {
                System.out.print(" " + word);
            }
            caseNum++;
            System.out.printf("%n");
        }
    }
}