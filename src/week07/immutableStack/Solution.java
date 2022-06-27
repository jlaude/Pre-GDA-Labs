package week07.immutableStack;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
 
public class Solution {
 
   /**
    * Instructions: This assignment is OPTIONAL.
    * It introduces an immutable Stack class, which works like the Stack you implemented
    * in the first assignment, but in a way that the Stack itself never changes
    * (instead, we refer to different versions of it).
    *
    * Because functional programming is a different paradigm than Object Oriented,
    * to complete this assignment, you'll learn to think about programming differently.
    * But you'll also use Object Oriented techniques -- specially subclassing --
    * to implement a functional Stack.
    
 
    *  Immutable means we'll design our stacks to be unchanging.
    *  Since the stacks can't change, the modifying operations
    *  push and pop must return NEW stacks (except perhaps in one special case)
    *  Immutable objects are inherently thread-safe, because one thread can't
    *  change them without other threads seeing the change, because **nothing** can change them.

    *  To hint at this, we'll change the method name "peek" to "top".
    *  We'll also have top return an Optional<T>.
    *  You'll need to read the Optional class documentation.
    */
 
   interface ImmutableStack<T> {
       /**
        * After calling push, t is the top element of this Stack.
        * Returns the modified stack.
        */
       ImmutableStack<T> push(T t);
 
       /**
        * top returns the top element of this Stack, leaving the Stack unchanged,
        * or if the Stack is empty it should do what... ???
        */
       Optional<T> top();
      
       /**
        * pop removes the top element of this Stack, and returns that element,
        * or if the Stack is empty it should do what... ???
        */
       ImmutableStack<T> pop();
 
       /**
        *
        * @return true iff (if and only if) this Stack is empty, else false.
        */
       boolean isEmpty();
 
       /**
        * return the size of this Stack.
        */
       int size();  // there's a fast way to implement this, and a frugal way. You decide!
   }
 
   // Hint: are empty stacks fundamentally different than non-empty stacks?
   // If so, what's a way to have different behaviors for the same interface?
 
   public static class NonEmptyStack<String> implements ImmutableStack<String> {

       private final String head;
       private final ImmutableStack<String> tail;
       int stackSize;

       public NonEmptyStack(String head, ImmutableStack<String> tail, int stackSize) {
           this.head = head;
           this.tail = tail;
           this.stackSize = ++stackSize;
       }


       @Override
       public NonEmptyStack<String> push(String t) {
           return new NonEmptyStack<String>(t, this, this.stackSize);
       }

       @Override
       public Optional<String> top() {
           return Optional.of(head);
       }

       @Override
       public ImmutableStack<String> pop() {
           System.out.println(head);
           return this.tail;
       }

       @Override
       public boolean isEmpty() {
           return false;
       }

       @Override
       public int size() {
           return stackSize;
       }
       // TODO
   }
 
   public static class EmptyStack<String> implements ImmutableStack<String> {

       String head;
       String tail;
       int stackSize;

       EmptyStack(){
           this.head = null;
           this.tail = null;
           this.stackSize = 0;
       }

       @Override
       public Optional<String> top() {
           return Optional.empty();
       }

       @Override
       public int size() {
           return 0;
       }

       @Override
       public ImmutableStack<String> pop() {
           return null;
       }

       @Override
       public ImmutableStack<String> push(String t) {
           return new NonEmptyStack<String>(t, this, this.stackSize);
       }

       @Override
       public boolean isEmpty() {
           return true;
       }
   }
 
 
   /**
    * Exercise your Stack:
    * Create an ImmutableStack<String> object, which we'll refer to below as "the stack".
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
           ImmutableStack<String> stack = new EmptyStack<>();
           while (in.hasNext()) {
               String line = in.nextLine();
               line = line.toLowerCase().trim();
               if ( line.equals("peek")){
                   // If the input is "peek", examine the first item in the stack
                   System.out.println(stack.top().get());
               } else if (line.equals("pop")) {
                   // If the input is Pop, remove the first item in the stack and print it
                   // check that the stack isn't empty before popping off
                   if (stack.size() == 0 ) {
                       System.out.println("SU");
                   } else {
                       stack = stack.pop();
                   }
               } else if (line == "size"){
                   // if input is "size" print the current size of the stack
                   System.out.println(stack.size());
               } else {
                   // if a new string is added, push to the stack
                   stack = stack.push(line);
                   System.out.println(stack.size());
               }

           }
       }
   }
}
 