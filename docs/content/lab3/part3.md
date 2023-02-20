# Lab 3 -- MyArrayList

* [Lab 3 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* [Part 2](part2.html)
* Part 3
* [Submission](submission.html)


## Part 3 -- Completing `MyArrayList`

Now spend some time finishing up your implementation of your `MyArrayList`
class. Don't forget to write (and run!) your tests as you go along.

### Public Methods
Implement the following methods in your `MyArrayList` class or its JUnit test
class as appropriate.

`E set(int index, E element)`
: Change the value at the specified index to element. Return the previous
  value. Throw an `IndexOutOfBoundsException` if the index is not within the
  allowed range. Note that this range is smaller than the range allowed for
  `add()`.

`void testSet()`
: Store the numbers 0 through 20 in the `MyArrayList` using `add()`, then use `get()`
  and `set()` to reverse the order of the elements.  Iterate through the list and
  confirm that element _i_ is equal to 20 - _i_.  Add additional code to test the
  `IndexOutofBoundsException`.

`E remove(int index)`
: Remove the item at the specified index, shifting all other elements to the
  left. Return the value that was removed. Throw an `IndexOutOfBoundsException`
  if the index is not within the allowed range. Note that this range is smaller
  than the range allowed for `add()`.

`void testRemove()`
: Insert the numbers 0 through 20, then remove every even-indexed entry,
  starting at 0 (so, entries 0, 2, 4,...) and add them into a second
  `MyArrayList`. Check that your second `MyArrayList` contains entries 0, 2, 4,
  …, 20 (in order) and your original `MyArrayList` contains 1, 3, 5, …, 19) (in
  order).

`boolean isEmpty()`
: Return `true` if there are no items stored, `false` otherwise.

`void testIsEmpty()`
: Test `isEmpty()` returns `true` if your array list has no
  items, and `false` otherwise.  Try testing before you add an element, after,
  and then after you remove the element.

`void clear()`
: Empty out the list. Be sure to allow garbage collection to take place by
  setting array entries to `null`.

`void testClear()`
: Insert multiple elements, then clear.  Make sure your size is 0 and you
  cannot get any elements.
{: .implement-box}

[&laquo; Previous](part2.html)   [Next &raquo;](submission.html)