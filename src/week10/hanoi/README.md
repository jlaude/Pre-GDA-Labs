#Tower of Hanoi
Tower of Hanoi (visualization) is a puzzle, which involves moving discs between three rods according to the specific rules.

Before the game starts, the first rod contains N discs of different sizes, and smaller discs are always on top of the bigger discs (meaning that the biggest disc is in the bottom of the rod, and the smallest disc on the top of the rod). The goal is to move all discs to the third rod, preserving the disc order. The only allowed operation is to take the top disc from one rod and move it to the top of another rod. Putting a disc on top of a bigger disc is not allowed.

This problem has a recursive solution. Implement it by writing a recursive function void hanoi(int m, int source, int target, int spare), which outputs the actions required to move m disks from the source rod to the target rod, using the spare rod.

Note: there are multiple algorithms that can solve this problem. The offered recursive algorithm offers the optimal solution: there are no other algorithms that can solve the problems by performing less moves. Our test files assume this algorithm, so other algorithms that produce different valid outputs won't be accepted by the checker or by CodeJam.

## Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is an integer N: the number of discs on the first rod.

## Output
For each test case, output a line containing Case #x:, where x is the test case number (starting from 1). Then output one line per operation: y z, where y is the rod from which the top disc should be taken (1, 2, or 3), and z is the rod where the disc should be put (1, 2, or 3; can't be the same rod).
