# Lab 1 -- The First Cup of Java

* [Lab 1 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* [Part 2](part2.html)
* Part 3
* [Submission](submission.html)


## Part 3 -- Summer School

For this part of the lab, we will be using a data set of Teaching Assistant
evaluation scores collected by the Statistics Department of the University of
Wisconsin-Madison.  Our research question for this dataset is "Do classes
offered during the summer have higher or lower evaluation scores than those
offered during the regular year?"  You will create a class named `EvalAnalysis`
that does the data analysis to answer this question.

This data is in [tae.prn](tae.prn) which you should download and place in
your `Lab1` directory.

Each line of the file contains 5 numbers separated by spaces. These numbers
are the following for each class:
1. Course instructor (categorical, 25 categories);
2. Course (categorical, 26 categories);
3. Summer or regular semester (binary) 1=Summer, 2=Regular;
4. Class size (numerical); and
5. Course Evaluation Scores (categorical) 1=Low, 2=Medium, 3=High

For our purpose, we will be looking at summer versus regular semester, and
course evaluation score.  Since this is a real dataset, it contains a bunch of
information we’re not interested in: we will be looking only at the values in
columns 3 and 5.

Your program will take in the name of a file from the command line, and then
loop through every line of the file, and calculate the average course
evaluation scores for both summer and regular courses.   

You will need to use a `Scanner` to read the file, and another `Scanner` to
read each line of the file. For more details, please refer to the
[warmup](warmup.html).

To calculate the average scores, track of two running totals, one where you
add together all the course evaluation scores for summer courses, and one
where you add together all the course evaluation scores for regular courses.
You should also keep track of the number of summer courses and the number of
regular courses. Then after you have gone through the file, you can calculate
the average by dividing the course eval total by the number of courses.  

If you do not care about the number in a particular column, but you need to
read a number from the column after it, you can call scanner.nextInt() to read
in the number, but not save it anywhere, effectively ignoring it.  If I wanted
to skip the first 10 numbers in a line but save the 11th one, my code would
look like this.
```java
for (int i = 0; i < 10, i++){
    scanner.nextInt();
}
int eleventh = scanner.nextInt();
```

After your code runs, it should print something like:
```
The average review of a summer class is: x.xxxxxxx
The average review of a regular class is: x.xxxxxxx
```
where the `x`s will be replaced with the actual number you calculate. Note that
unlike in Python, Java does not have different forms of division for integer
versus float division; instead, it does integer division if both of the
numbers are integers, and float division if either is a float.  To get the
correct answer here, since both your numbers are integers, first multiply one
of them by 1.0 to transform it into a float, and then perform the division.

We have provided you with two files, [sample.prn](sample.prn) and
[tae.prn](tae.prn).  `sample.prn` is artificial data you can use to test with.  If
your code is correct, it should give you the following results:
```
The average review of a summer class 1.5714285
The average review of a regular class 2.2173913
```

`tae.prn` is the actual data.  In order for your code to "see" the file when it
runs, you will need to place your `Lab1` folder that holds your `bin` and `src`
directories.

[&laquo; Previous](part2.html)   [Next &raquo;](submission.html)