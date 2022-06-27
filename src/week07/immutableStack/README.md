# Immutable Stack (week 7, OPTIONAL assignment)
Instructions: This assignment is OPTIONAL.

It introduces an immutable Stack class, which works like the Stack you implemented in the first assignment, but in a way that the Stack itself never changes (instead, we refer to different versions of it).

Because functional programming is a different paradigm than Object Oriented, to complete this assignment, you'll learn to think about programming differently. But you'll also use Object Oriented techniques -- specially subclassing -- to implement a functional Stack.

Immutable means we'll design our stacks to be unchanging. Since the stacks can't change, the modifying operations push and pop must return NEW stacks (except perhaps in one special case) Immutable objects are inherently thread-safe, because one thread can't change them without other threads seeing the change, because nothing can change them.

To hint at this, we'll change the method name "peek" to "top". We'll also have top return an Optional. You'll need to read the Optional class documentation.

From here, follow the prompts in Solution.java
