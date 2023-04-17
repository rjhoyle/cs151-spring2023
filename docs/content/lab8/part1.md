# Lab 8 -- Priority queues

* [Lab 8 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Submission](submission.html)


## Part 1 -- MyPriorityQueue

Write a heap-based implementation of a `PriorityQueue`, extending
`AbstractQueue` called `MyPriorityQueue`. It should contain an `ArrayList` to
hold the data items in the priority queue and a
[`Comparator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html)
to compare the priorities of the elements in the queue. `MyPriorityQueue` must
contain a constructor that takes a Comparator as input.

Remember that this is supposed to be a min-heap, so the smallest value is at
the top.

Don't forget to test each method you write, ideally as you write it with JUnit
tests before moving on to the next part.

You will need the following public and private methods.

`public int size()`
: Return the number of items in the priority queue.

`public void clear()`
: Efficiently empty your heap such that garbage collection can take place. Feel
  free to use the ArrayList clear method.

`public T peek()`
: Return the highest priority (smallest value) item in the priority queue,
  without removing it.

`public T poll()`
: Remove and return the highest priority (smallest value) item in the priority
  queue.  In order to maintain the heap property, you will want to take the last
  item in your ArrayList and make it the first item, and then call your private
  percolateDown() method on the root.  (Remember to delete the last item that
  you moved to the front!)

`public boolean offer(T item)`
: Add item in the correct place in the priority queue and return true if the
  item was correctly added---similar to `ArrayList` this should always return
  `true`.

  You will need to add the new item to the end of the `ArrayList`, and then call `percolateUp()` to move it to its correct location.

`public Iterator<T> iterator()`
: Return a new `Iterator` over the items in the priority queue.

  This `Iterator` can return the items in any order, including the order they are in the `ArrayList`.  (Hint:  `ArrayList` has a method that will return an `Iterator`.  Feel free to use that.)

`private void percolateUp(int hole)`
: Percolate the item at position hole up through the heap by checking if it
  it’s smaller than its parent, and swapping and recursing if it is.

`private void percolateDown(int hole)`
: Percolate the item at position hole down through the heap by checking if
  it’s bigger than its biggest child, and swapping the child and recursing if it
  is.  Be careful to handle the case of single children

`private int parent(int x)`
: Return the index of the parent of the node at index `x`.  This should be `(x - 1)/2`.

`private int leftChild(int x)`
: Return the index of the left child of the node at index `x`. This should be `2*x + 1`.

`private int rightChild(int x)`
: Return the index of the right child of the node at index `x`.  This should be `2*x + 2`.
{: .implement-box}

### JUnit Tests

Don't forget to write JUnit tests as you go along, to test your priority
queue. You should write tests for `peek()`, `poll()` and `offer()`, and you might want to
test `percolateUp()` and `percolateDown()` as well.  Note that in order to test, you
will need a `Comparator`---Java can provide you with its built in "natural
ordering" `Comparator`.  To create this `Comparator` for strings, you would write
the following code.
```java
Comparator<String> cmp = Comparator.naturalOrder();
```

[&laquo; Previous](index.html)   [Next &raquo;](part2.html)