# Normal Polish Notation
"Normal Polish Notation", "Polish Notation", "NPN", "PN", or "prefix" form, is a mathematical expression where operators ("+" addition, "-" subtraction, "*" multiplication, "/" division, and "^" exponentiation) come before (prefix) the operands they work on.

An NPN expression is either:

A number. The expression result is equal to the number.
An operation ("+", "-", "*", "/", or "^"), followed by two other expressions. The result is equal to the result of applying the operation to the results of the first and the second expressions.
Examples:

2                    Number 2, yielding 2
+ 2 3                add "2" and "3", yielding 5
* + 2 3 4            multiply: "+ 2 3" (which is 5) and "4", yielding 20
- 2 1                subtract "2" and "1", yielding 1
- 1 2                subtract "1" and "2", yielding -1
NPN expressions can be evaluated using recursive function private static double npn(Scanner in), which does the following:

Read the next input token. If it is a number, return its value.
Otherwise, the token is an operation. Call npn(in) twice to evaluate the first and the second expression, then apply the operation to their results.
## Tip
Normal Polish Notation input format is very similar to the input format of Reverse Polish Notation, that was in assignment 3 of week 7. You can reuse the old code handling the input, and write new code to compute the result.

Exponentiation in Java can be done using the Math.pow() function: a ^ b equals to Math.pow(a, b).

## Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is an NPN expression that has to be evaluated.

## Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1), and y is the result of the corresponding expression. Output the result with 1 digit after the comma (using the .1f format specifier).
