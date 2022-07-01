package gdaAssessment.task2;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {


    public static ArrayList<String> interleave(String strA, String strB) {

        ArrayList<String> interleavedResultArray = new ArrayList<>();

        // recursion stop condition when it's moved strB all the way through strA and vice versa
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
            String resultString = iter.next();
            //if (!(strB.charAt(0) == iter.next().charAt(0))) {
            //System.out.println("strAIterator: " + strAIterator);
            //System.out.println("StrA: " + strA);
            //if (!strA.isEmpty()) { System.out.println(strA.substring(strAIterator,strAIterator+1));}
            //System.out.println("strA.substring(0, strAIterator): " + strA.substring(0, strAIterator));
            //if ((!strA.substring(0,strAIterator).isEmpty())) {
            //    System.out.println("strA.charAt(strAIterator - 1) "+ strA.charAt(strAIterator - 1));
            //}

            //System.out.println("strB.charAt(0): " + strB.charAt(0));
            //System.out.println("resultString: " + resultString);

            // Checking that the two adjacent variables aren't the same
            boolean testVar = true;

            if((!strA.substring(0,strAIterator).isEmpty())) {
                if (strA.charAt(strAIterator - 1) == strB.charAt(0)) {
                    testVar = false;
                }
            }

            if (!resultString.isEmpty()) {
                if(strB.charAt(0) == resultString.charAt(0)) {
                    testVar = false;
                }
            }

            if (testVar) {
                resultArray.add(strA.substring(0, strAIterator) + strB.charAt(0) + resultString);

            }
        }

        iterateThroughStringA(resultArray, strAIterator +1, strA, strB);

    }

    public static void main(String[] args) {

        String strA = "cab";
        String strB = "abc";
        System.out.println(interleave(strA,strB));

    }

}
