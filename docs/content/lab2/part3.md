# Lab 2 -- More Java Fun

* [Lab 2 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* [Part 2](part2.html)
* Part 3
* [Submission](submission.html)


## Part 3 -- Benford Analysis
Benford's Law, also known as the "first-digit law," is an observation about
the distribution of digits in numbers in data sources. In brief, in many
natural datasets the first digit will be a '1' about 30% of the time with each
higher digit occurring less frequently than the previous ending with a '9'
occurring less than 5% of the time.

There is a nice graph of this distribution on the [Wikipedia
page](https://en.wikipedia.org/wiki/Benford's_law#Mathematical_statement).

For this part of the lab, you will create a Java class named `Benford` which
finds the distribution of digits of a set of files.

### Processing files

This program will be very similar to some of the ones you have already worked
on. You will give a list of files as arguments via Run Configurations... as on prior labs.  Your program
will work through all of them (if you need to remember how to modify Run Configuration arguments, consult last week's warmup). If a file cannot be opened, just
print a message to the user and continue on.

### Counting first digits

For this program, you are only concerned about words that start with a
numerical digit, and then you need to get the value of that digit. You will
use an int array of size ten to maintain a count of the number of words you
encounter that start with the digits 0 through 9. You should use the digit as
the index into the array (i.e., `count[0]` gives you the number of words that
start with 0).

There are a number of ways you could get at the first character, determine if
it is a digit, and get the value. One way is to:
- Get a word from your input (probably using `Scanner` and
  `hasNext()`/`next()`.
- Use the word's `charAt()` method to get the first character and pass it into
  Character.isDigit() to determine if it is a digit.
- If it is, then you can use the word's substring method to extract that first
  digit as a `String`.
- And that new `String` can be passed into `Integer.parseInt()` to determine
  the integer value.
- Note that we first use `charAt()` to get the character in order to use
  `Character`'s `isDigit()` method, and then use substring to get the same character
  because `Integer.parseInt()` takes a `String` and not a `Character`.  We
  could also convert the `Character` to a `String`.
 
### Printing out the frequency chart

Once you have gone through and made a count of all your leading digits, you
should print out a histogram of the various frequencies that you encountered.
You should should print out the following information for each row,
- the leading digit 0--9;
- the total count of words beginning with that digit;
- the frequency of that digit being at the start of words beginning with
  digits (i.e., the count for that digit divided by the sum of counts for all
  digits); and
- A bar of `*` characters representing the frequency graphically, scaled by
  the maximum frequency.

When run with the input file `numbers/census-pop-est.txt`, this will print:
```
Welcome to the Benford analysis program
0     1116  0.9% : **
1    35294 29.8% : **************************************************
2    20825 17.6% : ******************************
3    14070 11.9% : ********************
4    11405  9.6% : ****************
5     9210  7.8% : *************
6     8019  6.8% : ***********
7     6809  5.7% : **********
8     6472  5.5% : *********
9     5259  4.4% : *******
```
 
The most frequently occurring digit should have a bar of length `MAX_WIDTH`
where `MAX_WIDTH` is defined by a constant in your class.
```java
   public static final int MAX_WIDTH = 50;
```
All of the other bars' lengths should be scaled proportionally to this. Take
the digit's count, divide by the max count, and multiply by `MAX_WIDTH`. You
should round this number using `Math.round()` to get it to the nearest integer.
If all the frequencies are about even, you'd expect all the bars to be about
50 units wide. If they are more varied, then the longest will be 50 and the
others will be of various shorter widths. Note that if the frequency is 0, the
bar should have 0 `*` characters.

To print out the table in a formatted fashion, you might want to use
`System.out.printf()` to do things. You can pass it a format string that uses `%d`
for decimal numbers and `%f` for floating point numbers. You can also specify a
width for each field by including a number between the `%` and the letter. Here
is what I used in the example shown above.
```java
System.out.printf("%d %8d %4.1f%% : ", digit, count[digit], freq );
```

- `%d` - is just a decimal number
- `%8d` - is a decimal number where 8 spaces will be used
- `%4.1f` - is a float with a width of 4 and 1 space after the decimal
- `%%` - because `%` is used to signify a place to put data, you put 2 of them
  in a row to actually get a `%` in your output

After the string, you list the values you want to print in the same order
Note that unlike in python, we don't have a different operator for real vs
integer division: instead, dividing one integer by another will always return
an integer.  In order to get a `float`, you will need to cast one of them as a
`float`, like: `count/(float)totalcount`.

### Sample data

I collected a number of pieces of sample data for you to try out your Benford
analysis tool on [numbers.zip](numbers.zip).
Because these are large files, and I don't want you to turn them in, they are
all in a subfolder called `numbers`. This data comes from the US Census
Bureau, CIA World Factbook, and a variety of other sources around the web. Try
running your tool on the various files. Note in your comments for your program
which ones seem to follow Benford's law and which ones don't. Feel free to
speculate why the ones that don't are that way.

When run on the input `numbers/census-pop-est.txt kittens
numbers/primes-10000.txt`, this will look like:

```
Welcome to the Benford analysis program
Could not open kittens (No such file or directory)

0     1116  0.9% : **
1    36898 28.7% : **************************************************
2    21954 17.1% : ******************************
3    15167 11.8% : *********************
4    12474  9.7% : *****************
5    10265  8.0% : **************
6     9032  7.0% : ************
7     7836  6.1% : ***********
8     7475  5.8% : **********
9     6265  4.9% : ********
```

[&laquo; Previous](part2.html)   [Next &raquo;](submission.html)