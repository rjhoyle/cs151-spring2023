# Lab 4 Warmup

* [Lab 4 Home](index.html)
* Warmup
* [Part 1](part1.html)
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Linked lists

In the main part of the lab, you're going to be using linked lists in a few
places so we're going to walk through writing a simple linked list data
structure. A linked list consists of a sequence of _nodes_. A node is a very
simple data structure that contains an element and a link to the next node in
the sequence. (Later in the course, you'll write more complicated nodes that
contain multiple links.)

Make your lab professor draw one of these on the board!

## Node

In Eclipse, create a new Java Project called `Warmup 4`. Create a new class
`LinkedList` with package `warmup4`.

We want to be able to use our LinkedList class to hold any given type of object, so change
```java
public class LinkedList
```
to
```java
public class LinkedList<E>
```

Inside our `LinkedList` class, create a new, private inner class called `Node`.
```java
public class LinkedList<E> {
    private class Node {
    }
}
```

Add two public instance variables `E data` and `Node next` inside the `Node`
class. The instance variables are public so the methods of the `LinkedList`
class can access them directly. That is, if `node` is a `Node`, then methods
in the `LinkedList` class can access `node.data` and `node.next`. Since `Node`
is a private class, only `LinkedList` itself will have access to the class.

Note that `LinkedList` is parameratized by `E` but that `Node` is not. `Node`
doesn't need to be because it can use `E` from its outer class.

Add a public constructor `public Node(E data, Node next)` that sets the
`this.data` and `this.next` fields to `data` and `next`.

The `next` field of the `Node` class is what forms the link in our linked
list. This link is also called a pointer or a reference (but note that those
words have specific meanings in other programming languages). We could create
three nodes and chain them together like this:
```java
Node thirdNode = new Node("third", null);
Node secondNode = new Node("second", thirdNode);
Node firstNode = new Node("first", secondNode);
```

Notice that
- `firstNode.next` is `secondNode`;
- `firstNode.next.next` and `secondNode.next` are `thirdNode` (this is true because `firstNode.next` is `secondNode`, so `firstNode.next.next` is literally the same thing as `secondNode.next`); and
- `firstNode.next.next.next`, `secondNode.next.next`, and `thirdNode.next` are `null`.

That `null` in `thirdNode.next` is really important. That's how we know it's
the last element in the list. We'll shortly see how we can use the `next`
fields to walk down the list, one element at a time using a loop. But first,
we need to start working on our `LinkedList` class.

## LinkedList basics

Start by adding a `private Node head` instance variable to the `LinkedList`
class. For right now, our `LinkedList` is just going to contain a pointer to
the first (also called the head) node in the list. The rest of the list will
be accessed via the head's `next` field.

Create a `public LinkedList()` constructor that sets `this.head` to `null`.
Just as we use `null` for a `Node`'s `next` to indicate that there are no more
nodes in the list, we use `null` for `head` to indicate that our list contains
no elements at all.

Speaking of a list having no elements, go ahead and write a method
```java
public boolean isEmpty() {
    // Code here
}
```
that returns `true` if the list contains no elements.

Let's check that when we create a new list, we get an empty list. Normally,
we'd use a JUnit test for this and when you write your queue implementation,
you'll definitely want to write such a test. For now, make a `main()` method
that tests that we can construct an empty list. Something like this.
```java
public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<String>();
    System.out.println(list.isEmpty());
}
```
Run your code. It should print `true`.

Now it's time to add and remove some elements to our list. Let's start by
writing a method `public void addFirst(E element)` that inserts `element` at
the beginning of the list. This is the simplest method. We want to create a
new node whose data is `element` and whose `next` is `this.head`. Then, we
want to set `this.head` to that node. Notice that one of two things will
happen. If the list is empty, then `this.head` is null so `this.head` will be
set to a `Node` whose `next` is `null`. Otherwise, the list is nonempty and
`this.head` points to the first node in the list. By creating a new `Node`
whose `next` is the current `this.head` and setting `this.head` to it, what
was the first node in the list is now the second.

Modify your `main()` method to add a few strings to `list` using
`list.addFirst()`. Now, `isEmpty()` had better return `false`.

## Walking through a linked list

So far, we can add nodes contaning elements to the beginning of our list.
Let's add a private method `printList()` that will walk through all of the
elements and print them out.

How can we do that? We know that we can use `this.head.data` to get the data
of the first node in the list and `this.head.next.data` to get the data of the
second node in the list and `this.head.next.next.data` to get the data of the
third node in the list and so on. But (a) this is terrible; and (b) we'd need
to know how many elements were in the list to be able to print it out!

Instead, we can use a loop Here's an example using a `while` loop.
```java
Node node = this.head;
while (node != null) {
    System.out.println(node.data);
    node = node.next;
}
```

What's happening here is that `node` is initially set to the first element of
the list (or `null` if the list is empty). Then, at the end of each iteration
of the loop, `node` is set to the next node in the list. See how we used
`null` to recognize that we've reached the end of the list?

We can actually do the same thing slightly more concisely using a `for` loop!
```java
for (Node node = this.head; node != null; node = node.next) {
    System.out.println(node.data);
}
```
Which one you use is often a matter of preference.

Using a loop, implement the `printList()` method, but have it print out an
index to go with each element. E.g., something like
```
0: red
1: blue
2: yellow
```
where `red`, `blue`, and `yellow` were the items added to the list.

Add a call `list.printList()` to the `main` method and see what it prints out. Did it match your expectations?

## Removing from the front of the list

Now that we can add to the list, it's time to remove from it as well. Write a
method `public E removeFirst()` that removes the first node of the list and
returns its data.

There are two cases we need to handle. First, if the list is empty (which we
can check with `this.isEmpty()`), then there's nothing we can return. Instead,
throw a new `NoSuchElementException`. You'll need to import it first using
```java
import java.util.NoSuchElementException;
```
below the `package warmup4;` line.

Otherwise, the list is nonempty. The data we want to return is in
`this.head.data` and we'll need to set `this.head` to `this.head.next`. You'll
need to put `this.head.data` in a variable before you modify `this.head`.

Draw out on a piece of paper why this works for the case where the list
contains one element and the case where the list contains multiple elements.

In `main()`, add a loop to remove elements from the list and print them out one
at a time until the list is empty. You'll probably want something like `while
(!list.isEmpty())`.

## Adding to and removing from the end of the list

Adding elements to and removing elements from the beginning of the list was
pretty easy. We only needed to deal with a single `Node`.

In contrast, adding to and removing from the end of the list as we have
currently set it up is more tricky.

Implement `public void addLast(E element)`. There are two cases. If the list
is empty, then add the element to the beginning of the list and return. (In
fact, you can just call `this.addFirst(element)`!) Otherwise, you'll need to
walk down the list, starting from `this.head` until you reach the `null` which
indicates you've found the last node of the list and set `node.next = new
Node(element, null);`.

To walk down the list, it's very similar to what you did to print out the
list, except this time you want to stop when `node.next` is `null` rather than
when `node` itself is `null`. You'll probably want a `while` loop for this. So
start with `Node node = this.head;` and loop while `node.next != null`. And
after the loop, you can set `node.next` as described above.

In `main`, try adding some elements to the beginning and end of the list and
print out the results. E.g.,
```java
list.addLast("are");
list.addFirst("lists");
list.addLast("neat!");
list.addFirst("Linked");
list.printList();
```
should print
```
0: Linked
1: lists
2: are
3: neat!
```

Now comes the hardest part: removing the last element. To remove the last
element, we'll need to handle several cases.
1. If the list is empty, throw a new `NoSuchElementException`.
2. If the list has only a single node (i.e., if `this.head.next` is `null`),
   return `this.removeFirst()`. (You already wrote that code after all, no
   need to duplicate it.)
3. If the list has more than one node, then you'll need to walk down the list,
   starting from `this.head` until you get to the second to last node in the
   list, remove the last node by setting the second to last node's `next` to
   `null`, and then returning the `data` from the node you removed.

It's that last step that can be tricky. Since we checked if the list was empty
or only had a single element and handled those cases, we can assume that
`this.head.next` is not `null`. (Why is that true? What would it mean if it
were `null`?) So now we can find the second to last node via
```java
Node node = this.head;
while (node.next.next != null) {
    node = node.next;
}
```

After this, the data we want to return is in `node.next.data` and we need to
set `node.next` to `null`.

Implement `public E removeLast()` using the algorithm described above.

Make changes to your `main()` method to test out your new method. Make sure
that after removing the last element, `list.isEmpty()` returns `true`.

## Fast vs. slow

Take a look at your `addFirst()`, `removeFirst()`, `addLast()`, and
`removeLast()` methods. Notice that `addLast()` and `removeLast()` require
looping over the whole list whereas `addFirst()` and `removeFirst()` do not?
Think about what that means if our list contains 1 node, 100 nodes, or 10000
nodes. Adding to or removing from the front of the list takes the same time
regardless of how much data is in the list. In contrast, adding/removing the
last node takes roughly 100 times more work for 100 nodes than 1 node and
another 100 times more work for 10000 nodes than for 100 nodes.

That's not great, but we can do better! We can maintain a pointer (a link) to
the last, or tail, node in the list. Let's go through the "easy" changes
first.
- Add a new `private Node tail` to the `LinkedList` class.
- Update the constructor to set `tail` to `null`.
- Add to the end of `addFirst()` an if statement to check if `this.tail` is
  `null`. If it is (which will happen when this is the first node we are
  adding to the list), set `this.tail` to `this.head`. I.e., `this.head` and
  `this.tail` should point to the same node when there is only one node in the
  list. Ask the lab professor to draw out what this looks like!
- Just before the `return` in `removeFirst()`, check if `this.head` is `null`
  and if it is (which will happen when we remove the last node in the list),
  set `this.tail` to `null`.

In each of those changes, we updated the method to maintain the _invariant_ (a
property that is always true) that `this.tail` is `null` if and only if
`this.head` is `null`. I.e., either both are `null` which happens when we have
an empty list or neither are `null`.

Now, we can simplify `addLast()`. Currently, the method should check if the
list is empty and if so, just call `addFirst()` and return. Otherwise, it
loops through until it can find the last node in the list. Well now, we don't
need to do any looping! We already know what the last node in the list is.
It's `this.tail`.

Remove the loop and in its place, set `this.tail.next` to `new Node(element,
null)` and then `this.tail` to `this.tail.next`.

We've made all of our methods (except for `isEmpty()`) a little more
complicated, but in return, we were able to change `addLast()` so that it
doesn't have to loop through the whole list. That's a pretty good tradeoff.

Finally, `removeLast()`. Can we do something similar here? Unfortunately, no.
For `addLast()`, we needed to update the current last node in the list's
`next`. In order to remove the last node, we'd need to update the second to
last node's `next`. So could we maintain last node and second-to-last node
pointers in our list? Again, no. We'd need to know the third to last node in
the list. You can see how this simply cannot work. We would need a way to get
from a node to the previous node in the list. We _could_ do that, but we'd
need to maintain two links. You'll do that next week!

Fortunately, as long as we call `removeFirst()` if the list only has a single
node, we don't need to make any changes to `removeLast()`, other than updating the tail pointer.

Test your code out again. It should all be working still.

## Implementing stacks and queues

At this point, we have fast methods for inserting elements at the beginning
and end of our linked list and we have a fast method for removing elements
from the beginning of our linked list and we have a slow method for removing
elements at the end of the linked list.

If we only ever add elements to the beginning of our list and remove them from
the beginning of the list, which abstract data type have we just implemented?
Give it a shot:
```java
LinkedList<String> list = new LinkedList<String>();

list.addFirst("one");
list.addFirst("two");
list.addFirst("three");
while (!list.isEmpty()) {
    System.out.println(list.removeFirst());
}
```

If we only ever add elements to the end of our list and remove them from the
beginning of the list, which abstract data type have we just implemented? Give
this a shot.
```java
LinkedList<String> list = new LinkedList<String>();

list.addLast("one");
list.addLast("two");
list.addLast("three");
while (!list.isEmpty()) {
    System.out.println(list.removeFirst());
}
```

[&laquo; Previous](index.html)   [Next &raquo;](part1.html)