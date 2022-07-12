package week09.twosum;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class Solution {

    public static AtomicBoolean twoSum(int sumTarget, String input) {

        HashMap<Integer, Integer> inputSet = new HashMap<>();

        String[] inputNums = input.split(",");

        // using a hash map to keep track of number of occurrences of each integer - if an integer occurs twice and those two integers add to the sum target, valid use case
        int key = 0;
        for (String s : inputNums) {

            int inputInt = Integer.parseInt(s);
            // Counting the number of occurrences of the integer. Key is storing the integer input, value is storing number of occurrences.
            if (inputSet.containsKey(inputInt)) {
                inputSet.put(inputInt, inputSet.get(inputInt) + 1);
            } else {
                inputSet.put(inputInt, 1);
            }
        }
        AtomicBoolean result = new AtomicBoolean(false);

        //Iterate through the hashmap to see if it contains two keys which sum to the sum target
        inputSet.forEach((k,v) -> {

            // check if the hashmap contains an int the difference between the sum target and the current key, ensure the difference isn't equal to the key for corner case (ex: sum value 2, key 1)
            if (inputSet.containsKey(sumTarget-k) && (sumTarget-k) !=k ) {

                result.set(true);
            }
            // if the input integer multiplied by 2 equals the sum target, ensure that it occurred twice in the input string
            else if (sumTarget - k == k && v > 1) {
                result.set(true);
            }
        });

        return  result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseCount = in.nextInt();
        for (int caseX = 1; caseX <= caseCount; caseX++) {
            in.nextLine();
            int sumTarget = in.nextInt();
            System.out.println("Case #" + caseX + ": " + twoSum(sumTarget, in.next()));
        }
    }
}
