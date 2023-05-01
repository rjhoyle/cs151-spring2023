
# Lab 10 -- Everything is better with Bacon

* [Lab 10 Home](index.html)
* [Part 1](part1.html)
* [Part 2](part2.html)
* Part 3
* [Submission](submission.html)


## Part 3 -- Commands to be supported

Your program should read in the specified file and in the default case, choose
"Kevin Bacon (I)" as the initial center. Here are the commands you will need
to support.

`find <name>`
: Find the shortest path from the current center to `<name>`. You should use
  breadth-first search for this.  The output should be of the format
  ```
  <name1> -> <movie1> -> <name2> -> <movie2> -> ... -> Kevin Bacon (I) (n)
  ```
  where `<name1>` is the person specified by the user and the movies and
  actors in between show the path from that actor to the current center. The
  `(n)` should indicate the Bacon Number. E.g., `find James Earl Jones` in the
  "full" database yields
  ```
  James Earl Jones -> Magic 7, The (2008) (TV) -> Kevin Bacon (I) (1)
  ```
   
  and in the "no-tv-v" set
  ```
  James Earl Jones -> Blood Tide (1982) -> Mary Louise Weller -> Animal House (1978) -> Kevin Bacon (I) (2)
  ```
   
  Note that your links may differ, but the path length should be the same.

  If someone is disconnected from the center simply print
  ```
  <name> is unreachable
  ```

`recenter <name>`
: Change the center to the given name if it exists in the database. If the
  name is not found, print an appropriate message and do not change the center.

`avgdist`
: Calculate the average Bacon Number for the given center among all connected nodes. Your output should be the following
  ```
  <avg><tab><name><space>(<number reachable>,<number unreachable>)
  ```
   
  The average should only be for the nodes reachable from the center. In the
  "top250" database, I get the following
  ```
  3.5942556977039737  Kevin Bacon (I) (11803,663)
  ```

  and in the "no-tv-v" set I get
  ```
  3.003019238870945        Kevin Bacon (I) (2221752,164815)
  ```

`topcenter <n>`
: For each actor in the current connected component (i.e., the one containing
  the current center), calculate the average bacon distance to all actors in
  that component.  (Note: this can take a very long time on larger data sets.)
  Then print a table of the n best centers (i.e., the ones whose average bacon
  distance is the smallest).

  In the top 250 set, my program finds `Robert Duvall (11803,663)` is the best
  center (~2.699) and the worst center is "Kumeko Otowa (11803,663)" (~6.378).

  Here's the output from my running `topcenter 5` on the "top250" dataset:
  ```
  2.6989748369058715  robert duvall
  2.7369312886554265  harrison ford (i)
  2.741930017792087   robert de niro
  2.776666949080742   john ratzenberger
  2.798017453189867   alec guinness
  ```

`table`
: print a table of the counts of bacon numbers for the given center from 0 up to the longest.

  In the "top250" database I get:
  ```
  Table of distances for Kevin Bacon (I)
  Number    0:           1
  Number    1:          87
  Number    2:         539
  Number    3:        4462
  Number    4:        5786
  Number    5:         840
  Number    6:          88
  Unreachable:         663
  ```
   
  in the "no-tv-v" database I get:
  ```
  Table of distances for Kevin Bacon (I)
  Number    0:    1
  Number    1:    3344
  Number    2:    408925
  Number    3:    1425751
  Number    4:    349704
  Number    5:    30061
  Number    6:    3482
  Number    7:    380
  Number    8:    92
  Number    9:    12
  Unreachable:     164815
  ```
   
  and for the "full" database I get:
  ```
  Table of distances for Kevin Bacon (I)
  Number    0:    1
  Number    1:    5920
  Number    2:    646684
  Number    3:    1653925
  Number    4:    289613
  Number    5:    24138
  Number    6:    2738
  Number    7:    361
  Number    8:    64
  Number    9:    6
  Unreachable:    176859
  ```
{: .implement-box}

### Additional commands (extra credit)

You may opt to include additional other commands for consideration towards
extra credit. For any additional commands you implement, you should document
them in the `README` file. Be sure to explain what it does and how someone could
use it.

Here are some suggestions.
`findall`
: Iterate through all actors and actresses and perform a find operation on them.

`most`
: List the actor with the most film credits (i.e., the actor vertex with the highest degree).

`longest`
: Print out one of the longest paths to the center.

`movies <name>`
: List all outbound edges from a given name.
{: .implement-box}

Another option is to present the user with a menu to pick from if the IMDB file cannot be opened. Just give the user text descriptions of the data sets and have the URLs stored in your program.

### Notes

The longest Bacon Number I found in the 'imdb.no-tv-v.txt' dataset for Kevin
Bacon was 9 ("Andrea Parlato" and others). "Kevin Bacon (I)" has an average
distance value of ~2.994 while "Sean Connery" has ~2.955 indicating that he is
a better center than Kevin Bacon. The Oracle of Bacon has a top 1000 list of
centers which could be used to search for better values.

You can improve your results by appending a "(I)" to a name and retrying the
operation if it isn't found in the database before giving up. (IMDB has been
adding that to the end of a number of entries.)

### Questions to Answer

1. Describe the data structure(s) that you used to represent your graph.  How
   much space does it take up?  How does it perform with insertion, searching,
   deletion, both in terms of time and space?  
2. Describe the algorithm that you used to calculate the distances.  What was
   its runtime?  Justify your answer with a description of why it would be
   bounded as you state. 
3. Assume that we want to weigh the graph by using the quality of the movie as
   the weight of each edge.  So, if there’s a choice for an edge between
   actors Sam and Chris, going either through The Phantom Squirrel, which got
   a 6.5 rating, and Return of the Obie, which got an 8.2, we would choose the
   lowest scoring edge.  What would need to change in your data structure and
   algorithm to accommodate this?  What would be the tradeoffs that you would
   need to make?  Sketch it out, but you do not need to implement your
   changes.

### Acknowledgments
Information courtesy of The [Internet Movie Database](http://www.imdb.com/).
Used with permission. The data should only be used for personal and
non-commercial purposes.

[&laquo; Previous](part2.html)   [Next &raquo;](submission.html)