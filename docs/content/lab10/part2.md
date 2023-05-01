
# Lab 10 -- Everything is better with Bacon

* [Lab 10 Home](index.html)
* [Part 1](part1.html)
* Part 2
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 2 -- Graphs

Your program should create a graph representation of the file you’re reading
in. Have both movies and actors be vertices and the edges indicate if an actor
is in a movie. You should use an undirected graph; however, the resulting
path length between two actors will be double the Bacon Number. You will need
to divide the path length by 2.

Because this is your last lab, we are giving you less guidance on how to
implement your `Graph` class. You should choose one of the three ways we’ve
discussed in class (adjacency matrix, adjacency list, or edge list) to
represent your graph.  Note that the graphs you’re making will be very sparse,
so you should choose a representation that works well with sparse graphs.

You will need to create and implement a `Vertex` class.  Its methods and how
you implement it will be up to you, but it should at least hold the name of
the vertex.  You may also want it to be able to return a list of every vertex
connected to it (if that makes sense for your chosen representation).

Your `Graph` class should have the following methods, plus any more you think
would be helpful.

`public Vertex addVertex(String name)`
: Create a vertex with the given name, and add it to the graph.  Return the
  vertex you created.

`public void addEdge(Vertex source, Vertex dest)`
: Add an edge between the two vertices.

`public ArrayList<Vertex> getNeighbors(Vertex v)`
: Return a list of every vertex connected to `v`.

`public Vertex getVertex(String name)`
: Return the `Vertex` that holds name.

Note that you will probably want some way to easily map from a string to a
vertex. Remember that it is best to build and test your program incrementally.
Construct your Graph class and be sure to include test cases in the main
method.

If you decide to either use or model part of your implementation off of what
is in the book, be sure to give proper credit in the methods or comments at
the start of the file.

[&laquo; Previous](part1.html)   [Next &raquo;](part3.html)