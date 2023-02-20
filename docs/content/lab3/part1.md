# Lab 3 -- MyArrayList

* [Lab 3 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 -- MyArrayList Basics

You'll be constructing your very own implementation of the array list data
structure so that you understand its inner workings. You should use the prefix
`My` in your class names so that you don't accidentally use the standard
`ArrayList` in your testing. However, you will be matching its behaviour, so
when in doubt, you can refer back to the [`ArrayList`
documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
for clarification and/or use an `ArrayList` as a working reference solution.

Your `MyArrayList` class will implement the Java
[`List`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)
interface. That is, you will need to provide implementation for all of the
(abstract) methods contained therein. There are more than 20 such methods,
however, and that could take you a while to get through. Moreover, some of the
methods are "redundant" in the sense that they can be implemented using the
other methods (for example, you can implement `isEmpty()` by returning
`size() == 0)`. Fortunately, Java provides a lovely abstract class
`AbstractList` that provides some very basic and default behavior for a
`List`. Some of the methods still aren't implemented (that is, they are
abstract) and some of them may have inefficient implementation (that is,
you'll want to override them), but it's useful nonetheless. Thus your
`MyArrayList` class should extend `AbstractList` in order to reap the
benefits. Because `AbstractList` implements the `List` interface,
`MyArrayList` will as well.

You'll be using generics for your implementation, and taking advantage of the
fact that `List` and `AbstractList` are similarly parameterized. 

Create a new Java project called `Lab 3`. Create a new class called
`MyArrayList<E>` with package `lab3` and superclass
`java.util.AbstractList<E>`. `AbstractList<E>` gives you all methods except
for `get(int index)` and `size()`; however, you'll need to override many other
methods to get your `MyArrayList<E>` in fighting form.

### Basic Design
As you might expect from the name, the backing storage for an array list is
an array. That is, an array list is really just an array with the extra
functionality of dynamic resizing. The `MyArrayList`'s array will not always
be full because an array list may change its size when the underlying array
does not; therefore, your class will need to keep track of the number of items
that are currently in the underlying array. This size is not the same as the
`length` member of the underlying array. You need to keep the data in the
array packed to the front so there are no gaps.

### Private instance variables
Add the following members to your MyArrayList class.

`private int size`
: number of items currently stored in the list (which may differ from the list's current capacity)

`private E[] data`
: backing storage for MyArrayList
{: .implement-box}

### Constructors
Implement the following constructors in your MyArrayList class.

`MyArrayList(int startSize)`
: `startSize` is the initial guess as to the number of items in the list. You
  should just round this up to the nearest power of 2 and use that as the
  initial max capacity. (You can just start with the value of 2 and keep
  doubling that until it is no smaller than the requested size.)

  We can create our array with the following line.
  ```java
  E[] someArray=(E [])new Object[numElements];
  ```
  You will get a compiler warning about assigning an untyped array to a
  generic type. This is normal behavior, as this could lead to errors if it
  was done accidentally. Remember, one of the jobs of the compilers is to
  highlight risky behavior!  In our case, though, we know that the cast is
  safe, but since Java does not integrate regular arrays well with Generics,
  the warning is shown.  

  Good programming practice has us either have code without warnings or to
  handle warnings that we know are ok without alarming the user.  We can solve
  this issue by using casting and a special marker in the source code to
  suppress the warning.  Type:
  ```java
  @SuppressWarnings("unchecked")
  ```
  between your JavaDoc comments and the method header, so outside the function
  itself. This will get rid of the error message in Eclipse.

`MyArrayList()`
: Use an initial capacity of 2. NOTE: you should not be duplicating code from
  your other constructor in this one. Have this constructor call the other with
  appropriate arguments.  You can do this by executing the line `this(2);`
  in your new constructor.  This will call your base constructor with the
  argument ‘2’.
{: .implement-box}


### Private Methods
You will need to implement a private `resize()` method that doubles the size
of the array (do not just increase its length by one) by creating a new array
of twice the current size, copying the data over, then resetting the data
pointer to point to the new array.

`private void resize()`
: 1. Create a new array that is twice the size of the previous (use `data.length`).
  2. Copy all of the old data into the new array
  3. Set this.data to be your new array
{: .implement-box}

Feel free to write more private methods as you see fit.

### Public Methods (part 1. More to follow.)
Implement the following methods in your `MyArrayList` class.

`int size()`
: Return the number of items stored in the array, not the maximum capacity (i.e,
  not the size of the data array that you get from data.length)

`void add(int index, E element)`
: Adds the element at the specified index, shifting everything else right one
  space. You are allowed to add at any index location up to and including the
  current size (`index==size` is the first unused location). Resize the array if
  necessary. Throw an `IndexOutOfBoundsException` if the `index` is not within the
  allowed range. Remember, an `Exception` is just an object, so you create it just
  like you do a regular object. For example, you may try the following:
  ```java
  throw new IndexOutOfBoundsException();
  ```
  or even better:
  ```java
  throw new IndexOutOfBoundsException("Index Out of Bounds! You tried to get " +
      index + " but the size is " + size );
  ```
  Or something to that effect.

`boolean add(E element)`
: Adds an item to the end of the array. (Hint: you can call the previous
  method---don't just copy the code from there.) This method returns true if the
  item was added. Since you will always be adding the item specified, you should
  always return true.

`E get(int index)`
: Return the value stored at the given `index`.
  Throw an `IndexOutOfBoundsException` if the `index` is not within the allowed
  range. Note that this range is smaller than the range allowed for `add()`.
{: .implement-box}
  
Don't forget to be adding in your JavaDoc style comments as you go along.

### Good programming style suggestions
In your `resize()` method, I'd suggest printing yourself a message when it is
called at first indicating what size it is and what size it becomes. Just be
sure to remove it after doing some testing.

Also, take advantage of your existing methods and don't duplicate logic.
You've got two constructors and two `add()` methods. Only one of each needs to
do the real work, the second should just figure out a way to call the first.

You should include a meaningful message when you construct the
`IndexOutOfBoundsException`. (For example, when Java's `ArrayList` throws an
`IndexOutOfBoundsException`, it tells you which index was accessed and the size
of the `ArrayList`. This seems like good information.)

[&laquo; Previous](warmup.html)   [Next &raquo;](part2.html)