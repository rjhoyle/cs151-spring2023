# Lab 2 -- More Java Fun

* [Lab 2 Home](index.html)
* [Warmup](warmup.html)
* [Part 2](part1.html)
* Part 2
* [Part 3](part3.html)
* [Submission](submission.html)

## Part 2 -- Fighting Squirrels

In this part of the lab, you will extend an abstract class.  We have provided
you with an abstract class, `Fighter`, and the code for a fighting game, called
`FightDriver.java`.  If you look at `Fighter.java`, you will see it has three
methods that have already been written for you, and three methods you will
have to write yourself in any code that inherits from this class.  You will
have to write the following methods:

`public int fight()`
: This should return a constant representing a possible
  fighting move.  You can see that at the top of the `Fighter` class, we have
  defined four constants: `BLOCK`, `PUNCH`, `KICK` and `FIREBALL`.  In order
  for the `FightDriver` code to work correctly, you will need to return one of
  these constants.

  A note about strategy:  Each type of fight move has an integer value
  associated with it.  The move takes that much energy from the fighter who
  uses the move, and does twice that much damage to the fighter the move is
  used on---if it doesn't miss.  Fighters start with 50 energy, and get 15 more
  energy each round.  If a player has negative energy they are too tired to
  continue and lose the fight.

`public String name()`
: This should return the name of the fighter.

`public String winning()`
: This returns the catchphrase the fighter says when they win.

`public String losing()`
:  This returns the catchphrase the fighter says when they lose.
{: .implement-box}

You will create the following fighter classes, each of which extend the
abstract class `Fighter`.

`Pyro`
: - Fight: If `Pyro`’s energy is above 30, they use the `FIREBALL` move.  Otherwise they `BLOCK`. 
  - Name: `Pyro`
  - Winning & Losing: You can come up with some appropriate fire related
    catchphrases, or use the ones from the examples below.  

`KickyPunchy`
: - Fight: `KickyPunchy` alternates between `KICK` and `PUNCH`.
  - Name: `KickyPunchy`
  - Winning & Losing: You can come up with some appropriate catchphrases, or
    use the ones from the examples below.  

`FightingSquirrel`
: You get to design this one! Come up with whatever strategy, name, and catchphrases you like.

### Testing your code

If you implemented everything correctly, when you compile everything and run
the `FightDriver code`, everything should work. The fight outcomes are random,
but you should get something like this
```
The Mighty Fighting Squirrel is fighting KickyPunchy
ROUND 1 FIGHT!
  The Mighty Fighting Squirrel has 100 energy
  KickyPunchy has 100 energy
  The Mighty Fighting Squirrel uses Kick which costs 15 energy and...misses!
  KickyPunchy uses Kick which costs 15 energy and...misses!
  Both fighters recover some energy

ROUND 2 FIGHT!
  The Mighty Fighting Squirrel has 100 energy
  KickyPunchy has 100 energy
  The Mighty Fighting Squirrel uses Fireball which costs 20 energy and...misses!
  KickyPunchy uses Punch which costs 10 energy and...hits!
  The Mighty Fighting Squirrel loses 20 energy
  Both fighters recover some energy

ROUND 3 FIGHT!
  The Mighty Fighting Squirrel has 75 energy
  KickyPunchy has 100 energy
  The Mighty Fighting Squirrel uses Punch which costs 10 energy and...hits!
  KickyPunchy loses 20 energy
  KickyPunchy uses Kick which costs 15 energy and...misses!
  Both fighters recover some energy

ROUND 4 FIGHT!
  The Mighty Fighting Squirrel has 80 energy
  KickyPunchy has 80 energy
  The Mighty Fighting Squirrel uses Punch which costs 10 energy and...misses!
  KickyPunchy uses Punch which costs 10 energy and...misses!
  Both fighters recover some energy

ROUND 5 FIGHT!
  The Mighty Fighting Squirrel has 85 energy
  KickyPunchy has 85 energy
  The Mighty Fighting Squirrel blocks
  KickyPunchy uses Kick which costs 15 energy and...hits, but is blocked
  The Mighty Fighting Squirrel loses 15 energy
  Both fighters recover some energy

ROUND 6 FIGHT!
  The Mighty Fighting Squirrel has 85 energy
  KickyPunchy has 85 energy
  The Mighty Fighting Squirrel blocks
  KickyPunchy uses Punch which costs 10 energy and...misses!
  Both fighters recover some energy

ROUND 7 FIGHT!
  The Mighty Fighting Squirrel has 100 energy
  KickyPunchy has 90 energy
  The Mighty Fighting Squirrel uses Punch which costs 10 energy and...hits!
  KickyPunchy loses 20 energy
  KickyPunchy uses Kick which costs 15 energy and...misses!
  Both fighters recover some energy

ROUND 8 FIGHT!
  The Mighty Fighting Squirrel has 100 energy
  KickyPunchy has 70 energy
  The Mighty Fighting Squirrel blocks
  KickyPunchy uses Punch which costs 10 energy and...hits, but is blocked
  The Mighty Fighting Squirrel loses 10 energy
  Both fighters recover some energy

ROUND 9 FIGHT!
  The Mighty Fighting Squirrel has 100 energy
  KickyPunchy has 75 energy
  The Mighty Fighting Squirrel uses Punch which costs 10 energy and...hits!
  KickyPunchy loses 20 energy
  KickyPunchy uses Kick which costs 15 energy and...scores a CRITICAL HIT!!!
  The Mighty Fighting Squirrel loses 45 energy
  Both fighters recover some energy

ROUND 10 FIGHT!
  The Mighty Fighting Squirrel has 60 energy
  KickyPunchy has 55 energy
  The Mighty Fighting Squirrel uses Fireball which costs 20 energy and...hits!
  KickyPunchy loses 40 energy
  KickyPunchy uses Punch which costs 10 energy and...misses!
  Both fighters recover some energy

ROUND 11 FIGHT!
  The Mighty Fighting Squirrel has 55 energy
  KickyPunchy has 20 energy
  The Mighty Fighting Squirrel uses Kick which costs 15 energy and...misses!
  KickyPunchy uses Kick which costs 15 energy and...misses!
  Both fighters recover some energy

ROUND 12 FIGHT!
  The Mighty Fighting Squirrel has 55 energy
  KickyPunchy has 20 energy
  The Mighty Fighting Squirrel uses Punch which costs 10 energy and...misses!
  KickyPunchy uses Punch which costs 10 energy and...hits!
  The Mighty Fighting Squirrel loses 20 energy
  Both fighters recover some energy

ROUND 13 FIGHT!
  The Mighty Fighting Squirrel has 40 energy
  KickyPunchy has 25 energy
  The Mighty Fighting Squirrel uses Kick which costs 15 energy and...misses!
  KickyPunchy uses Kick which costs 15 energy and...hits!
  The Mighty Fighting Squirrel loses 30 energy

KickyPunchy wins!
KickyPunchy says "Kicking and punching towards Victory!"
The Mighty Fighting Squirrel says "Awww, 🥜nuts🥜."
```
or like this
```
Pyro is fighting KickyPunchy
ROUND 1 FIGHT!
  Pyro has 100 energy
  KickyPunchy has 100 energy
  Pyro uses Fireball which costs 20 energy and...misses!
  KickyPunchy uses Kick which costs 15 energy and...hits!
  Pyro loses 30 energy
  Both fighters recover some energy

ROUND 2 FIGHT!
  Pyro has 65 energy
  KickyPunchy has 100 energy
  Pyro uses Fireball which costs 20 energy and...hits!
  KickyPunchy loses 40 energy
  KickyPunchy uses Punch which costs 10 energy and...scores a CRITICAL HIT!!!
  Pyro loses 30 energy
  Both fighters recover some energy

ROUND 3 FIGHT!
  Pyro has 30 energy
  KickyPunchy has 65 energy
  Pyro blocks
  KickyPunchy uses Kick which costs 15 energy and...hits, but is blocked
  Pyro loses 15 energy
  Both fighters recover some energy

ROUND 4 FIGHT!
  Pyro has 30 energy
  KickyPunchy has 65 energy
  Pyro blocks
  KickyPunchy uses Punch which costs 10 energy and...misses!
  Both fighters recover some energy

ROUND 5 FIGHT!
  Pyro has 45 energy
  KickyPunchy has 70 energy
  Pyro uses Fireball which costs 20 energy and...hits!
  KickyPunchy loses 40 energy
  KickyPunchy uses Kick which costs 15 energy and...misses!
  Both fighters recover some energy

ROUND 6 FIGHT!
  Pyro has 40 energy
  KickyPunchy has 30 energy
  Pyro uses Fireball which costs 20 energy and...hits!
  KickyPunchy loses 40 energy
  KickyPunchy uses Punch which costs 10 energy and...misses!

Pyro wins!
Pyro says "Flame on! 🔥🔥🔥"
KickyPunchy says "I live to kick (and/or punch) another day."``
```

[&laquo; Previous](part1.html)   [Next &raquo;](part3.html)