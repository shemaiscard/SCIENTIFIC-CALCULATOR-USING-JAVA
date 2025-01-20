
**Scientific Calculator in Java**
----------------------------------

Overview
---------
This project is a Scientific Calculator implemented in Java, leveraging Object-Oriented Programming (OOP) principles. It offers a wide range of mathematical operations, including arithmetic, geometric, exponential, and advanced functions such as factorial, permutation, and combination. The calculator also supports matrix operations (e.g., addition, subtraction, multiplication, transpose, determinant, inverse, scalar multiplication, and eigenvalues/eigenvectors) and unit conversions (e.g., degrees/radians, Celsius/Fahrenheit). It features a history functionality to track past calculations.

Designed to be modular, extensible, and user-friendly, this calculator demonstrates how Java’s OOP features (inheritance, polymorphism, encapsulation, and abstraction) can be used to build robust and maintainable applications.

---

Features
---------

1. *Arithmetic Operations*
   - Addition, Subtraction, Multiplication, Division
   - Modulus (Remainder), Absolute Value

2. *Geometric Operations*
   - Trigonometric Functions: Sine, Cosine, Tangent
   - Hyperbolic Functions: Sinh, Cosh, Tanh
   - Supports both Degrees and Radians

3. *Exponential and Logarithmic Operations*
   - Power Function (x^y), Square, Square Root, Cubic
   - Logarithm (Base 10), Natural Logarithm (ln), Exponential Function (e^x)

4. *Advanced Mathematical Functions*
   - Factorial
   - Permutation (nPr)
   - Combination (nCr)

5. *Unit Conversion*
   - Degrees to Radians, Radians to Degrees
   - Celsius to Fahrenheit, Fahrenheit to Celsius

6. *Matrix Operations*
   - Matrix Addition, Subtraction, Multiplication
   - Matrix Transpose, Determinant, Inverse
   - Scalar Multiplication
   - Eigenvalues and Eigenvectors (Placeholder for future implementation)

7. *User-Friendly Interface*
   - Clear menu-driven interface
   - Welcome message and help menu
   - Input validation for robust error handling

8. *History Feature*
   - Stores and displays past calculations for easy reference

9. *Precision Setting*
   - Supports up to 4 decimal places for accurate results

---

How to Use
----------

1. Clone the Repository:
    git clone https://github.com/shemaiscard/scientific-calculator-java.git
   cd scientific-calculator-java  

2. Compile and Run:
   javac CALCULATOR/Calculator.java
   java CALCULATOR.Calculator

3. Follow the Menu:
   - Choose from arithmetic, geometric, exponential, advanced, or matrix operations.
   - Enter the required inputs as prompted.
   - View results and history.

---

Code Structure
-------------

- **Interfaces**:
  - Arithmetic: Defines basic arithmetic operations.
  - Geometrics: Defines trigonometric and hyperbolic functions.
  - Exponential: Defines exponential, logarithmic, and advanced functions.
  - MatrixOperations: Defines matrix operations like addition, subtraction, multiplication, transpose, determinant, inverse, and scalar multiplication.

- **Main Class**:
  - Calculator: Implements all interfaces and handles user interaction.

- **Helper Methods**:
  - getInput: Reads user input.
  - formatDouble: Formats output to 4 decimal places.
  - addToHistory: Stores calculation history.
  - printMatrix: Displays matrices in a readable format.

---

Key OOP Concepts Used
------------------------

- Inheritance: Classes extend functionality through inheritance.
- Polymorphism: Methods like addition and subtraction handle multiple inputs.
- Encapsulation: Data and methods are bundled within classes.
- Abstraction: Users interact with simplified interfaces without needing to understand internal logic.

---

Challenges and Solutions
------------------------

- *Trigonometric Functions*:
  - Challenge: Supporting both degrees and radians.
  - Solution: Used Java's Math library for accurate calculations.

- *Input Validation*:
  - Challenge: Handling invalid inputs gracefully.
  - Solution: Added try-catch blocks and error messages for better error handling.

- *Matrix Operations*:
  - Challenge: Implementing complex operations like determinant and inverse.
  - Solution: Used recursive algorithms for determinant and adjugate matrix for inverse.

---

**Conclusion**
This Scientific Calculator project demonstrates the power of Java's OOP features in building a versatile and user-friendly application.
It is an excellent tool for students, engineers, and anyone who needs to perform complex mathematical calculations.

------

**May the force be with you! 🚀**
