# Lab 4 -- Stacks and Queues: Simply A-Maze-ing!

* [Lab 4 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* Part 2
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 2 -- Solving the Maze

Now that you have a maze and working stack and queue data structures, we can
use them to solve mazes! You'll next be implementing the application portion
of this lab, writing up `MazeSolver` classes which will bundle up the
functionality of determining if a given maze has a valid solution. That is,
whether you can get from the start to the finish without jumping over any
walls.

Our maze solving algorithm goes something like this: begin at the start location, and trace along all possible paths to (eventually) visit every reachable square. If at some point you visit the finish `Square`, it was reachable. If you run out of squares to check, it isn't reachable.

Boiling this down into pseudocode, we have the following:

At the start
1. Create an (empty) worklist (stack/queue) of locations to explore.
2. Add the start location to it.

Each step thereafter
1. Is the worklist empty? If so, the exit is unreachable; terminate the algorithm.
2. Otherwise, grab the "next" location to explore from the worklist.
3. Does the location correspond to the exit square? If so, the finish was
   reachable; terminate the algorithm and output the path you found.
4. Otherwise, it is a reachable non-finish location that we haven't explored yet. So, explore it as follows:
   - Add every neighboring square that is not a wall to the worklist for later
     exploration provided they have not previously been added to the worklist

Note that this pseudocode does not depend on what kind of worklist you use
(namely, a stack or a queue). You'll need to pick one when you create the
worklist, but subsequently everything should work abstractly in terms of the
worklist operations.

### The `MazeSolver` abstract class

Thus, you will create an abstract class `MazeSolver` that will implement the above algorithm, with a general worklist. Its abstract methods will be implemented differently depending on whether the worklist is a stack or a queue. The `MazeSolver` class should have a non-public instance variable of type `Maze`, and should have the following methods.

`MazeSolver(Maze maze)`
: Create a (non-abstract) constructor that takes a `Maze` as a parameter and
  stores it in a variable that the children  classes can access.  The
  `MazeSolver` constructor should take as a parameter the `Maze` to be solved,
  and should perform the two initialization steps of creating an empty worklist
  (using the `makeEmpty()` abstract method) and adding the maze's start location to
  it (using the `add()` abstract method).

`abstract void makeEmpty()`
: Create an empty worklist.

`abstract boolean isEmpty()`
: Return true if the worklist is empty.

`abstract void add(Square sq)`
: Add the given Square to the worklist.

`abstract Square next()`
: Return the next item from the worklist.

`boolean isFinished()`
: A non-abstract method that the application program can use to see if this
  algorithm has solved this maze. That is, has it determined the path to the
  exit or if there is no path.

  This method will return `true` if either
  - a path from the start to the exit has been found; or
  - you determine there is no such path (worklist is now empty).

`boolean pathFound()`
: Returns `true` if there exists a path from the start to the exit, and `false` otherwise.

`void step()`
: Perform one iteration of the algorithm above (i.e., steps 1 through 4). Note
  that this is not an abstract method, that is, you should implement this method
  in the MazeSolver class by calling the abstract methods listed above.

  In order to keep track of which squares have previously been added to the
  worklist, you will "mark" each square that you place in the worklist. Then,
  before you add a square to the worklist, you should first check that it is
  not marked (and if it is, refrain from adding it).  You will use the
  `mark()` and `isMarked()` functions in `Square` to do this.

  Have each `Square` keep track of which `Square` added it to the worklist (i.e.,
  "Which `Square` was being explored when this `Square` was added to the
  worklist?"). Use the `setPrevious()` method in `Square` to do this.  Note that
  this means that each `Square` is a node in a singly-linked list of `Square`s,
  with `previous` pointing to the next node in the list.

  The `MazeApp` will repeatedly call `step()` until `isFinished()` returns `true`, so
  make sure you correctly set the `MazeSolver`'s `finished` and `pathFound` `boolean`s
  in your `step()` function; otherwise, the `MazeApp` will not work correctly.

`ArrayList<Square> getPath()`
: Returns an `ArrayList` consisting of each `Square` on the path.

  In order to create the path for `getPath()`, you will need to keep track of
  the path that was followed in your algorithm. This seems to be a difficult
  proposition; however, you've already done most of the work when you marked
  your worklist nodes using the previous variable. Let me explain.

  In order to keep from wandering in a circle, you should avoid exploring the
  same location twice. You only ever explore locations that are placed on your
  worklist, so you can guarantee that each location is explored at most once
  by making sure that each location goes on the worklist at most once. You've
  already accomplished this by "marking" each square that you place in the
  worklist and only adding unmarked squares to the list.

  You are keeping track of the solution path that includes a given square by putting
  an arrow (the `previous` variable) in it that points back to the square from
  which you added it to the worklist. Now, when you are at the exit, you can
  just follow the arrows back to the start.  Of course, following the arrows
  gives you the path in reverse orders; you will need to reverse them when you
  add them to the `ArrayList`.
{: .implement-box}

### The `MazeSolverStack` and `MazeSolverQueue` classes

Now we just need to actually create two different implementations of the
`MazeSolver` class. Create two new classes `MazeSolverStack` and
`MazeSolverQueue` that extend the `MazeSolver` class.

Each class should contain as an instance variable a worklist of the
appropriate type (so, `MazeSolverStack` should have an instance member of type
`MyStack<Square>` and `MazeSolverQueue` should have one of type
`MyQueue<Square>`).

These are not be abstract classes, and so you must implement the
`MazeSolver`'s abstract methods. All you have to do to implement the abstract
methods is perform the appropriate operations on the stack or queue instance
member. For example, the `MazeSolverStack`'s `add()` method may look like this.
```java
public void add(Square sq) {
    stack.push(sq);
}
```

Don't forget to include a call to `super(maze)` as the first line of your constructor.

[&laquo; Previous](part1.html)   [Next &raquo;](part3.html)