package week09.letters;

import java.util.*;

public class Solution {

    public static void mostCommonLetter(int caseNum, String input) {
        // using LinkedHashMap to preserve order of insertion
        LinkedHashMap<Character, Integer> charHashSet = new LinkedHashMap<>();
        for (char c: input.toCharArray()) {
            if (!charHashSet.containsKey(c)) {
                charHashSet.put(c,1);
            } else {
                charHashSet.put(c, charHashSet.get(c) + 1);
            }
        }

        Character mostCommonChar = null;
        // Creating iterator to iterator through hashmap checking for most common char

        for (Map.Entry<Character, Integer> new_Map : charHashSet.entrySet()) {
            // if most common char has already been set, check if current value is greater than most common char value
            if (mostCommonChar != null) {
                if (new_Map.getValue() > charHashSet.get(mostCommonChar)) {
                    mostCommonChar = new_Map.getKey();
                }
            }
            // If mostCommonChar var hasn't been set, set existing key as most common
            else {
                mostCommonChar = new_Map.getKey();
            }

        }

        System.out.println("Case #" + caseNum + ": " + mostCommonChar);

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseCount = in.nextInt();
        for (int caseX = 1; caseX <= caseCount; caseX++) {

            in.nextLine();
            mostCommonLetter(caseX, in.next());

        }


    }
}
