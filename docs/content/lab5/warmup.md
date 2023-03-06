# Lab 5 Warmup

* [Lab 5 Home](index.html)
* Warmup
* [Part 1](part1.html)
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)



## Iteration

The act of iterating through a data structure in order to examine or operate
on each element is fundamental in computer science and shows up again and
again. You have done this many times already. For example, in Java, if you
have an `ArrayList<Integer>`, you can iterate through it and sum all of the
elements.
```java
ArrayList<Integer> list = new ArrayList<Integer>();
int sum = 0;
// Add some elements to the list.
for (int i = 0; i < list.size(); i++) {
    sum += list.get(i);
}
```

Although this approach works quite well with an `ArrayList`, it really breaks
down when we switch data structures to something like a `LinkedList`. In lab
5, you will be implementing your own `LinkedList` (a much more featureful
version than you did in lab 4 when you implemented a queue). The problem comes
from the `list.get(i)` method. Recall that a linked list stores a pointer to
the head of the list (and perhaps a pointer to the tail of the list). In order
to get to element at index `i`, the implementation of `get()` has to start at
the head of the list and walk through the linked list of nodes. This code
would look something like
```java
public E get(int index) {
    Node node = this.head;
    while (index > 0) {
        node = node.next;
        index--;
    }
    return node.data;
}
```
(This isn't the whole thing. We'd need to handle reaching the end of the list
before index hit 0 and throw an exception.)

In contrast, the `ArrayList.get()` method need only return the `i`th element
of its underlying array.
```java
public E get(int index) {
    return this.data[index];
}
```

We can see this problematic behavior in practice. Create a new Java project
named `Warmup 5`. Create a new class called `Iteration` with the package
`warmup` and for convenience have Eclipse create a `main` method.

Add these imports.
```java
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
```

In the `Iteration` class, add a handy constant
```java
static final int LIST_SIZE = 100000;
```

Write a static method
```java
static void addElements(List<Integer> list)
```
that adds `LIST_SIZE` elements to `list` using `list.add(...)`. You may add
whatever values you desire.

Write a method
```java
static int sum1(List<Integer> list)
```
that sums up all of the elements in `list` using a `for` loop and
`list.get(i)` to get the `i`th element of the list.

Now, let's time how long it takes to sum the elements of an `ArrayList` of
size `LIST_SIZE`. Inside the `main` method, create a new `ArrayList<Integer>`
and call `addElements(arrayList)` (where `arrayList` is the `ArrayList` you
just created).

The way to time how long an operation takes is to get the current time,
perform the operation, and then get the current time again. The difference in
times is the duration of the operation. Let's do exactly that, and print out
the result.
```java
LocalTime start = LocalTime.now();
sum1(arrayList);
LocalTime end = LocalTime.now();
System.out.println("sum1(arrayList):  " + Duration.between(start, end).toString());
```

When I run that on my laptop, it prints out `sum1(arrayList):  PT0.012678S`.
You can ignore the `PT`, they just stand for "period" and "time" in a
particular international standard that Java follows. The key part is
`0.012678S` which means it took 0.012678 seconds.

Now, create a new `LinkedList<Integer>`. Use `addElements(linkedList)` to add
the same number of elements to the list as before. Print out the time
`sum1(linkedList)` takes using similar code to before:
```java
start = LocalTime.now();
sum1(linkedList);
end = LocalTime.now();
System.out.println("sum1(linkedList): " + Duration.between(start,  end).toString());
```

Run the code and you'll see that it takes _much_ longer! On my laptop, it
takes more than 350 times as long!

Fortunately, Java (and most other programming languages) provides a way to
deal with this problem: iterators.

## Iterators

An
[`Iterator<E>`](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Iterator.html)
is an interface with two key methods:
- `boolean hasNext()` which returns `true` if the iterator is able to return a next value; and
- `E next()` which returns the next element; this element has type `E`.

All Java collection classes (including `ArrayList<E>` and `LinkedList<E>`)
have a method `iterator()` which returns a class which implements
`Iterator<E>`.

The way you work with an iterator is usually by writing a loop.
```java
while (iter.hasNext()) {
    E obj = iter.next();
    // Do something with obj
}
```

Write a new `static int sum2(List<Integer> list)` method that computes the sum
of the integers in the list but uses `list.iterator()` to get an
`Iterator<Integer>` and uses `hasNext()` and `next()` in a loop to compute the
sum.

Add some more code to `main` to print out how long it takes to call `sum2` on
`arrayList` and `linkedList`.
```java
start = LocalTime.now();
sum2(arrayList);
end = LocalTime.now();
System.out.println("sum2(arrayList):  " + Duration.between(start, end).toString());

start = LocalTime.now();
sum2(linkedList);
end = LocalTime.now();
System.out.println("sum2(linkedList): " + Duration.between(start,  end).toString());
```

What do you notice about the times? How do they compare to the `sum1` times?

## Collections and for-each loops

The paradigm of calling `iterator()` on a collection and then using
`iter.hasNext()` and `iter.next()` in a loop is so common in Java, that there
is special syntax for it, sometimes called a "for-each" loop.
```java
for (E obj : collection) {
    // Do something with obj.
}
```

This is the same as
```java
Iterator<E> iter = collection.iterator();
while (iter.hasNext()) {
    E obj = iter.next();
    // Do something with obj.
}
```

Write a `static int sum3(List<Integer> list)` that uses `for (Integer num :
list)` to compute the sum. Add code to `main` to print out how long it takes
to call `sum3` on the `arrayList` and the `linkedList`.

You should find that the only one of the six times you printed out that's very
slow is `sum1` on the `linkedList`.

## Iterables

The reason that the `for (E obj : collection)` works is that all of the Java
collections implement the
[Iterable](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Iterable.html)
interface. This interface has the method
```java
Iterator<E> iterator();
```

We can create our own classes that implement `Iterable` and work with for-each
loops.

Let's create a class that holds a list of professors' names. We'll implement
`Iterable` and have the `iterator()` return a class that implements
`Iterator<String>`.

Create a new class called `Professors`. Have Eclipse create a `main` method.

Add a private instance variable `String[] names` to the class and create a
constructor that takes in an array of names, and makes a copy of it. Something
like
```java
Professors(String[] names) {
    this.names = names.clone();
}
```
(We made a copy so that if the `names` array were subsequently changed, it
wouldn't change the names of the professors!)

Next, add some code to `main` to create a new `Professors` object containing
some professors' names. Something like this.
```java
String[] names = {
    "Eck",
    "Feldman",
    "Hoyle",
    "Taggart",
};
Professors profs = new Professors(names);
```
At this point, we can't do anything interesting with `profs`.

Let's make `Professors` implement `Iterable`. To do this, we need to change
the `public class Professors` line to indicate it implements
`Iterable<String>`.
```java
public class Professors implements Iterable<String>
```

This gives us an error in Eclipse because we haven't implemented the required
method `iterator()` yet, so let's get Eclipse to do that for us. You'll notice
that `Professors` is underlined in red. Mouse over it and it'll pop up a quick
fix window. Click "add unimplemented methods."

Of course, we want to actually return something that implements
`Iterator<String>`, but what? A new class! Just as you created a `Node` inner
class last time, let's create a `ProfessorIterator` inner class. At the top
(or bottom, your choice) of the `Professors` class, add
```java
private ProfessorIterator implements Iterator<String> {
}
```
Notice that `Professors` implements `Iterable<String>` but `ProfessorIterator` implements `Iterator<String>`.

`ProfessorIterator` is underlined in red because we haven't implemented the required methods. Again, hover over it and click "add unimplemented methods."

Now, we just need to write a constructor and implement `hasNext()` and
`next()`. A `ProfessorIterator` needs to know two pieces of information:
1. What list of professors is it iterating over?
2. How far into that list has it already iterated?

To keep track of that information, we need to add two instance variables to
the `ProfessorIterator`. First, it'll need a reference to the `Professors`
object and second, it'll need to keep an index into the list of names. Add the
variables
```java
private Professors profs;
private int index;
```

Write the constructor `public ProfessorIterator(Professors profs)` which just
assigns (without cloning) `profs` to `this.profs` and sets `index` to 0. Now,
write `hasNext()` by checking if `this.index` is less than
`this.profs.names.length`. Finally, write `next()` to return the next
professor's name with `"Professor "` prepended to it. E.g,
```java
String prof = "Professor " + this.profs.names[index];
```

If you've done everything correctly, you should be able to iterate over the
professors. Add this code to the `main` method.
```java
for (String prof : profs) {
    System.out.println(prof);
}
```

[&laquo; Previous](index.html)   [Next &raquo;](part1.html)