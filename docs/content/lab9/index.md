# Lab 9 -- Million Monkeys with Typewriters

* Lab 9 Home
* [Part 1](part1.html)
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


10:00pm, Sunday, April 30

**You may work with a partner on this assignment.**

In this lab, you will use hash maps to generate pseudo-random text.

The purpose of this lab is to:
- Have you implement a hash map using the separate chaining method,
- Use your hash map in your implementation of a Markov model, and
- Use your Markov model to generate amusing text.

The starter code is here. [Lab9.zip](Lab9.zip).

We provide you with the following code files, which you will need to edit:
- MyHashMap.java
- MarkovModel.java

You will need to create, implement and submit the following files:
- TestGenerator.java
- MyHashMapTests.java

We also provide you with the following files for testing:
- big-bang-theory-series-1.txt
- buffy-season-1.txt
- doctor-who-series-1.txt
- drseuss.txt
- example.txt
- friends-season-1.txt
- mlp-season-1.txt
- republican-debate.txt
- shakespeare.txt
- sotu-bush.txt
- sotu-obama.txt

## Motivation

In this lab you will design and implement an order _k_ Markov model from a
piece of input text. Sounds scary? It isn't. Basically, we'll use these Markov
model things to read in a sample text, then generate a new random text based
off the sample. For example, the sample text may be a compilation of work by
Dr. Seuss, which contains content such as
```
Would you like them here or there?
I would not like them here or there.
I would not like them anywhere. 
I do not like green eggs and ham.
I do not like them Sam-I-am. 
Would you like them on a house? Would you like them with a mouse?
```

Our Markov model will read in all of Dr. Seuss' fine work, then will generate
random text in Seuss' style, such as
```
That Sam-I-am! That makes a story that needs a comb? 
No time for more, I'm almost home. I swung 'round the smoke-smuggered stars.
Now all that cart! And THEN! Who was back in the dark. 
Not one little house Leaving a thing he took every presents! 
The whole aweful lot, nothing at all, built a radio-phone. 
I put in a house. I do not like them with a goat. 
I will not eat them off. 
'Where willing to meet, rumbling like them in a box. I do not like them all! 
No more tone, have any fun? Tell me. What will show you. 
You do not like them, Sam-I-am! And you taking our Christmas a lot.
```

As you can see, our random text certainly resembles the original in spirit,
although it may not make a whole lot of sense.

First, we need to implement a hash map!

[Next &raquo;](part1.html)
