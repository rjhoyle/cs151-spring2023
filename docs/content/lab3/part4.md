# Lab 3 -- MyArrayList
## Part 2 -- Efficiency Testing
Great! You are done with your implementation, and you have written some JUnit
tests to make sure that each method works. Hopefully everything is being
added, set, and removed correctly. The last thing we want to quickly check is
that your program is working efficiently. Add the following three tests to your
test file (precede the method header with the `@Test` tag):

`void testAddEfficiency()`
: Create a test program that inserts 1,000,000 Integers starting at 1 onto the
  end of the list (using the single-parameter add). Every 10,000 adds, print out
  the value. Note the speed with which the program completes. Now insert the
  same Integers but onto the front of the list. Does the speed change? Why or
  why not?

  You may want to change this method's @Test tag to an @Ignore tag before
  proceeding. This will indicate to JUnit to ignore this test for the time
  being (which is good, because it takes awhile to run.)

`void testRemoveEfficiency()`
: As with the previous test, insert 1,000,000 Integers starting at 1 onto the
  end of the list (using the single-parameter add). Now remove all the elements
  from the back of the list (printing out the value every 10,000 removes). This
  should run quickly (and if not, take another look at your remove method).

`void testMemory()`
: Finally, create a test method that stores `Integers` and have it store
  values starting with 1 until it runs out of memory or throws an exception (use
  an infinite loop). Every 10,000 adds, print out the value. Note what the last
  value printed was. Now run it again telling it to use more memory and notice
  if the value changes or not. You can tell Eclipse to use more memory by
  clicking Run  >  Run Configurations..., clicking on the Arguments tab, and
  inserting `-Xmx500m` in the VM arguments textbox.
{: .implement-box}

Pay attention to the rate at which `testMemory()` prints out numbers. Do you
notice any changes? Run it again. Does it behave the same? Why do you think
this is happening?

Please put your answers to the above questions in a plain text file named
`README` file, and submit it with your lab.

**After you have completed these efficiency tests, please put `@Ignore` in
front of the `@Test` to disable them.**
