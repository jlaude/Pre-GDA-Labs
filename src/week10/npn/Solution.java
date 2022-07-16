package week10.npn;

import java.util.Scanner;

public class Solution {

    private static double npn(Scanner in) {

        double result = 0.0;

        if (in.hasNextDouble()) {
            return in.nextDouble();
        } else {

            switch (in.next()) {

                case "+":
                    result = npn(in) + npn(in);
                    break;
                case "-":
                    result = npn(in) - npn(in);
                    break;
                case "*":
                    result = npn(in) * npn(in);
                    break;
                case "/":
                    result = npn(in) / npn(in);
                    break;
                case "^":
                    result = Math.pow(npn(in), npn(in));
                    break;

            }

            return result;
        }
    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            int caseCount = in.nextInt();

            for (int caseX = 1; caseX <= caseCount; caseX++) {
                in.nextLine();
                System.out.println("Case #" + caseX + ": " + npn(in));
            }

        }

    }
}
