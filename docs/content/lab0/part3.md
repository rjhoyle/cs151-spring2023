* [Lab 0 Home](index.html)
* [Warmup](warmup.html)
* [Part 1](part1.html)
* [Part 2](part2.html)
* Part 3
* [Submission](submission.html)

## Part 3 - Doing "real work" in Eclipse
<h3>Create project</h3>
<p>
    Now we should create a project in our lab0 folder like you'll be doing in
    many of the labs.
</p>

* Select <b>"File"&nbsp;&gt;&nbsp;"New"&nbsp;&gt;&nbsp;"Java Project"</b>
* Call it <b>"Hello 151"</b> (or "lab0" or whatever you want)
* <strong>uncheck</strong> the box for <b>"use default location"</b>
* Use the <b>"Browse"</b> button to select the <tt>lab0</tt> folder you created earlier
* Now just select <b>"Finish"</b>

<p>
    If you want, you can close the <b>Task List</b> and <b>Outline</b> panes on
    the right side.  We won't be using them for this.
</p>

<p>
    Now let's create a class that will tell the user a little bit about yourself.
</p>

* Select <b>"File"&nbsp;&gt;&nbsp;"New"&nbsp;&gt;&nbsp;"Class"</b>
* Don't change the project or source folder
* Set the <b>Name</b> of class to be <tt>Hello151</tt> 
* Check the box that will create the <tt>main</tt> method stub
* Now select <b>"Finish"</b>



<p>
    You should now see <b>Hello151.java</b> in the Package Explorer window.  If
    you do an <tt>ls</tt> on the command line in your lab0 folder, you'll see that there is both
    <tt>Hello151.java</tt> and <tt>Hello151.class</tt> in this folder.  Eclipse 
    compiles as you work!
</p>

<h3>Comments!</h3>
<p>
    The <tt>Hello151.java</tt> file should be open in the editor.  If not, just
    double click on it in the Package Explorer window.  Let's add some comments
    to the top of the file.
</p>

* Go to the top of the file and start a Javadoc comment.  Recall they begin with <tt>/**</tt> 
* Put in a short description of what this file is supposed to do.  In this case, you are going to introduce yourself to the graders.
* On another line, but still in the comment block, start a line with <tt>@author</tt> followed by your name
* Close the comment block with a <tt>*/</tt>. It is likely that eclipse has already done this for you.

<h3>Run your program</h3>
<p>
    Just in case you've not actually tried to run your program, now would be a great time to check that it works.  Here's a line you can add to the main method that will give you some output
</p>
<pre class="code prettyprint lang-java padded">
    System.out.println("When I graduate, I will donate 10% of my salary to the CS department.");
</pre>
<p>
    You can run it in Eclipse by just selecting <b>"Run"</b>, <b>"Run"</b> from the pull-down menus. Or right-click and select <b>"Run As"</b>, <b>"Java Application"</b>.
</p>

<h3>Share with the graders</h3>
<p>
    Now let's add some print statements to introduce yourself to the graders.
    Inside the <tt>main()</tt> method, add in a number of
    <tt>System.out.println</tt> messages that will share:
</p>

* Your name as you want to be called
* Your CS username
* Your year/major (if known)
* Something you think is awesome about Oberlin

<h3>Get on with your life</h3>
<p>
If you've made it this far, and actually changed preferences and done the steps
I listed above, that's enough Java programming for this week.
</p>



[&laquo; Previous](part2.html)   [Next &raquo;](submission.html)