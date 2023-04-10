# Lab 7 -- Using AVL trees

* [Lab 7 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Submission](submission.html)


## Part 1 -- AVL Trees

First you'll be completing an implementation of `TreeMap` called `MyTreeMap`. Most
of the implementation is already provided for you, but there are a few things
you still need to finish. `MyTreeMap` is just an AVL tree in disguise, where the
nodes in the tree contain key–-value pairs. You place items in the tree,
ordered by their key, and this key has an associated value tagging along with
it. Now, the key can be any reference type, and so can the value. Therefore,
our `MyTreeMap` class will be parameterized by not one but two generic types: `K`
for the key, and `V` for the value.

The methods you have to implement are listed below. You should peruse the
class to see how it is implemented; it is not the same as the [binary tree lab
(Lab 6)](../lab6/). In particular, a `TreeMap` contains a (key, value) pair,
and a reference to its left and right subtrees (which are also `TreeMaps`). An
empty `TreeMap` is one for which its left and right subtrees are `null`; a
leaf `TreeMap` is one for which its left and right subtrees are non-null, but
are themselves empty `TreeMaps`. You can explore this further by looking at
the provided constructors.

Note that the generic type `K` of the key implements the `Comparable` interface,
and therefore, you can (and should!) use the `compareTo()` method to determine
whether two keys are equal or to determine their order.

`private V get(K searchKey)`
: Return the current mapping of the given key, that is, the value associated
  with the provided `searchKey`.

  If no mapping exists, return `null`.

  We have already included the actual public method `get(Object key)` which
  takes care of the casting. (The get(Object key) method is required for any
  `TreeMap` implementation.)

`public V put(K key, V value)`
: Insert a (`key`, `value`) mapping into the map, ordered by its key.

  If a mapping for this key already exists, the new value should replace the
  old value in the map.

  The return value of put is the previous value for the key if there was one,
  or null if there was not.

  Here is pseudo code for the method:
  1. If this `TreeMap` is empty, then
     add the (`key`, `value`) pair to the empty `TreeMap`, and then make it into a leaf and return it. In more detail, you should:
     1. Set the value of `key`
     2. Set the value of `value`
     3. Set the size of the tree to 1
     4. Set `this.height` to 0
     5. Set both `left` and `right` to be new empty `MyTreeMaps` (i.e., `new MyTreeMap<K,V>()`)
     6. This is a base case, so you are done and can return null (since there is no previous value).
     {: style="list-style-type: lower-alpha;"}

  2. If the key of this TreeMap is the key you are looking for, then update
     its value, and return the previous value.
  3. Otherwise,
     1. Call `put(k, v)` on the appropriate child.
     2. Save the value the child returns.
     3. Call `restructure(this)` if the tree is unbalanced.
     4. Call `this.setHeight()` to update the tree's height.    
     5. Recalculate your `size` by adding 1 to the sum of the `size` of your children.
     6. Return the saved value returned by the child.
     {: style="list-style-type: lower-alpha;"}

`private void restructure(MyTreeMap<K, V> node)`
: Rebalances the `MyTreeMap` rooted at `node`, if it is unbalanced.

  The actual rotation is already implemented; that is, once it knows which subtrees need to be rotated, it will do it.  

  What you need to do is tell it which subtrees need to be rotated, by setting
  variables `a`, `b`, `c`, `t1`, `t2`, `t3`, and `t4` to the appropriate
  `TreeMaps`. Once you've made these assignments, the provided code will
  return the tree with the final arrangement of
  ```
       b
     /   \
    a     c
   / \    / \
  t0 t1  t2 t3
  ```
  As indicated by the diagram, you will need to fill in the variables such
  that `a` < `b` < `c` and `t0` through `t3` are their child trees, from left to right.

  The first case is done for you (when the left child is the tallest, and its
  left child is the tallest); you need to implement the other three cases.

  The rest of the `restructure()` method is already implemented for you.

  Please refer to the [warmup](warmup.html) where you did practice rotations
  when figuring out how to assign the variables.
{: .implement-box}

### JUnit testing

For testing, you should create a class called `MyTreeMapTest` that thoroughly
tests the new methods that you implemented. Be sure to try examples that will
require calls to each of the various configurations of `restructure()`. I
strongly suggest drawing out your examples by hand rather than just making
them up in your head. Don't forget about to test the case where you overwrite
a value for an already-existing key.

Be thorough with your tests because you want this tree to be working before
you proceed!

[&laquo; Previous](index.html)   [Next &raquo;](part2.html)