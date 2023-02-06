# Lab 1 -- The First Cup of Java

* [Lab 1 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* Part 2
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 2 -- What number am I thinking of?

For this part, I want you to create a class called `HiLo` that plays a simple
numeric guessing game. The computer will pick a number between 1 and 1000 and
then the user will try to guess what it is.

To create a random number, you will need to create a
[`Random`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Random.html)
object that will let you generate random numbers.

You then can use `rnd.nextInt(1000)` to get you a number between 0 and 999.
Just add 1 to get it into the right range.
```java
Random rnd = new Random();
int target = rnd.nextInt(1000) + 1;
```
Now you'll want to loop until the user guesses your number. Keep in mind that
you can use break and continue to exit or go to the next iteration of a loop.

Use a `Scanner` object to read from `System.in` which will capture keyboard input.
If the line doesn't start with a number (i.e., `hasNextInt()` returns false) you
should print a message out to the user and loop back to where you read an
entire line.  For an example, look at the [warmup](warmup.html).

Keep track of the number of valid guesses the user makes and let them know how
they did at the end.

```
Let's play a game!
I'm thinking of a number between 1 and 1000
Try to guess what it is!

Enter a guess: 500
Too low!

Enter a guess: 750
Too high!

Enter a guess: 625
Too low!

Enter a guess: -72
Too low!

Enter a guess: kittens
That's not a number, try again.

Enter a guess: 630
Too high!

Enter a guess: 629
You guessed my number!  It took you 6 tries.
```

[&laquo; Previous](part1.html)   [Next &raquo;](part3.html)