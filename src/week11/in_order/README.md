# In-Order Traversal
For this activity, you will work with a Binary Search Tree. Your task will be to populate the BST with the integers that are provided as input and then to output the whole tree "in-order".

This means starting from the root node, and then for any node, first recursively outputting its left subtree (if any), then the node's own value, then recursively outputting its right subtree (if any). If the tree is a Binary Search Tree, this will output the values from smallest to largest, thus the name, "in-order".

Any missing children produce no output.

## Input
The first line of the input contains T: the number of integers to be inserted in the tree. Actual values follow.

## Output
Output one line containing all the values in the tree in the appropriate order.