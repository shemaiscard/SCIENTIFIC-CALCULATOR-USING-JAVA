# Scientific Calculator (Java)

A menu-driven scientific calculator that runs in the terminal, written as an exercise in object-oriented Java.

## Features

| Menu | Operations |
| --- | --- |
| 1. Arithmetic | addition, subtraction, multiplication, division, modulus, absolute value |
| 2. Trigonometry | sine, cosine, tangent and their hyperbolic versions |
| 3. Exponential and logarithmic | power, square root, nth root, log, ln |
| 4. Combinatorics | factorial, permutation, combination |
| 5. Unit conversion | degrees and radians, Celsius and Fahrenheit |
| 6. Matrices | addition, subtraction, multiplication, transpose |
| 7. History | every result from the session |
| 9. Help | what each menu does |

You pick an option from the numbered menu and type the inputs. `Scanner` reads them from the console.

## Design

Each group of operations is an interface: `Arithmetic`, `Geometrics` (the trigonometric functions), `Exponential` and `MatrixOperations`. One `Calculator` class implements them, and the math comes from `java.lang.Math`.

## Run it

Requires Java 8 or later.

```bash
javac Main.java
java Main
```

Or open the folder in IntelliJ IDEA, Eclipse or NetBeans and run `Main.java`.

## Tech stack

Java, OOP with interfaces, console menus with `Scanner`, `java.lang.Math`.

## License

MIT License
