# Lab 1 -- The First Cup of Java

* [Lab 1 Home](index.html)
* [Warmup](warmup.html)
* Part 1
* [Part 2](part2.html)
* [Part 3](part3.html)
* [Submission](submission.html)


## Part 1 -- Pyramids revisited

Create a new folder for your project called `Lab1`.  Create the Java project in
Eclipse by selecting "File" > "New" > "Java Project". Give it the project name
`Lab 1`.  Uncheck the `Use default location` box. After you uncheck this box, the
Location textbox becomes active. Use the browse button to select the `Lab1`
folder you created at the start.  Click `Finish`.

Highlight `Lab1`, then select `New` from the `File` menu and `Class` from the popup
list. This brings up the `New Class` window, which should already have `Lab1/src`
as the source folder. If this is not the case use the `Browse` button to
navigate to this folder. Next, it asks for a package name. Use `lab1` for this.
Use `Pyramid` as the name of the class and check the button for including a
`public static void main` stub. Click the `Finish` button at the bottom and you
are ready to start coding.

For your first program I want you to create a class called Pyramid that draws
a simple pyramid out of `*` characters. Your program will:

- Check that the user has entered exactly 1 command line argument.  To do
  this, use the String array parameter to main called args, and check that
  args.length is equal to 1. If it isn't, you should print a message to the
  user and then quit by calling System.exit(1);
- Convert the command line argument to an integer.  Integer.parseInt is a
  static method in the Integer class that allows you to convert a String that
  represents a number and turn it into an int. Use Integer.parseInt to convert
  the first argument args[0] into an int that represents the number of rows in
  your pyramid.

  ```java
  int height = Integer.parseInt(args[0]);
  ```
- Print out the pyramid

Here are some examples of inputs and outputs. (Recall from the
[warmup](warmup.html) that the way you provide command line arguments is from
the `Run` > `Run Configurations…` menu option and then click on the `(x)=
Arguments` tab.)

```
input: 5
output:
    *
   ***
  *****
 *******
*********
```

```
input: 1
output:
*
```

```
No input
output: 
You need to provide an argument!
```

You may want to spend a couple of minutes figuring out how many stars and how
many spaces you will print in each line as a function of height and your loop
index.

[&laquo; Previous](warmup.html)   [Next &raquo;](part2.html)