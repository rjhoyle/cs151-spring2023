# Lab 6 Warmup

* [Lab 6 Home](index.html)
* Warmup
* [Part 1](part1.html)
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 -- Javadoc

One important component of a good program is its documentation.  One of the
downsides of documentation is that it is often separate from the source code
that it describes, leading to the possibility that they can become out of
sync, and therefore useless.

Java has a nice built-in way of dealing with this problem.  It allows the
incorporation of certain tags into source code, which will then become
processed by a separate program to create human-readable documentation.  By
combining the files used for the docs with those used for the code, it
reducdes the chance that they'll be out of sync.  

As we expect you to document your code with comments as part of being a
responsible programmer, you should start using these javadoc tags in your code
to practice.

The basic structure of a Javadoc block is the comment, except with extra
asterisks.

```java
/**
 * Set the array at index to element
 * @param index index into array
 * @param element element to insert
 * @return old value at index
 */
public AnyType set(int index, AnyType element) {
	AnyType oldVal;

	// Make sure my index is within bound
	if ( (index < 0) || (index > this.size)) {
		throw new IndexOutOfBoundsException("Index Out of Bounds! You tried to get " +
				index + " but the size is " + size);
	}

	// Save the old value
	oldVal = data[index];

	// Set array at index to element
	data[index] = element;

	// Return the old element
	return(oldVal);
}
```


To generate the documentation, in the Project menu in Eclipse, select
`Generate Javadoc`. Make sure that your project is selected, and then click
`Finish`.

Some useful tags to include in your documentation:
* `@author` -- The author of the program
* `@param` -- Parameters that are used for a function
* `@return` -- What a function returns
* `@throws` -- Exceptions that your function may throw
* `@see` -- Links to other documentation that your function might require.  You
  can include an HTML anchor tag (`<a>...</a>` or another `.java `file here.

Return to the code that you submitted for Lab 5, the Linked List, and add
Javadoc-style comments to it.  Generate the Javadoc output and see how you can
make it so someone else can use your code more easily.


## Part 2 -- Traversals

One of the traits that comes with a tree is that it does not have a
pre-determined logical ordering of the nodes, unless one is imposed from the
outside.  

For example, if we have the tree
```
          A 
        /   \
      B       C
```
we could state that the nodes, printed in order, should be ABC, BAC, CAB, BCA,
etc.  All would be valid, based on the sorting criteria that we choose.

It is convenient to describe some of these sorting criteria in a reproducible
way.  This is similar to how we would describe the traversal of the
list from Head to Tail, or from front to back.  For trees, we will consider
three traversals: *inorder*, *preorder*, and *postorder*.

For each of these traverals, there are essentially three operations:
* Visit the current node
* Traverse the left subtree
* Traverse the right subtree
  
Visiting the node means performing whatever operation we're trying to do with
each node. For example, if we are printing out the values stored in the nodes
of the tree, then when we visit a node, we print out its value.

The order of these operations will determine whether we are doing an
*inorder*, *preorder*, or *postorder* traversal.

For the following examples, we will use the following tree:

 ```
              A
          /       \
      B               C
    /   \           /   \
  D      E        F      G
```

### Preorder

The order of the operations for a preorder traversal is:
* Visit the current node
* Traverse the left subtree
* Traverse the right subtree

The resulting preorder traversal for this tree is ABDECFG.

### Inorder

The order of the operations for a preorder traversal is:
* Traverse the left subtree
* Visit the current node
* Traverse the right subtree

The resulting inorder traversal for this tree is DBEAFCG.


### Postorder

The order of the operations for a preorder traversal is:
* Traverse the left subtree
* Traverse the right subtree
* Visit the current node

The resulting postorder traversal for this tree is DEBFGCA.

**Calculate the tree traversals for the following tree:**

 ```
              A
          /       \
      B               C
    /   \           /   \
  D      E        F      G
 / \    / \      / \    / \ 
H  I   J   K    L   M  N   O
```

[&laquo; Previous](index.html)   [Next &raquo;](part1.html)