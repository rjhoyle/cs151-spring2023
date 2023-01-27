* [Lab 0 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 - Using the Lab Machines

### Windows

The lab machines boot directly into Windows and should log you in to the desktop without you needing to enter a username/password.  This has a huge disadvantage: You are responsible for managing your files and not losing them.

This needs repeating.  The Windows machines will not save your files.  Whenever they are rebooted, all files will be deleted.  If you walk away from the computer, whoever comes after you will see whatever was on your desktop.  If you are working on your homework and leave the files lying around, this has honor code implications.

You are responsible for managing your files and making sure that nobody else copies your work.  Forgetting to delete a file will not be accepted as an excuse absolving you if someone copies your homework.

We suggest using an external USB dongle and saving your files to this dongle, and making sure you take the dongle with you.

The main advantage of Windows is that you don't need to deal with Linux and the command line.  It is also more familiar to many of you.

To start using Eclipse on Windows, just hit the "Windows" key on the keyboard and type ``eclipse`` in the search bar.  The Eclipse IDE should start up.

### Linux

To use Linux, we need to fire up a virtual machine (VM) on the lab computers.  There is an icon on your desktop called "VirtualBox" that you can use to launch the VM application.  Once that is launched, you can start the Linux virtual machine.

You will need to log in with an Oberlin College Computer Science (OCCS) account.  This is not your regular Oberlin College account, so you may not yet have one.  There will be assistance during the first lab session to get you set up if you do not currently have an account.  If you missed the first lab session, send email to support@oberlin.edu and ask for an OCCS account.

One huge reason for using Linux instead of Windows is that your files are stored in the OCCS server, not on the local desktop.  That means that you can log in to any of the machines in the lab and your files will be available.  It also means that nobody but you can see your files, as they are restricted to just your account.

In adition, if you continue in Computer Science, you will be using Linux and Unix frequently, so getting more familiarity with the environment is good.

<p>
    Once you have logged in, make yourself a directory to put your class work in.
    Using a Terminal application:
</p>
<pre class="boxed">
% <span class="typed">cd</span>
% <span class="typed">mkdir cs151</span>
% <span class="typed">cd cs151</span>
% <span class="typed">mkdir lab0</span>
% <span class="typed">cd lab0</span>
</pre>
<p>
    You should do this for each lab, not only because it organizes your files,
    but also because it causes less problems with handin. And you don't want any
    problems with handin.
</p>

[&laquo; Previous](warmup.html)   [Next &raquo;](part2.html)