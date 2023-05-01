# Lab 10 -- Everything is better with Bacon

* Lab 10 Home
* [Part 1](part1.html)
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


9:59pm, Friday May 5th

You may work with a partner on this assignment.

The learning goals for this lab are to
- choose and implement an appropriate graph representation for a given application;
- implement breadth first search on a graph; and
- design your own implementation of a data structure for a specific application.

You will create the following Java files:
- `BaconNumber.java`
- `Graph.java`
- `Vertex.java`
- `GraphTest.java`
- Any other files for classes that you find helpful


### Introduction

In class, we have been discussing how graph structures can be used to
represent relationships between groups of objects. For this assignment, you
will be writing a program that allows you to play the [Kevin Bacon
Game](http://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon). A person's
[Bacon Number](http://en.wikipedia.org/wiki/Bacon_number#Bacon_numbers) is
computed based on the number of movies of separation between that person and
the actor Kevin Bacon. For example, if you are Kevin Bacon, then your Bacon
Number is 0. If you were in a movie with Kevin Bacon, your number would be 1.
If you weren't in a movie with Kevin Bacon, but were in a movie with someone
who was, your Bacon Number would be 2. In short, your Bacon Number is one
greater than the smallest Bacon Number of any of your co-stars.

For fun and some additional background, you can try out the [Oracle of
Bacon](http://oracleofbacon.org/) at the University of Virginia.

[Next &raquo;](part1.html)
