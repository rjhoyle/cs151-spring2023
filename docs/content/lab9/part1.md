# Lab 9 -- Million Monkeys with Typewriters

* [Lab 9 Home](index.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)

## Part 1 -- Hash Map

First you'll implement your own hash map with separate chaining in a class
called `MyHashMap<K,V>`. You will build your hash table on top of an array;
this array should consist of an array of
[`LinkedLists`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html),
one linked list per "bucket". A very small amount of starter code has been
provided to prevent the `MarkovModel` class from showing errors. You'll need
to implement those methods as well as some others.

### Data Members

You're going to use an array to store the buckets of your hash map. Because
you're using separate chaining, each of these buckets will be a linked list of
elements, in fact, they'll be a linked list of (key, value) pairs (since each
element is really one such pair).

Java has an interface
[`java.util.Map.Entry`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.Entry.html)
for (key, value) pairs as well as a simple class that implements the interface
called
[`java.util.AbstractMap.SimpleEntry`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/AbstractMap.SimpleEntry.html).
You're going to be using `SimpleEntry` rather than making your own class.
Check out the JavaDoc for
[`SimpleEntry`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/AbstractMap.SimpleEntry.html),
but here's an example using the relevant methods.
```java
SimpleEntry<K, V> entry = new SimpleEntry<K, V>(key, value);
entry.getKey(); // Returns the key.
entry.getValue(); // Returns the value.
entry.setValue(newValue); // Returns the old value.
```
Notice that `SimpleEntry` is parameterized by `K` and `V` where `K` is the
type of the key and`V is the type of the value. Conveniently, `MyHashMap` is
also parameterized by `K` and `V`!

Since our `MyHashMap` will use separate chaining, we'll need the following instance members in the class.

`private LinkedList<SimpleEntry<K, V>>[] table;`
: The array of buckets used in the hash map.

`private int size;`
: Current number of items in the table (not the number of buckets, use `table.length` for that).

`private float loadFactor;`
: Maximum permitted load factor for the table

`private static final int DEFAULT_CAPACITY = 11;`
`private static final int DEFAULT_LOAD_FACTOR = 0.75f;`
: Constants for the default hash map capacity and a default load factor.
{: .implement-box}

### Constructors

`public MyHashMap(int capacity, float loadFactor)`
: Create a hash map with capacity buckets and a maximum load factor of loadFactor.
  First you need to initialize the array of linked lists:
  ```java
  this.table = createTable(capacity);
  ```
  This will create an array of size at least capacity that is prime. (Not
  every prime is included in the list of allowable sizes. In fact, each prime
  in the list is at least twice the size of the previous prime.)

`MyHashMap()`
: Create a hash map with the default capacity and load factor using the constants you created above.
  You can do this in one line by calling the previous constructor.
{: .implement-box}

### Public Methods

`public int size()`
: Return the number of items in the hash map, not the number of buckets.

`public boolean isEmpty()`
: Return `true` if size is 0, `false` otherwise (note you do not need an if statement for this).

`public void clear()`
: Empties out the hash map

`public V put(K key, V value)`
: Associate the specified value with the given key.

  To compute the index of the bucket (the linked list of `SimpleEntry<K, V>`s), use
  ```java
  int index = (key.hashCode() & Integer.MAX_VALUE) % this.table.length;
  ```
  This convoluted line computes the hash code of the key, transforms it to a
  nonnegative integer (that's what the `& Integer.MAX_VALUE` is doing), and then
  takes the remainder of dividing that result by the length of the table.

  Associating the value with the key does not change the size of the hash map
  if the key is already in the map. If the key is not in the map, then the
  size increases by 1.

  If the load factor threshold has been reached, call the private `resize()`
  method.

  Attempts to insert `null` values or keys should throw a `NullPointerException`.

  Return the previous value associated with the `key`, or `null` if there was
  no mapping.


`public V get(K key)`
: Return the value associated with the `key`. If no value exists, return `null`.

  This operation should not examine every index in the table, but rather,
  should only examine the one linked list indicated by the hash code. Use the
  same algorithm used in `put()` to find the index of the linked list.

  Before continuing, you should test your `MyHashMap` class if you haven't
  already. That is, you should create a JUnit test class called
  `MyHashMapTest` and check the methods you have so far before continuing.

`public V remove(K key)`
: Delete the mapping (key ,value) from the hash map. Return the previous value
  or `null` if there was no such value.

`public boolean containsKey(K key)`
: Return `true` if key is already in the hash map.

  You should only have to examine a single bucket in order to get your answer.

`public boolean containsValue(V value)`
: Return `true` if value is already in the hash map.

  This may require inspection of all buckets.

`public List<SimpleEntry<K, V>> entryList()`
: Returns a list of some sort containing all of the entries in the hash map,
  in any order.
  
  Java collections like `ArrayList` have an `addAll(otherCollection)` method
  that adds all of the elements of `otherCollection`.
{: .implement-box}

### Private Methods

`private void resize()`
: Dynamically resize the array.
  
  Make a new array of at least double the capacity, and then rehash the items
  into the new array (not every item in a bucket-chain will have the same
  key and therefore will hash differently in your new array!)
  
  This should be called whenever the maximum load factor is exceeded.
  
  The new array size should be an prime number that's at least twice the size of the existing array.
  ```java
  createTable(this.table.length * 2)
  ```
  will return an appropriately sized array.
{: .implement-box}

### Testing

Be sure to test your hash map methods with JUnit tests before continuing. You
can test your implementation by creating `MyHashMap<String, Integer>` and
calling methods. Things to test:
- A new `MyHashMap()` has size 0 and `isEmpty()` returns true.
- Putting a new key into the map increases the size of the map by 1.
- Putting an existing key into the map does not increase the size of the map.
- You can get the items you put into the map back out.
- `containsKey()` on a key in the map returns `true` and on a key not in the map
  returns `false`.
- Similarly for `containsValue()`.
- Removing a key in the map decreases the size by 1; removing a key not in the
  map does not decrease the size of the map.
- Removing a key in the map causes `containsKey()` to return false for that key.
- `clear()` sets the size of the map to 0 and keys that had been in the map
  are no longer in the map.

[&laquo; Previous](index.html)   [Next &raquo;](part2.html)