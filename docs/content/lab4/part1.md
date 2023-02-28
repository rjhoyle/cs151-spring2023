# Lab 4 -- Stacks and Queues: Simply A-Maze-ing!

* [Lab 4 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)

## Part 1 -- Stacks and Queues
We've been talking about stacks and queues in class, and now it is your time
to put that theory to good use. Write two classes `MyStack<T>` and `MyQueue<T>`
that implement the supplied interfaces `StackADT` and `QueueADT`, respectively.  These are not the default Java StackADT and QueueADT classes, so make sure you are using the provided interfaces and not the default Java ones.

`MyStack`
: An implementation of the provided `StackADT` interface that is capable
  of storing an arbitrarily large amount of data. Use an `ArrayList` for storage.  You do not need to user your implementation from the prior homework, you should just use the default Java one.

`MyQueue`
: An implementation of the provided `QueueADT` interface that is
  capable of storing an arbitrarily large amount of data.  You will implement
  the `QueueADT` as a linked structure, as described in the warmup.
{: .implement-box}
  
Before continuing, you should add JUnit tests for `MyStack` and `MyQueue` that
perform testing on your data structures. Call these `MyStackTest` and
`MyQueueTest`.

[&laquo; Previous](warmup.html)   [Next &raquo;](part2.html)