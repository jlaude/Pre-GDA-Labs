package week02.oddeven;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int result = number % 2;
        if (result == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

}
    
