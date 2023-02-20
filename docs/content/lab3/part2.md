# Lab 3 -- MyArrayList

* [Lab 3 Home](index.html)
* [Warmup](warmup.html)
* [Part 2](part1.html)
* Part 2
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 2 -- Testing with JUnit

Now you will build JUnit tests for the methods you just wrote.  First, create
a set of JUnit tests for your class, like you did in the warmup.  Then,
implement the following tests.

`void testSize()`
: To test that your size method is working correctly,
  replace the `fail(...)` method call with the following code:
  ```java
  MyArrayList<Integer> test = new MyArrayList<Integer>(); 
  assertEquals( "Size after construction", test.size(), 0);
  test.add(0,5);
  assertEquals( "Size after add", test.size(), 1);
  ```

`void testAddE()`
: Tests your constructor, the single-parameter `add()` method (which, hopefully
  calls the two-parameter `add()` method), and the `get()` method. Under the covers, it
  will also test your private `resize()` method. This also tests adds to the end of
  the list and adds when the list is at capacity.

  Create a `MyArrayList` of `Integers`, and then insert the numbers 0 through 20
  using the `add(element)` method.  Then loop through the list using the `get()`
  method to access each element of the list, and assert that the *i*th element is
  equal to *i*.

`void testAddIntEFront()`
: Tests adds to the beginning of the list.  

  Create a `MyArrayList` of `Integers`, and insert the numbers 0 through 20, but
  insert each one at the front of the list using `add(index, element)`.  Iterate
  through your list and use the `get()` method to test that the *i*th element is equal
  to 20 - *i*.

`void testAddIntEMid()` 
: Tests adds to the middle of the list.

  Again create a `MyArrayList` of `Integers` and insert the numbers 0 through
  20, but this time insert each number at the midpoint `size() / 2` of the list.
  This should result in the ordering 1, 3, 5, 7, 9, 10, 8, 6, 4, 2, 0.  Use the
  `get()` method to test that your inserts are ordered appropriately.

`void testAddOutOfBounds()` and `void testGetOutOfBounds()`
: Write methods to test the `IndexOutOfBoundsException`s on both borders (index
  `-1` and index `size()` or `size() + 1`, depending on the method) for the parameterized
  `add()` method and the `get()` method.
{: .implement-box}

As you implement the rest of your `MyArrayList` methods, please write the
accompanying JUnit test, and add to any previous ones.

[&laquo; Previous](part1.html)   [Next &raquo;](part3.html)