# Lab 10 -- Everything is better with Bacon

* [Lab 10 Home](index.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 -- Program Menu & Reading Files

You will be writing a class called BaconNumber that will read a data file and
allow you to interactively query the system for the Bacon Number and path for
any actor in the database. The program should require a single argument which
is the filename containing the information on people and the roles they played
in a movie. An optional second argument can be used to specify the initial
center.

If the filename argument begins with "http:" you should treat it as an URL and
read the file from the network. This will enable you to play the game without
having to download the entire file. To open a Scanner from an URL, you just
need to do something similar to the following:
```java
Scanner s = new Scanner(new URL("http://www.cs.oberlin.edu/").openStream());
```

After reading in the data file, the program should then prompt the user for
commands until the user enters `CTRL-D`.  You will use a scanner to read in
user input from standard in. `CTRL-D` is the end of file character, and will
cause `hasNextLine()` to return `false`.

### Sample arguments

`imdb.full.txt`  
: plays the game with the full data set centered at "Kevin Bacon (I)"

`imdb.pre1950.txt "Bela Lugosi"`
: plays the game with the center set to "Bela Lugosi"

`http://www.cs.oberlin.edu/~gr151/imdb/imdb.no-tv-v.txt`
: plays the game with the no TV/V data set centered at "Kevin Bacon (I)" 

### File Format

The movie data file contains information on what movies a performer appears
in. Every line contains information on one person appearing in one movie.
The lines are formatted as follows:
```
   <performer name>|<movie title>
```

The vertical pipe character `|` can be used to determine where the name ends and the title begins. There will only be one `|` on a line and there are no empty names or titles. `java.lang.String` has a number of methods that can be used to divide up the line (e.g., `split("\\|")`).

I have supplied several data files of varying sizes for you to work with.
(Don't download them to your CS account, see below.)

[imdb.cslam.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.cslam.txt)
: A 11 line file with the example from the warmp

[imdb.small.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.small.txt)
: a 1817 line file with just a handful of performers (161), fully connected

[imdb.top250.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.top250.txt)
: a 14339 line file listing just the top 250 movies on IMDB. (Disconnected groups of foreign films.)

[imdb.pre1950.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.pre1950.txt)
: a 1014465 line file with movies made before 1950

[imdb.post1950.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.post1950.txt)
: a 8159857 line file with the movies made after 1950

[imdb.only-tv-v.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.only-tv-v.txt)
: a 2302907 line file with only made for TV and direct to video movies

[imdb.no-tv-v.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.no-tv-v.txt)
: a 6871415 line file without the made for TV and direct to video movies (best for the canonical Kevin Bacon game)

[imdb.afi100.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.afi100.txt)
: American Film Institute's "100 Years...100 Movies"

[imdb.noir.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.afi100.txt)
: noir films

[imdb.post2000.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.post2000.txt)
: movies after 2000

[imdb.pre2000.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.pre2000.txt)
: movies before 2000

[imdb.full.txt](http://cs.oberlin.edu/~gr151/imdb/imdb.full.txt)
: all 9174322 lines of IMDB for you to search through

Rather than cluttering up your hard drive with these files, you can use the
links above for URLs. Other than the small database, you'll almost certainly
need to increase the amount of memory that Eclipse uses: see warmup XXX for
details on how to do this.

[&laquo; Previous](index.html)   [Next &raquo;](part2.html)