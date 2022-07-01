package gdaAssessment.task2;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {


    public static ArrayList<String> interleave(String strA, String strB) {

        ArrayList<String> interleavedResultArray = new ArrayList<>();

        // recursion stop condition when it's moved strB all the way through string A and vice versa
        if (strB.isEmpty()) {
            interleavedResultArray.add(strA);
        } else if (strA.isEmpty()) {
            interleavedResultArray.add(strB);
        } else {
            iterateThroughStringA(interleavedResultArray, 0, strA, strB);
        }

        return interleavedResultArray;

    }

    public static void iterateThroughStringA (ArrayList<String> resultArray, int strAIterator, String strA, String strB) {

        if (strAIterator > strA.length()) {
            return;
        }

        for (Iterator<String> iter = interleave(strA.substring(strAIterator), strB.substring(1)).iterator(); iter.hasNext();) {
            //if (! (strA.charAt(strA.length() -1) == strB.charAt(0) || strB.charAt(0) == iter.next().charAt(0))) {
                resultArray.add(strA.substring(0, strAIterator) + strB.charAt(0) + iter.next());
            //}
        }

        iterateThroughStringA(resultArray, strAIterator +1, strA, strB);

    }

    public static void main(String[] args) {

        String strA = "123";
        String strB = "abc";
        System.out.println(interleave(strA,strB));

    }

}
