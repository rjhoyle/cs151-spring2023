# Lab 2 -- More Java Fun

* [Lab 2 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 -- Object Oriented Programming

In this part of the lab, we will explore how to use abstract classes in code
as a way to create modularization.  One of the great advantages of abstract
classes is that we can pass them around as if they were instances of that
abstract class, as long as we only use methods that are defined there.  In
this part, we will create two collections, treating them as black boxes that
only have the methods defined in the abstract class specification, then time
how long certain operations take to compare them.

There is some starter code [here](Lab2.zip) that you need to use that will
frame the assignment.  Your task is to fill in the items that have been marked
for you to do. In this part, you're going to be working with
`CollectionsTest.java`. The other files are for [Part 2](part2.html).

We will start with the bottom of `CollectionsTest.java` first: the `main()`
method.  This method has been filled out for you already, but you should
understand what it is doing.  We are defining a `Collection<Integer>`
variable, `c`, that will hold both an `ArrayList<Integer>` and a
`TreeSet<Integer>` object.

The `<Integer>` part of the variable declaration is an example of use of a
generic class.  We can create an `ArrayList` which holds objects of any given
type. In this case, it holds objects of type `Integer`.

We will be using `ArrayLists` and `TreeSets` for this assignment.  Their
implementation details are not important at the moment, but we will cover them
later in the semester.  For now, all you need to know is that they have
different internals which will lead to different performances for different
operations.  However, because they all implement the `Collection` interface,
they are guaranteed to have the methods that are defined by `Collection`. In
this case, the ones we will be using are `add()` and `contains()`.  Look at
the documentation for the [`Collection`
interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html)
for how to call the methods and what they return.  

```java
    public static void main(String[] args) {
        Collection<Integer> c;

        c = new ArrayList<Integer>();
        TestCollection(c);
        c = new TreeSet<Integer>();
        TestCollection(c);
    }
```

Next up, we will implement our first method for this assignment, the
`TestCollection()` method.  The method is defined in the sample code as
returning void and taking a `Collection<Integer>` parameter.

```java
    public static void TestCollection(Collection<Integer> c) {
        // TODO: Implement this method.

        // You must create an array of the appropriate size
        long[] tests = null;

        // Terminate by printing your results
    }
```

In this method, we want to call the `TimeAdd` and `TimeContains` methods, which
we will be implementing soon.  We want to call these methods multiple times,
which can be done with a for loop.  We will do this `NUM_TESTS` times.  

Note that the implementations of `TimeAdd` and `TimeContains` have not been
written, which is fine.  Our function will not do anything yet until we write
those  methods.

Store the values in the tests array.  You should then print out the average time
for the tests, the minimum time, and the maximum time for the tests.  Running
tests multiple times is a good habit to get into, as you never know what may
slow down a computer at a specific time.  It is good to run several and then
calculate an average and range.

Our final two methods are `TimeAdd` and `TimeContains`. These two methods will
look similar.  Start by storing the current time in milliseconds with
`java.lang.System.currentTimeMillis()`.  Then, for `TimeAdd`, call the `add()`
method on the collection to insert all numbers from 0 to 49,999.  For
`TimeContains`, we will query the `Collection` with the `contains()` method to
see if it contains all numbers from 0 to `MAX_SIZE - 1`.  These operations can
be done with for loops again.   The method will then get the time, and return
the difference between the start time and the end time.

When you finish, your class will contain 4 methods, 3 of which you implemented
and one that was implemented for you.

For this part of the assignment, you are combining the timing for adding and
searching.  If we were to separate the times, though, which class would be
better for adding, and which one is better for searching?  Or is there a class
that is superior on both tasks?

[&laquo; Previous](warmup.html)   [Next &raquo;](part2.html)