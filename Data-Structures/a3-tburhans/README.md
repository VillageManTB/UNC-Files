# A3 Complex Number ADT

The package a3 contains a Java interface for the complex number abstract data type. Refer here for a refresher on complex numbers: 

https://en.wikipedia.org/wiki/Complex_number

Complete the implementation for the data type started in ComplexNumberImpl. The ADT is being modeled as an immutable type which means that the multiply and add methods
should create new instances to return as their result.

Use the statically defined EQUALS_EPSILON as the epsilon bound for testing equality of the real and imaginary parts in your implementation of equals. The named constant I
is also defined for your convenience if you should need it.

The functional specification of the ADT is as follows:

* create: DOUBLE x DOUBLE => COMPLEX
  * Canonical operation for creating a new complex number given the magnitudes of its real and imaginary parts.
* real: COMPLEX => DOUBLE
  * Returns the magnitude of the real part.
* imag: COMPLEX => DOUBLE
  * Returns the magnitude of the imaginary part.
* absolute: COMPLEX => DOUBLE
  * Absolute value (see wikipedia page)
* add: COMPLEX x COMPLEX => COMPLEX
  * Addition (see wikipedia page)
* multiply: COMPLEX x COMPLEX => COMPLEX
  * Multiplication (see wikipedia page)
* equals: COMPLEX x COMPLEX => BOOLEAN
  * Equality test. Two complex numbers are equal if both their real and imaginary parts are within EQUALS_EPSILON of each other.
  
In a3test, complete the tests for the following axiomatic analysis (you'll need to come up with the right hand sides):

* real(create(A,B)) = ????
* imag(create(A,B)) = ????
* absolute(create(A,B)) = ????
* add(create(A,B), C) = ?????
* add(C, create(A,B)) = ?????
* multiply(create(A,B), C) = ?????
* multiply(C, create(A,B)) = ?????
* equals(create(A,B), C) = ?????
* equals(C, create(A,B)) = ?????

You are encouraged to make each test as complete as you can think of, testing several different values and trying to cover corner cases. Feel free to add additional
tests if you would like.


  
