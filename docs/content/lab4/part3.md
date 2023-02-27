# Lab 4 -- Stacks and Queues: Simply A-Maze-ing!


* [Lab 3 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* [Part 2](part2.html)
* Part 3
* [Submission](submission.html)


## Part 3 -- Animatronics!

If everything is working in your `Maze` and `MazeSolver` classes, you should
be able to run the `MazeApp` program and get a GUI interface that will allow you
to visualize the process of finding the solution of the maze.  You do not need
to modify anything in this file.

The `load` and `quit` buttons operate as you might expect. The reset button
will call the `Maze`'s `reset()` method and then create a new `MazeSolver`. If
you click on the stack button it will toggle between using a `Stack` or `Queue` to
solve the maze.  (Take a look at the `makeNewSolver()` method in `MazeApp.java`.
You'll see that it creates a new `MazeSolver` and passes to it either a `MyStack`
or a `MyQueue`, depending on what the user has chosen in the GUI.)  The `step`
button performs a single step of the `MazeSolver` and `start` will animate things
taking one step per timer delay interval.  As the animation proceeds, marked
squares are painted gray.  If the maze is solved, the squares on the solution
path are painted yellow.  The `getPath()` method that you wrote in `MazeSolver.java`
is used to display the path in the bottom panel.

[&laquo; Previous](part2.html)   [Next &raquo;](submission.html)