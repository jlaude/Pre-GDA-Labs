package week07.balancedBraces;

import java.util.ArrayList;
import java.util.Scanner;
 
 
public class Solution {
 
   /**
    * Instructions:
    *
    * Read lines from System.in until there are no more lines.
    *
    * For each line read, output "valid" or "invalid"
    *
    * Each line consists of arbitrary characters. You can ignore all characters that are not braces.
    *
    *  Braces include:
    *  "(", which is closed by ")"
    *  "[", which is closed by "]"
    *  "{", which is closed by "}"
    *  "<", which is closed by ">"
    *
    * Output valid if the braces on that line are correctly nested,
    * so that each open brace is closed by its corresponding closing brace,
    * and braces are nested "( ( () ) )", not interleaved: "( [ ) ]"
    *
    * For each line, output "valid" if every open symbol in the set "( [ { <"
    * it has a matching corresponding closing symbol ") ] } >", and they are not interleaved;
    * else output "invalid".
    *
    * i.e,
    * "()[]"" is valid,
    * "([])"" is valid,
    * "(cite[24]) is valid,
    *
    * but "([)]" and
    * "(" are invalid.
    *
    * You can implement this using a stack.
    * One possible implementation uses a StringStack; another uses a Stack<Integer>.
    *
    * Copy your StringStack implementation (or Stack<T> implementation)
    * from assignment 1 to here, and use it.
    *
    * One way to solve this is to write a function:
    *     public static boolean isValid(String line, String opens, String closes)
    * which takes a line of the input, and returns whether that line is balanced.
    *
    * Note that this method also takes two additional Strings, a list of open braces and a list of closed braces.
    *
    * It's helpful to be able to turn a String variable "line" into an array of char, which you can do with
    *
    *      line.toCharArray()
    */

   interface Stack<T> {
       /**
        * After calling push, t is the top element of this Stack.
        */
       void push(T t);

       /**
        * peek returns the top element of this Stack, leaving the Stack unchanged,
        * or if the Stack is empty throws a StackUnderflowException.
        */
       T peek();

       /**
        * pop remove the top element of this Stack, and returns that element,
        * or if the Stack is empty throws a StackUnderflowException.
        */
       T pop();

       /**
        *
        * @return true iff (if and only if) this Stack is empty, else false.
        */
       boolean isEmpty();

       /**
        * return the size of this Stack.
        */
       int size();
   }

    /**
     * This interface just fixes the generic type T as String
     * Do not modify it.
     */
    interface CharStack extends Stack<Character> {
        // no body is necessary, as this interface inherits all members of the Stack super-interface
        // but to make it easier to read, we've copied the method names, and added the
        // @Override annotation to show they override the super-interface methods.
        // See the Stack super-interface, above, for the documentation of what each method does.

        @Override
        void push(Character s);

        @Override
        Character peek();

        @Override
        Character pop();

        @Override
        int size();
    }

    /**
     * Modify this StringStackImpl class, or write your own.
     */
    public static class CharStackImpl implements CharStack {

        ArrayList<Character> stack;
        /**
         * Constructor: initilalizes a new StringStackImpl instance.
         */

        public CharStackImpl() {
            this.stack = new ArrayList<Character>();
        }
        @Override
        public void push(Character c) {
            stack.add(0,c);
        }

        @Override
        public Character peek() {
            return stack.get(0);
        }

        @Override
        public Character pop() {
            Character popped = stack.get(0);
            stack.remove(0);
            return popped;
        }

        @Override
        public int size() {
            return stack.size();
        }

        @Override
        public boolean isEmpty() {
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
  
   /**
    * Exercise your Stack
    * Read lines from System.in
    * For each line, output "valid" for every open symbol in the set "( [ { <"
    * it has a matching closing symbol ") ] } >", and they are not interleaved,
    * else output "invalid".
    *
    * i.e, "()[]"" is valid, "([])"" is valid, "(cite[24]) is valid,
    * but "([)]" and "(" are invalid
    *
    */
   public static void main(String[] args) {
 
       try (Scanner in = new Scanner(System.in)) {

           while (in.hasNextLine()) {
               String line = in.nextLine();
               // calling isValid method to check if the input line is a 'valid' balanced brace set
               if(isValid(line,"({[<",")}]>")) {
                   System.out.println("valid");
               } else {
                   System.out.println("invalid");
               }

           }
       }
   }
 
   public static boolean isValid(String line, String opens, String closes) {

       // convert input String into character array to be able to iterate through the characters
       char[] lineAsCharArray = line.toCharArray();

       // instantiate a stack
       CharStackImpl stack = new CharStackImpl();

       // loop through all the characters in the input line
       for (char bracket: lineAsCharArray) {
           //checking if character in the line is an open bracket
           if (opens.indexOf(bracket) != -1 &&
                   // adding to the stack open brackets
                   // check if the stack is empty or if the top of the stack is an open bracket
                   (stack.isEmpty() || (opens.indexOf(stack.peek()) != 0)))
           {
               stack.push(bracket);
           } else if (!stack.isEmpty() && closes.indexOf(bracket) != -1 && (closes.indexOf(bracket) == opens.indexOf(stack.peek()))) {
               // check that the stack isn't empty, check if it's a close bracket and matches the open bracket on top of the stack, pop off the open bracket
               stack.pop();

           } else if (opens.indexOf(bracket) != -1 || closes.indexOf(bracket) != -1 ) {
               // if it's not a new open bracket, if it's not closing brace, but it's still a bracket push it to the stack
               stack.push(bracket);
           }
       }

       // if stack is empty, the input line is a valid, balanced brace set
       if (stack.isEmpty()) {return true;}
       else { return false; }
   }
}
