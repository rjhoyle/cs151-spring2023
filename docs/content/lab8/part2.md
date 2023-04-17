# Lab 8 -- Priority queues

* [Lab 8 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* Part 2
* [Submission](submission.html)


## Part 2 -- Process scheduling

Priority queues are commonly used to schedule tasks in real time: as a task
becomes available, you add it to the priority queue, and then when you have
resources available, you run the task at the top of the queue. We are going
to use your priority queue to simulate an operating system scheduler picking
which program to run on your CPU - however, this same process is also used to
schedule things like which patients to attend to in the ER.

We are providing you with three Java classes: `Task`, `Scheduler`, and
`AvailableComparator`. `Task` represents the programs you are scheduling,
Scheduler represents your OS scheduler, and `AvailableComparator` is an
example of a `Comparator`. As you can see by looking at `Task.java`, `Task`
is an extremely simple class that just holds information about programs. It
contains the following variables:
```java
public String name;    
public int priority;
public int availableTime;
public int length;
public int deadline;
```

You will be implementing a variety of OS scheduling algorithms by various
comparators that compare two tasks on each of these variables. We have
already implemented AvalailableComparator.java, which sorts jobs by the time
at which they become available to be scheduled; this is equivalent to the
[First Come First Serve scheduling algorithm](https://www.guru99.com/fcfs-scheduling.html).
You will implement the following:
- `DeadlineComparator.java` - The job with the earliest (lowest) deadline
  should be scheduled first. This is equivalent to the [Earliest Deadline
  First scheduling
  algorithm](https://en.wikipedia.org/wiki/Earliest_deadline_first_scheduling)
- `LengthComparator.java` - The job with the shortest length should be
  scheduled first. This is equivalent to the [Shortest Job First Scheduling
  algorithm](https://en.wikipedia.org/wiki/Shortest_job_next)
- `NameComparator.java` - The job whose name is closest to the beginning of the
  alphabet should be scheduled first. This algorithm is not used in practice.
- `PriorityComparator.java` - The job with the highest priority should be
  scheduled first. This is equivalent to the [Priority scheduling
  algorithm](https://www.guru99.com/priority-scheduling-program.html)
- `MyComparator.java` - You get to design this one! Your comparator should
  combine job priority and either length or deadline (or both) in a way that
  favors high priority jobs but also tries to minimize the amount of time past
  deadline.

Once you have implemented a `Comparator`, you will be able to test it out using
the `Scheduler` class, which simulates an OS scheduler. `Scheduler` takes two
command line arguments: a text file of jobs, and a string indicating which
comparator to run. The strings it expects are `available`, `deadline`,
`length`, `name`, `priority`, and `mine`.

The results of running a variety of scheduling algorithms on `jobs10.txt` are
below. The number before the colon is the current timestep.

### Scheduling jobs by Length

```
0: running terry-furor priority 4 availability 0 length 48 deadline 140 0 other jobs in queue.
50: running ample-roads priority 1 availability 38 length 40 deadline 192 0 other jobs in queue.
90: running mixes-tones priority 8 availability 53 length 33 deadline 135 0 other jobs in queue.
130: running fetch-strum priority 2 availability 130 length 75 deadline 318 1 other jobs in queue.
210: running snare-ideal priority 8 availability 192 length 18 deadline 358 3 other jobs in queue.
230: running roses-octet priority 5 availability 141 length 52 deadline 365 2 other jobs in queue.
290: running mural-savor priority 4 availability 250 length 36 deadline 313 3 other jobs in queue.
330: running aging-sated priority 2 availability 239 length 75 deadline 436 2 other jobs in queue.
410: running crude-maybe priority 9 availability 172 length 78 deadline 345 1 other jobs in queue.
490: running samba-inked priority 4 availability 100 length 87 deadline 296 0 other jobs in queue.
All jobs have been run. 2 deadlines were missed, by a total of 156 milliseconds. There were 5 priority inversions.
```

### Scheduling jobs by Deadline

```
0: running terry-furor priority 4 availability 0 length 48 deadline 140 0 other jobs in queue.
50: running ample-roads priority 1 availability 38 length 40 deadline 192 0 other jobs in queue.
90: running mixes-tones priority 8 availability 53 length 33 deadline 135 0 other jobs in queue.
130: running samba-inked priority 4 availability 100 length 87 deadline 296 1 other jobs in queue.
220: running fetch-strum priority 2 availability 130 length 75 deadline 318 3 other jobs in queue.
300: running mural-savor priority 4 availability 250 length 36 deadline 313 4 other jobs in queue.
340: running crude-maybe priority 9 availability 172 length 78 deadline 345 3 other jobs in queue.
420: running snare-ideal priority 8 availability 192 length 18 deadline 358 2 other jobs in queue.
440: running roses-octet priority 5 availability 141 length 52 deadline 365 1 other jobs in queue.
500: running aging-sated priority 2 availability 239 length 75 deadline 436 0 other jobs in queue.
All jobs have been run. 4 deadlines were missed, by a total of 303 milliseconds. There were 2 priority inversions.
```

### Scheduling jobs by Priority

```
0: running terry-furor priority 4 availability 0 length 48 deadline 140 0 other jobs in queue.
50: running ample-roads priority 1 availability 38 length 40 deadline 192 0 other jobs in queue.
90: running mixes-tones priority 8 availability 53 length 33 deadline 135 0 other jobs in queue.
130: running samba-inked priority 4 availability 100 length 87 deadline 296 1 other jobs in queue.
220: running crude-maybe priority 9 availability 172 length 78 deadline 345 3 other jobs in queue.
300: running snare-ideal priority 8 availability 192 length 18 deadline 358 4 other jobs in queue.
320: running roses-octet priority 5 availability 141 length 52 deadline 365 3 other jobs in queue.
380: running mural-savor priority 4 availability 250 length 36 deadline 313 2 other jobs in queue.
420: running fetch-strum priority 2 availability 130 length 75 deadline 318 1 other jobs in queue.
500: running aging-sated priority 2 availability 239 length 75 deadline 436 0 other jobs in queue.
All jobs have been run. 3 deadlines were missed, by a total of 287 milliseconds. There were 0 priority inversions.
```

[&laquo; Previous](part1.html)   [Next &raquo;](submission.html)