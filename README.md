# GeneralStats
General statistics utilities by using Java Stream

**This repository contains these files:**

- **ListSummary.java:** This class is instantiated by giving it a list of numbers.
It contains several statistic methods that are useful in many scenarios. The methods
  are coded by using Java Stream in pure functional form.
  
- **Main.java:** This class has the public main method that is executable. It instantiates
the ListSummary class, and calls to the statistic functions.
  

**About Functional Programming and Stream:**

It is aimed at having Lambda functions only in pure functional form.
A Lambda function is considered pure if it meets these requirements:

- The return value of the function depends only on the input parameters passed to the function.
- The execution of the function brings no side effects. (Search for this topic on the Internet if further information is required.)

By maintaining the pure functional form, developers can consider applying parallel
stream processing.





