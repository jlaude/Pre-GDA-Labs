package week07.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
 
public class Solution {
 
   /**
    * Instructions:
    * 
    * A Stack is a last-in, first-out ("LIFO") collection. This means that the element that we
    * "pop" off the Stack is always the last element we "push"ed into the Stack. As we add
    * more elements, existing elements are "psuhed down" the Stack.
    *
    * Example
    *   StringStack s = new StringStack();  // internally, the stack looks like this, with the "top" of the stack to the left: []
    *   s.push("a")                         // stack: ["a"]             "a" is the top and only stack eleemnt
    *   s.push("b")                         // stack: ["b", "a"]        "b" is now the top element
    *   s.push("a")                         // stack: ["c", "b", "a"]   "c" is now the top element
    *   String popped = s.pop()             // stack: ["b", "a"], popped = "c"
    *   String peeked = s.peek()            // stack: ["b", "a"], peeked = "b"
    *
    * Implement the class StringStack class (using one of the two options explained below).
    *
    * YOU HAVE TWO OPTIONS for implementing StringStack:
    * Option 1 (easier): Just implement the StringStackImpl class on line 121, 
    * by writing the four methods it implements.
    * These four methods are listed in the interface: push, peek, pop, size.
    *
    * Option 2 (slightly more difficult, requires some knowledge of Java Generics):
    * If you're comfortable with Java Generics, implement the StackImpl class,
    * then (trivially) implement StringStackImpl as a subclass of StackImpl.
    *
    *    
    * Now, implement the static main method, and exercise your Stack:
    *
    * Create a StringStackImpl object, which we'll refer to below as "the stack".
    * Then read strings from System.in, as long as System.in has Strings to read.
    *
    * For each string read,
    * if the string read is "peek" (case insensitive), so "Peek", "pEEk", etc. also qualify,
    * print out the top element of the stack followed by a newline.
    * Or, if it's "pop" (case insensitive), pop the stack and print the popped element.
    * Or, if it's "size", print out the Stack's size, followed by a newline.
    * Or, if a Stack Underflow occurs -- or would occur --, print "SU", followed by a newline.
    * Or, if it's anything else, push the string read onto the stack, and print out the stack size, followed by a newline.
    *
    */
 
   /**
    * This is an Exception class.
    * Throw this exception if a method that is supposed to return
    * a stack element can not return anything because the Stack is empty.
    *
    * You can can throw an instance of this exception by writing this:
    *       throw new StackUnderflow();
    * which creates a StackUnderflow object with the "new" keyword,
    * and throws that StackUnderflow object with the "throw" keyword.
    */
   public static class StackUnderflowException extends RuntimeException {
       // no body is required
   }
 
   /** 
    * This is the Stack interface.
    * Do not modify it.
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
   interface StringStack extends Stack<String> {
       // no body is necessary, as this interface inherits all members of the Stack super-interface
       // but to make it easier to read, we've copied the method names, and added the
       // @Override annotation to show they override the super-interface methods.
       // See the Stack super-interface, above, for the documentation of what each method does.
 
       @Override
       void push(String s);
 
       @Override
       String peek();
 
       @Override
       String pop();
 
       @Override
       int size();
   }
 
   /**
    * Modify this StringStackImpl class, or write your own.
    */
   public static class StringStackImpl implements StringStack {

        ArrayList<String> stack;
        /**
         * Constructor: initilalizes a new StringStackImpl instance.
         */

        public StringStackImpl() {
            this.stack = new ArrayList<String>();
        }
        @Override
        public void push(String s) {
            stack.add(0,s);
        }

        @Override
        public String peek() {
            return stack.get(0);
        }

        @Override
        public String pop() {
            String popped = stack.get(0);
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
    * Exercise your Stack:
    * Create a StringStackImpl object, which we'll refer to below as "the stack".
    * Then read strings from System.in, as long as System.in has Strings to read.
    *
    * For each string read,
    * if the string read is "peek" (case insensitive), so "Peek", "pEEk", etc. also qualify,
    * print out the top element of the stack followed by a newline.
    * Or, if it's "pop" (case insensitive), pop the stack and print the popped element.
    * Or, if it's "size", print out the Stack's size, followed by a newline.
    * Or, if a Stack Underflow occurs -- or would occur --, print "SU", followed by a newline.
    * Or, if it's anything else, push the string read onto the stack, and print out the stack size, followed by a newline.
    */
   public static void main(String[] args) {
       try (Scanner in = new Scanner(System.in)) {
           StringStackImpl stack = new StringStackImpl();
           while (in.hasNextLine()) {
                String line = in.nextLine();
                line = line.toLowerCase().trim();
                if ( line.equals("peek")){
                    // If the input is "peek", examine the first item in the stack
                    System.out.println(stack.peek());
                } else if (line.equals("pop")) {
                    // If the input is Pop, remove the first item in the stack and print it
                    // check that the stack isn't empty before popping off
                    if (stack.size() == 0 ) {
                        System.out.println("SU");
                    } else {
                        System.out.println(stack.pop());
                    }
                } else if (line == "size"){
                    // if input is "size" print the current size of the stack
                    System.out.println(stack.size());
                } else {
                    // if a new string is added, push to the stack
                    stack.push(line);
                    System.out.println(stack.size());
                }
            }
       }
   }
}

