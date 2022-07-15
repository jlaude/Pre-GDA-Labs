# Fibonacci Numbers
Fibonacci number sequence is defined by a function F(n), which accepts an integer and returns an integer. The function is defined in the following way:

F(n) = 0, if n == 0;

F(n) = 1, if n == 1

F(n) = F(n-1) + F(n-2), otherwise.

Implement a recursive function private static int F(int n) which computes the n-th Fibonacci number using the function definition above.

## Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a single integer number N: the number to call the F function.

## Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting at 1), and y is the corresponding Fibonacci number.
