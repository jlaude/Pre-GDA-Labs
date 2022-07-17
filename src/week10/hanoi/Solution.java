package week10.hanoi;

import java.util.Scanner;

public class Solution {

    private static void hanoi(int m, int source, int target, int spare){

        if (m > 0) {
            hanoi(m - 1, source, spare, target);

            System.out.println(source + " " + target);

            hanoi(m - 1, spare, target, source);
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int caseCount = in.nextInt();
        for (int caseX = 1; caseX <= caseCount; caseX++) {
            in.nextLine();
            System.out.println("Case #" + caseX + ":");
            hanoi(in.nextInt(), 1, 3, 2);
        }


    }
}
