# Mirror Trees
For this activity, you will work with a Binary Search Tree. Your task will be to populate the BST with the integers that are provided as input, then to contruct the mirror image of that tree, and finally output the "pre-order" traversal of the original tree, followed, on the next line, by the pre-order traversal of the mirror, by outputting node values separated by spaces. (Note that debugging will be much easier if you output breadth first!)

The mirror of any tree is simply the Tree rotated around its root:

        4             mirror           4
     2     6                        6      2
    1 3   5 7                      7 5    3 1
  
Pre-order traversal outputs a node's value, then its left subtree (if any), then its right subtree (if any).
So for this example, you would output these two lines:
    4 2 1 3 6 5 7
    4 6 7 5 2 3 1
## Input
The first line of the input contains T: the number of integers to be inserted in the tree. Actual values, to be inserted, follow.

## Output
Output one line containing the space-separated values of the nodes in pre-order traversal of the original tree, followed by a second line of space-separated values of the nodes in pre-order traversal of the mirrored tree.
