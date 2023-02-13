# Lab 2 Warmup

* [Lab 2 Home](index.html)
* Warmup
* [Part 1](part1.html)
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 -- Arrays

In this part, we're going to learn how to create and use arrays. Arrays are
very similar to lists in Python _except_ they have a fixed size and they're
homogeneous, meaning all elements have the same type.

Open Eclipse and create a new project called `Warmup 2`. If you've forgotten
how to do that, see the [Lab 1 Warmup](../lab1/warmup.html).

Create a new class called `Arrays` in the `warmup2` package with a `main`
method.

Inside `main`, create a new array of `int`s of length 15.
```java
int[] arr = new int[15];
```

We can access the elements of the array as `arr[0]`, `arr[1]`,... Write a
`for` loop that prints out each element of the array.
```java
for (int i = 0; i < 15; i++) {
    // Replace this comment with code to print out arr[i] here
}
```

With your partner, try to predict what will be printed. Now, run your code and
examine the output before moving on.

Okay, having done that, you've surely noticed that it printed the same value
15 times. Now, change just the line
```java
int[] arr = new int[15];
```
to
```java
int[] arr = new int[10];
```
Discuss what will happen with your partner and then run your code to check.

In retrospect, this result was entirely predictable. We changed the size of
the array, but did not change the bounds of the loop. And this is what happens
when we try to access an element of our array that is outside the bounds of
the array.

The real problem is we _hard coded_ the length 15 in the `for` loop. We
shouldn't do that. Fortunately, as we saw last lab, we can get the length of
an array `foo` by using `foo.length`. Go ahead and change the bound of the
`for` loop to be `i < arr.length` and rerun your code. Much better!

Let's try reading some `int`s from the user and storing them in an array.
Recall from last lab that we can use a `Scanner` to read `int`s using the
`nextInt()` method. We can read from the input by creating a new scanner and
then calling `nextInt()` for each integer we want.
```java
Scanner scanner = new Scanner(System.in);
int num1 = scanner.nextInt();
int num2 = scanner.nextInt();
```

Create such a scanner. Ask the user how many numbers they want to enter. Read
the integer by calling `scanner.nextInt()`. Now use that integer as the size
of our array rather than our hard coded value 10. Next, change the loop from
printing out the values of `arr[i]` to instead prompt the user to enter a
number, read the number using `scanner.nextInt()` and store it in the array at
index `i`. We can store a value `x` into an array `arr` at index `i`, using
`arr[i] = x;`.

Now, write another `for` loop to print out all of the elements of the array in reverse order. Here's an example run of the program.
```
How many numbers do you want to enter? 3
Enter an int: 10
Enter an int: 20
Enter an int: 30
30
20
10
```

# Extending an abstract class
We're now going to put our array practice to work by implementing a set data
type. Start by creating a new Java class called `AbstractSet`. Copy the
following code into the new file, replacing what Eclipse generated for you.
```java
package warmup2;

public abstract class AbstractSet<E> {
	/// Returns the number of elements in the set.
	public abstract int size();
	
	/// Adds an element e to the set.
	public abstract void add(E e);
	
	/// Remove an element e from the set, if it exists.
	public abstract void remove(E e);
	
	/// Returns true if e is contained in the set.
	public abstract boolean contains(E e);
	
	/// Returns the elements of the set in an array.
	public abstract Object[] toArray();
	
	/// Returns a string representation of the set.
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		Object[] data = this.toArray();
		
		for (int i = 0; i < data.length; i++) {
			if (i > 0)
				sb.append(", ");
			sb.append(data[i].toString());
		}
		sb.append("}");
		return sb.toString();
	}
}
```

Spend a minute or two looking over this code.

Note that the class is declared with `public abstract class` rather than
`public class`. This indicates that this is an abstract class which cannot be
instantiated directly. Some of its methods are also marked `abstract`. Any
class which extends `AbstractSet` will have to implement these methods.

One of the methods, `toString()` is not marked as `abstract` and it has a
complete implementation. If you look carefully at the implementation of
`toString()`, you'll see that it works by calling the `toArray()` abstract
method and then building a string based on that.

Let's now write a new class which extends `AbstractSet` and implements the set
data type using an array. Create a new class named `Set`. Change the
superclass from `java.lang.Object` to `AbstractSet` and make sure
"inherited abstract methods" is checked. This will create the class for us
with stub methods but it gets a few things wrong. So let's fix them up.

First, we want our new `Set` to be generic, meaning we should be able to
create a set of any type. Our `AbstractSet` was also generic so this will work
out well. Change the class declaration to
```java
public class Set<E> extends AbstractSet<E>
```
In the `add()`, `remove()`, and `contains()` methods, change `Object` to `E`.

Next, we need to add a constructor to create a new `Set` as well some private
instance variables to hold the contents of our set and some metadata about it.
With your partner, think about what information a `Set` object needs to
contain. What information about the set will it need to hold?

Hopefully, you decided that it needed to store the actual elements of the set
in some way. We're going to use an array for this. But that's not actually
enough! We'll need to keep track of how many elements are in our set.

We need to store these two pieces of information in each instance of `Set`. To
that end, add two private instance variables
```java
private Object[] data;
private int size;
```
Note that we made `data` and array of `Object`s rather than an array of
`E`—the type of our elements. That's because Java will refuse to create an
array of generic types so we'll use the base class `Object` instead.

Now, we need a constructor.
```java
public Set(int max_size) {
}
```

Go ahead and fill the constructor out by setting `this.data` to a new array of
`Object`s of size `max_size` and set `this.size` to 0 since we don't currently
have any elements in our set.

With your partner, implement the rest of the methods. Here are a few hints.
1. For `add()`, use a `for` loop to walk through the list and use
   `e.equals(this.data[i])` to check if `e` already appears in the set. If it
   does, just return. Otherwise, you should check if there's enough space to
   add `e` to the array. If there is no space, `throw new
   UnsupportedOperationException("Out of space");`.
2. For `remove()`, use a `for` loop to check if `e` is in the array. If so,
   remove it by moving elements from later in the array one spot earlier.
3. For `toArray()`, create a new array of `Object`s of size `this.size`. Fill
   the array by copying all `this.size` elements into the new array and return
   it.

Finally, let's write some code to test this out. Create a new class `Main`
with a `main` method. Create a `Set`, add some elements to it, remove some,
check if some are in the list. And try printing the set. Here's some sample
code.
```java
AbstractSet<Integer> nums = new Set<Integer>(10);
		
nums.add(10);
nums.add(10);
nums.add(15);
nums.add(20);
nums.add(15);
System.out.println(nums.contains(10));
nums.remove(10);
System.out.println(nums.contains(10));
nums.add(32);
nums.add(16);
System.out.println("There are " + nums.size() + " elements");
System.out.println(nums);
```
When run, you should see the following output.
```
true
false
There are 4 elements
{15, 20, 32, 16}
```

Try creating different sets using different types. E.g., `Set<Double>` or even `Set<Set<String>>`.

[&laquo; Previous](index.html)   [Next &raquo;](part1.html)