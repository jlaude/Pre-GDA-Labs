import java.util.Arrays;

/** Starter code for the Anagrams problem. */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // The first number is the number of test cases.
    int numTests = in.nextInt();

    // Read in the next line, which is the comma-separated list of words to put in the anagram
    // grouper. Create an AnagramGrouper for this list of words.
    String[] words = in.next().split(",");
    AnagramGrouper anagrams = new AnagramGrouper(words);

    // For each test case, read in the word and print how many anagrams it has.
    for (int i = 1; i <= numTests; i++) {
      String word = in.next();
      System.out.printf("Case #%d: %d\n", i, anagrams.getNumberOfAnagrams(word));
    }

    in.close();
  }

  /**
   * Takes a list of words and groups them into anagram groups. An anagram group is a set in which
   * all words are anagrams of each other. For example, "tan, ant, nat" is an anagram group.
   */
  public static class AnagramGrouper {

    /** Constructs an AnagramGrouper from the given array of Strings. */
    public AnagramGrouper(String[] words) {
      // TODO: Create a map where the value is a set of words that are anagrams of each other, and
      // the key is the letters of those words alphabetized. Populate it with the given words.
    }

    /**
     * Given a string word, return the number of valid anagrams it has. An anagram is valid if it
     * appears in this AnagramGrouper.
     */
    public int getNumberOfAnagrams(String word) {
      // TODO: implement this function
      return -1;
    }

    /**
     * Creates a key for the given word. The key is a string consisting of the letters in the word
     * in alphabetical order.
     */
    private String createKey(String s) {
      char[] letters = s.toCharArray();
      Arrays.sort(letters);
      return new String(letters);
    }
  }
}
