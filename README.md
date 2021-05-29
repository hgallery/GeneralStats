# GeneralStats
General statistics utilities by using Java Stream

**This repository contains these files:**

- ``ListSummary.java:`` This class is instantiated by giving it a list of numbers.
It contains several statistic methods that are useful in many scenarios. 
  
- ``Main.java:`` This class has the public ```main``` method that is executable. It instantiates
the ```ListSummary``` class, and calls to the statistics methods.
  

**About Functional Programming:**

It is aimed at having Lambda functions only in pure functional form.
A function is considered pure if it meets these requirements:

- The return value of the function depends only on the input parameters passed to the function.
- The execution of the function brings no side effects. (Search for this topic on the Internet if further information is required.)

By maintaining the pure functional form, developers can consider applying parallel
stream processing.

**About branching**  
- Main branch: contains only the program files and this Readme file.
- Master branch: also contains the IntelliJ IDEA configuration files.

**About JDK version**

**Java 9** or above is required due to the use of method ``ifPresentOrElse(DoubleConsumer action,
Runnable emptyAction)``.
