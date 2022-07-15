package week10.fibonacci;

import java.util.Scanner;

public class Solution {

    private static int F(int n) {
        int result = 0;
        if (n < 2) {
            return n;
        } else {
            result = F(n-2) + F(n-1);
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseCount = in.nextInt();
        for (int caseX = 1; caseX <= caseCount; caseX++) {
            in.nextLine();
            System.out.println("Case #" + caseX + ": " + F(in.nextInt()));
        }
    }
}
