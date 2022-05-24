package week04.dna;

import java.util.Scanner;

class Solution {

    public static boolean countRepeatingSTR(String dnaString, String strSequence, int repeatedOccurances) {

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(strSequence).repeat(Math.max(0, repeatedOccurances)));

        if (dnaString.contains(sb.toString())) {
            return !dnaString.contains(sb.append(strSequence).toString());
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfSequences = in.nextInt();
        String[] strArray = new String[numOfSequences];
        for (int i = 0; i < numOfSequences; i++) {
            strArray[i] = in.next();
        }

        in.nextLine();
        int numOfHumans = in.nextInt();
        in.nextLine();
        String[] humanArray = new String[numOfHumans];
        int[][] strCountArray = new int[numOfHumans][];
        for (int i =0; i < numOfHumans; i++) {
            humanArray[i] = in.next();
            int[] tmpSTRArray = new int[numOfSequences];
            for (int j = 0; j < numOfSequences; j++) {
                tmpSTRArray[j] = in.nextInt();
            }
            strCountArray[i] = tmpSTRArray;
            in.nextLine();
        }
        int numOfCases = in.nextInt();
        String[] caseArray = new String[numOfCases];
        in.nextLine();
        for (int i = 0; i < numOfCases; i++) {
            caseArray[i] = in.nextLine();
        }
        in.close();
        int caseNum = 1;
        for (int i =0; i < numOfCases ; i++) {
            System.out.print("Case #" + caseNum + ": ");

            String result = "No match";

            for (int j = 0; j < numOfHumans; j++) {
                StringBuilder checker = new StringBuilder();
                for (int k = 0; k < numOfSequences; k++) {
                    checker.append(countRepeatingSTR(caseArray[i], strArray[k],strCountArray[j][k]));

                }
                if (!checker.toString().contains("false")){
                    result = humanArray[j];
                    break;
                }
            }

            caseNum++;
            System.out.printf(result + "%n");
        }
    }
}