package week07.rpn;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
 
public class Solution {
 
   /**
    * Instructions:
    *
    * Read lines from System.in until there are no more lines.
    *
    * Each line consists of a mathematical expression in Reverse Polish Notation.
    * Input consists of one or more lines of RPN.
    *
    * "RPN", "Reverse Polish Notation" or "postfix" form, is a mathematical expression
    * where operators ("+" addition, "-" subtraction, "*" multiplication, "/" division)
    * come after (postfix) the operands they work on.
    *
    * Examples:
    * 2 3 +               add 2 and 3, yielding 5
    * 2 3 + 4 *           add 2 and 3, yielding 5, then multiply it by 4, yielding 20
    * 2 1 -               subtract 1 from 2 (2 - 1) yielding 1
    * 1 2 -               subtract 2 from 1, yielding -1
    *
    * See: https://medium.com/@ainayat865/reverse-polish-notation-rpn-with-stack-4551a5f54ae0
    *
    *
    * For each line read, evaluate the expression, and print out its numeric value as a Double.
    *
    * Copy your Stack from assignment 1 or assignment 2. You may need to modify the Stack to contain Doubles.
    *
    * You'll use the stack to evaluate the expression, with the following algorithm:
    *      Create an empty Stack of Doubles.
    *
    *      When you read a number, push it onto the stack.
    *
    *      When you read an operator, pop two values off the stack, and then push onto the stack one value, the result of
    *          applying that operator to the two popped values. In detail:
    *          When you read the operator "+", pop x and then y off the stack, and then push the value (x + y)
    *          When you read the operator "-", pop x and then y off the stack, and then push the value (x - y)
    *          When you read the operator "*", pop x and then y off the stack, and then push the value (x * y)
    *          When you read the operator "/", pop x and then y off the stack, and then push the value (x / y)
    *
    *      When you've read the entire line, print out the value that's on the top of the Stack (or 0.0 if the Stack is empty).
    *
    * A detailed example of evaluating the line "2 3 + 4 *":
    *      Start with the empty stack:               stack: []
    *      Read "2", and push it onto the stack:     stack: [2]
    *      Read "3", and push it onto the stack:     stack: [3, 2]
    *      Read "+", pop 3 into x,                   stack: [2], x = stack.pop() = 3
    *                pop 2 into y,                   stack: [], x = 3, y = stack.pop() = 2
    *                push 3 + 2 = 5 onto the stack   stack: [5]
    *      Read "4", and push it onto the stack:     stack: [4, 5]
    *      Read "*", pop 4 into x,                   stack: [5], x = stack.pop() = 4
    *                pop 5 into y,                   stack: [], x = 3, y = stack.pop() = 5
    *                push 4 * 5 = 20 onto the stack  stack: [20]
    *      Nothing more to read, so output the top of the stack, 20.0
    *
    *
    * It's helpful to be able to read one line at a time, and then to read each token in the line.
    *
    * To do that, you can create one Scanner that reads System.in by line, and for each of those lines,
    * create a *second* Scanner that reads just that line, by using the Scanner constructor that takes a String:
    *
    * public static double rpn(String line) {
       // make a Stack here
       try (Scanner lin = new Scanner(line)) { ....
    *
    *
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
    interface DoubleStack extends Stack<Double> {
        // no body is necessary, as this interface inherits all members of the Stack super-interface
        // but to make it easier to read, we've copied the method names, and added the
        // @Override annotation to show they override the super-interface methods.
        // See the Stack super-interface, above, for the documentation of what each method does.

        @Override
        void push(Double s);

        @Override
        Double peek();

        @Override
        Double pop();

        @Override
        int size();
    }


    public static class DoubleStackImpl implements DoubleStack {

        ArrayList<Double> stack;

        /**
         * Constructor: initilalizes a new DoubleStackImpl instance.
         */
        public DoubleStackImpl() {
            this.stack = new ArrayList<Double>();
        }

        @Override
        public void push(Double d) {
            stack.add(0,d);
        }

        @Override
        public Double peek() {
            return stack.get(0);
        }

        @Override
        public Double pop() {
            Double popped = stack.get(0);
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
    * Read an expression in "Reverse Polish Notation" or postfix form,
    * where operators ("+" addition, "-" subtraction, "*" multiplication, "/" division)
    * come after (postfix) the operands they work on. Examples:
    * 2 3 +               add 2 and 3, yielding 5
    * 2 3 + 4 *           add 2 and 3, yielding 5, then multiply it by 4, yielding 20
    * 2 1 -               subtract 1 from 2 (2 - 1) yielding 1
    * 1 2 -               subtract 2 from 1, yielding -1
    *
    * See: https://medium.com/@ainayat865/reverse-polish-notation-rpn-with-stack-4551a5f54ae0
    */
   public static void main(String[] args) {
 
       try (Scanner in = new Scanner(System.in)) {
           while (in.hasNextLine()) {
               String line = in.nextLine();
               //System.out.println(rpn(in.nextLine()));

               double result = rpn(line);
               System.out.println(result);

           }
       }
   }
 
   public static double rpn(String line) {
       try (Scanner lin = new Scanner(line)) {
           DoubleStackImpl stack = new DoubleStackImpl();
           while (lin.hasNext()) {
               if (lin.hasNextInt()){
                   stack.push((double) lin.nextInt());
               } else if (lin.hasNext()) {
                   char operator = lin.next().charAt(0);
                   if (operator == '+') {
                       double y = stack.pop();
                       double x = stack.pop();
                       stack.push(x + y);
                   } else if (operator == '-') {
                       double y = stack.pop();
                       double x = stack.pop();
                       stack.push(x - y);
                   } else if (operator == '*') {
                       double y = stack.pop();
                       double x = stack.pop();
                       stack.push(x * y);
                   } else if (operator == '/') {
                       double y = stack.pop();
                       double x = stack.pop();
                       stack.push(x / y);
                   }
               }
           }
           return stack.pop();
       }
   }

}
