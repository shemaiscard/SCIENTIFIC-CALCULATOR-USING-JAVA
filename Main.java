package CALCULATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Arithmetic {
    void addition(double... numbers);
    void subtraction(double... numbers);
    void multiplication(double... numbers);
    void division(double... numbers);
    void modulus(double dividend, double divisor);
    void absolute(double number);
}

interface Geometrics {
    void sin();
    void cos();
    void tan();
    void sinh();
    void cosh();
    void tanh();
}

interface Exponential {
    void power(double base, double exponent);
    void root(double base, double index);
    double factorial(double number);
    void permutation(double n, double r);
    void combination(double n, double r);
}

interface MatrixOperations {
    void matrixAddition(double[][] matrix1, double[][] matrix2);
    void matrixSubtraction(double[][] matrix1, double[][] matrix2);
    void matrixMultiplication(double[][] matrix1, double[][] matrix2);
    void matrixTranspose(double[][] matrix);
    void matrixDeterminant(double[][] matrix);
    void matrixInverse(double[][] matrix);
    void scalarMultiplication(double[][] matrix, double scalar);
    void eigenvaluesAndEigenvectors(double[][] matrix);
}

class Calculator implements Arithmetic, Geometrics, Exponential, MatrixOperations {
    private Scanner scanner;
    private List<String> history;

    public Calculator() {
        scanner = new Scanner(System.in);
        history = new ArrayList<>();
    }

    // Helper method to format double values
    private static String formatDouble(double value) {
        return String.format("%.4f", value);
    }

    // Helper method to get user input
    private double getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    // Helper method to get multiple inputs
    private double[] getMultipleInputs(String prompt, int count) {
        double[] inputs = new double[count];
        for (int i = 0; i < count; i++) {
            inputs[i] = getInput(prompt + (i + 1) + ": ");
        }
        return inputs;
    }

    // Helper method to get matrix input
    private double[][] getMatrixInput(String prompt, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getInput(prompt + "[" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
        return matrix;
    }

    // Clear screen method
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Display help menu
    public void displayHelp() {
        System.out.println("\nAvailable Operations:");
        System.out.println("1. Arithmetic: Addition, Subtraction, Multiplication, Division, Modulus, Absolute");
        System.out.println("2. Geometric: Sine, Cosine, Tangent, Hyperbolic Sine, Hyperbolic Cosine, Hyperbolic Tangent");
        System.out.println("3. Exponential: Power, Square, Logarithm, Natural Logarithm, Exponential Function, Root, Square Root, Cubic");
        System.out.println("4. Factorial, Permutation, Combination");
        System.out.println("5. Unit Conversion: Degrees to Radians, Radians to Degrees, Celsius to Fahrenheit, Fahrenheit to Celsius");
        System.out.println("6. Matrix Operations: Addition, Subtraction, Multiplication, Transpose, Determinant, Inverse, Scalar Multiplication, Eigenvalues and Eigenvectors");
        System.out.println("7. History: View calculation history");
        System.out.println("8. Clear Screen");
        System.out.println("0. Exit");
    }

    // Add to history
    public void addToHistory(String operation) {
        history.add(operation);
    }

    // Display history
    public void displayHistory() {
        System.out.println("\nCalculation History:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    // Arithmetic Operations
    public void addition(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        String result = "Sum: " + formatDouble(sum);
        System.out.println(result);
        addToHistory(result);
    }

    public void subtraction(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        String output = "Result of subtraction: " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void multiplication(double... numbers) {
        double product = 1;
        for (double num : numbers) {
            product *= num;
        }
        String result = "Product: " + formatDouble(product);
        System.out.println(result);
        addToHistory(result);
    }

    public void division(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("Cannot divide by zero.");
            return;
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                return;
            }
            result /= numbers[i];
        }
        String output = "Result of division: " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void modulus(double dividend, double divisor) {
        if (divisor == 0) {
            System.out.println("Cannot calculate modulus with divisor equal to 0.");
            return;
        }
        double result = dividend % divisor;
        String output = "Modulus of " + dividend + " % " + divisor + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void absolute(double number) {
        double result = Math.abs(number);
        String output = "Absolute value of " + number + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    // Geometric Operations
    public void sin() {
        double angle = getInput("Enter the angle in degrees or radians: ");
        double sinValue = Math.sin(angle);
        String result = "Sine of " + angle + " = " + formatDouble(sinValue);
        System.out.println(result);
        addToHistory(result);
    }

    public void cos() {
        double angle = getInput("Enter the angle in degrees or radians: ");
        double cosValue = Math.cos(angle);
        String result = "Cosine of " + angle + " = " + formatDouble(cosValue);
        System.out.println(result);
        addToHistory(result);
    }

    public void tan() {
        double angle = getInput("Enter the angle in degrees or radians: ");
        double tanValue = Math.tan(angle);
        String result = "Tangent of " + angle + " = " + formatDouble(tanValue);
        System.out.println(result);
        addToHistory(result);
    }

    public void sinh() {
        double angle = getInput("Enter the angle in degrees or radians: ");
        double sinhValue = Math.sinh(angle);
        String result = "Hyperbolic Sine of " + angle + " = " + formatDouble(sinhValue);
        System.out.println(result);
        addToHistory(result);
    }

    public void cosh() {
        double angle = getInput("Enter the angle in degrees or radians: ");
        double coshValue = Math.cosh(angle);
        String result = "Hyperbolic Cosine of " + angle + " = " + formatDouble(coshValue);
        System.out.println(result);
        addToHistory(result);
    }

    public void tanh() {
        double angle = getInput("Enter the angle in degrees or radians: ");
        double tanhValue = Math.tanh(angle);
        String result = "Hyperbolic Tangent of " + angle + " = " + formatDouble(tanhValue);
        System.out.println(result);
        addToHistory(result);
    }

    // Exponential Operations
    public void power(double base, double exponent) {
        double result = Math.pow(base, exponent);
        String output = base + " raised to the power of " + exponent + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void square(double number) {
        double result = Math.pow(number, 2);
        String output = "Square of " + number + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void squareRoot(double number) {
        if (number < 0) {
            System.out.println("Error: Square root of a negative number is not a real number.");
            return;
        }
        double result = Math.sqrt(number);
        String output = "Square root of " + number + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void cubic(double number) {
        double result = Math.pow(number, 3);
        String output = "Cube of " + number + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void root(double base, double index) {
        double exponent = 1 / index;
        double result = Math.pow(base, exponent);
        String output = "The " + index + "th root of " + base + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public double factorial(double number) {
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }
        double result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public void permutation(double n, double r) {
        if (n < r || n < 0 || r < 0) {
            System.out.println("Invalid input for permutation.");
            return;
        }
        double result = factorial(n) / factorial(n - r);
        String output = "Permutation of " + n + "P" + r + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    public void combination(double n, double r) {
        if (n < r || n < 0 || r < 0) {
            System.out.println("Invalid input for combination.");
            return;
        }
        double result = factorial(n) / (factorial(r) * factorial(n - r));
        String output = "Combination of " + n + "C" + r + " = " + formatDouble(result);
        System.out.println(output);
        addToHistory(output);
    }

    // Unit Conversion
    public double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    public double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Matrix Operations
    public void matrixAddition(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Matrix Addition Result:");
        printMatrix(result);
        addToHistory("Matrix Addition: " + matrixToString(result));
    }

    public void matrixSubtraction(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println("Matrix Subtraction Result:");
        printMatrix(result);
        addToHistory("Matrix Subtraction: " + matrixToString(result));
    }

    public void matrixMultiplication(double[][] matrix1, double[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            System.out.println("Error: Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Matrix Multiplication Result:");
        printMatrix(result);
        addToHistory("Matrix Multiplication: " + matrixToString(result));
    }

    public void matrixTranspose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        System.out.println("Matrix Transpose Result:");
        printMatrix(result);
        addToHistory("Matrix Transpose: " + matrixToString(result));
    }

    public void matrixDeterminant(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Error: Determinant can only be calculated for square matrices.");
            return;
        }

        double determinant = calculateDeterminant(matrix);
        System.out.println("Matrix Determinant: " + formatDouble(determinant));
        addToHistory("Matrix Determinant: " + formatDouble(determinant));
    }

    private double calculateDeterminant(double[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            double[][] subMatrix = new double[matrix.length - 1][matrix[0].length - 1];
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        subMatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        subMatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            determinant += matrix[0][i] * Math.pow(-1, i) * calculateDeterminant(subMatrix);
        }
        return determinant;
    }

    public void matrixInverse(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Error: Inverse can only be calculated for square matrices.");
            return;
        }

        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Error: Matrix is singular and does not have an inverse.");
            return;
        }

        double[][] inverse = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];
                for (int k = 0; k < matrix.length; k++) {
                    for (int l = 0; l < matrix.length; l++) {
                        if (k < i && l < j) {
                            subMatrix[k][l] = matrix[k][l];
                        } else if (k < i && l > j) {
                            subMatrix[k][l - 1] = matrix[k][l];
                        } else if (k > i && l < j) {
                            subMatrix[k - 1][l] = matrix[k][l];
                        } else if (k > i && l > j) {
                            subMatrix[k - 1][l - 1] = matrix[k][l];
                        }
                    }
                }
                inverse[j][i] = Math.pow(-1, i + j) * calculateDeterminant(subMatrix) / determinant;
            }
        }

        System.out.println("Matrix Inverse Result:");
        printMatrix(inverse);
        addToHistory("Matrix Inverse: " + matrixToString(inverse));
    }

    public void scalarMultiplication(double[][] matrix, double scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        System.out.println("Scalar Multiplication Result:");
        printMatrix(result);
        addToHistory("Scalar Multiplication: " + matrixToString(result));
    }

    public void eigenvaluesAndEigenvectors(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Error: Eigenvalues and eigenvectors can only be calculated for square matrices.");
            return;
        }

        // Placeholder for eigenvalues and eigenvectors calculation
        System.out.println("Eigenvalues and Eigenvectors calculation is not implemented yet.");
        addToHistory("Eigenvalues and Eigenvectors: Not implemented");
    }

    // Helper method to print matrix
    private void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(formatDouble(value) + "\t");
            }
            System.out.println();
        }
    }

    // Helper method to convert matrix to string
    private String matrixToString(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            for (double value : row) {
                sb.append(formatDouble(value)).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Main method
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.clearScreen();
        System.out.println("Welcome to the Scientific Calculator!");

        boolean exit = false;
        do {
            System.out.println("\nChoose an operation type:");
            System.out.println("1. Arithmetic Operations (+, -, *, /, %, abs)");
            System.out.println("2. Geometric Operations (sin, cos, tan, sinh, cosh, tanh)");
            System.out.println("3. Exponential and Logarithmic Operations (power, log, ln, sqrt, etc.)");
            System.out.println("4. Factorial, Permutation, Combination");
            System.out.println("5. Unit Conversion (Degrees/Radians, Celsius/Fahrenheit)");
            System.out.println("6. Matrix Operations (Addition, Subtraction, Multiplication, Transpose,etc. )");
            System.out.println("7. View Calculation History");
            System.out.println("8. Clear Screen");
            System.out.println("9. Help");
            System.out.println("0. Exit");

            int operationType;
            try {
                operationType = (int) calculator.getInput("Enter your choice: ");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (operationType) {
                case 1:
                    performArithmeticOperations(calculator);
                    break;
                case 2:
                    performGeometricOperations(calculator);
                    break;
                case 3:
                    performExponentialOperations(calculator);
                    break;
                case 4:
                    performAdvancedOperations(calculator);
                    break;
                case 5:
                    performUnitConversion(calculator);
                    break;
                case 6:
                    performMatrixOperations(calculator);
                    break;
                case 7:
                    calculator.displayHistory();
                    break;
                case 8:
                    calculator.clearScreen();
                    break;
                case 9:
                    calculator.displayHelp();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (!exit);

        System.out.println("Thank you for using the Scientific Calculator!");
    }

    private static void performArithmeticOperations(Calculator calculator) {
        int choice;
        do {
            System.out.println("\nChoose an arithmetic operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Absolute");
            System.out.println("0. Back to main menu");

            choice = (int) calculator.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    int numAdd = (int) calculator.getInput("Enter the number of values to add: ");
                    double[] addValues = calculator.getMultipleInputs("Enter value ", numAdd);
                    calculator.addition(addValues);
                    break;
                case 2:
                    int numSub = (int) calculator.getInput("Enter the number of values to subtract: ");
                    double[] subValues = calculator.getMultipleInputs("Enter value ", numSub);
                    calculator.subtraction(subValues);
                    break;
                case 3:
                    int numMul = (int) calculator.getInput("Enter the number of values to multiply: ");
                    double[] mulValues = calculator.getMultipleInputs("Enter value ", numMul);
                    calculator.multiplication(mulValues);
                    break;
                case 4:
                    int numDiv = (int) calculator.getInput("Enter the number of values to divide: ");
                    double[] divValues = calculator.getMultipleInputs("Enter value ", numDiv);
                    calculator.division(divValues);
                    break;
                case 5:
                    double dividendMod = calculator.getInput("Enter the dividend: ");
                    double divisorMod = calculator.getInput("Enter the divisor: ");
                    calculator.modulus(dividendMod, divisorMod);
                    break;
                case 6:
                    double absoluteNumber = calculator.getInput("Enter the number: ");
                    calculator.absolute(absoluteNumber);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void performGeometricOperations(Calculator calculator) {
        int choice;
        do {
            System.out.println("\nChoose a geometric operation:");
            System.out.println("1. Sine");
            System.out.println("2. Cosine");
            System.out.println("3. Tangent");
            System.out.println("4. Hyperbolic Sine");
            System.out.println("5. Hyperbolic Cosine");
            System.out.println("6. Hyperbolic Tangent");
            System.out.println("0. Back to main menu");

            choice = (int) calculator.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    calculator.sin();
                    break;
                case 2:
                    calculator.cos();
                    break;
                case 3:
                    calculator.tan();
                    break;
                case 4:
                    calculator.sinh();
                    break;
                case 5:
                    calculator.cosh();
                    break;
                case 6:
                    calculator.tanh();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void performExponentialOperations(Calculator calculator) {
        int choice;
        do {
            System.out.println("\nChoose an exponential operation:");
            System.out.println("1. Power");
            System.out.println("2. Square");
            System.out.println("3. Square Root");
            System.out.println("4. Cubic");
            System.out.println("5. Root");
            System.out.println("6. Logarithm (base 10)");
            System.out.println("7. Natural Logarithm (ln)");
            System.out.println("8. Exponential Function (e^x)");
            System.out.println("0. Back to main menu");

            choice = (int) calculator.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    double base = calculator.getInput("Enter the base: ");
                    double exponent = calculator.getInput("Enter the exponent: ");
                    calculator.power(base, exponent);
                    break;
                case 2:
                    double squareNumber = calculator.getInput("Enter the number: ");
                    calculator.square(squareNumber);
                    break;
                case 3:
                    double sqrtNumber = calculator.getInput("Enter the number: ");
                    calculator.squareRoot(sqrtNumber);
                    break;
                case 4:
                    double cubicNumber = calculator.getInput("Enter the number: ");
                    calculator.cubic(cubicNumber);
                    break;
                case 5:
                    double rootBase = calculator.getInput("Enter the base: ");
                    double index = calculator.getInput("Enter the index: ");
                    calculator.root(rootBase, index);
                    break;
                case 6:
                    double logNumber = calculator.getInput("Enter the number: ");
                    System.out.println("Logarithm (base 10) of " + logNumber + " = " + formatDouble(Math.log10(logNumber)));
                    break;
                case 7:
                    double lnNumber = calculator.getInput("Enter the number: ");
                    System.out.println("Natural logarithm (ln) of " + lnNumber + " = " + formatDouble(Math.log(lnNumber)));
                    break;
                case 8:
                    double expNumber = calculator.getInput("Enter the number: ");
                    System.out.println("Exponential function e^" + expNumber + " = " + formatDouble(Math.exp(expNumber)));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void performAdvancedOperations(Calculator calculator) {
        int choice;
        do {
            System.out.println("\nChoose an advanced operation:");
            System.out.println("1. Factorial");
            System.out.println("2. Permutation");
            System.out.println("3. Combination");
            System.out.println("0. Back to main menu");

            choice = (int) calculator.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    double factorialNumber = calculator.getInput("Enter the number: ");
                    calculator.factorial(factorialNumber);
                    break;
                case 2:
                    double nPerm = calculator.getInput("Enter n: ");
                    double rPerm = calculator.getInput("Enter r: ");
                    calculator.permutation(nPerm, rPerm);
                    break;
                case 3:
                    double nComb = calculator.getInput("Enter n: ");
                    double rComb = calculator.getInput("Enter r: ");
                    calculator.combination(nComb, rComb);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void performUnitConversion(Calculator calculator) {
        int choice;
        do {
            System.out.println("\nChoose a unit conversion:");
            System.out.println("1. Degrees to Radians");
            System.out.println("2. Radians to Degrees");
            System.out.println("3. Celsius to Fahrenheit");
            System.out.println("4. Fahrenheit to Celsius");
            System.out.println("0. Back to main menu");

            choice = (int) calculator.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    double degrees = calculator.getInput("Enter degrees: ");
                    System.out.println(degrees + " degrees = " + formatDouble(calculator.toRadians(degrees)) + " radians");
                    break;
                case 2:
                    double radians = calculator.getInput("Enter radians: ");
                    System.out.println(radians + " radians = " + formatDouble(calculator.toDegrees(radians)) + " degrees");
                    break;
                case 3:
                    double celsius = calculator.getInput("Enter Celsius: ");
                    System.out.println(celsius + " Celsius = " + formatDouble(calculator.celsiusToFahrenheit(celsius)) + " Fahrenheit");
                    break;
                case 4:
                    double fahrenheit = calculator.getInput("Enter Fahrenheit: ");
                    System.out.println(fahrenheit + " Fahrenheit = " + formatDouble(calculator.fahrenheitToCelsius(fahrenheit)) + " Celsius");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }

    private static void performMatrixOperations(Calculator calculator) {
        int choice;
        do {
            System.out.println("\nChoose a matrix operation:");
            System.out.println("1. Matrix Addition");
            System.out.println("2. Matrix Subtraction");
            System.out.println("3. Matrix Multiplication");
            System.out.println("4. Matrix Transpose");
            System.out.println("5. Matrix Determinant");
            System.out.println("6. Matrix Inverse");
            System.out.println("7. Scalar Multiplication");
            System.out.println("8. Eigenvalues and Eigenvectors");
            System.out.println("0. Back to main menu");

            choice = (int) calculator.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    int rowsAdd = (int) calculator.getInput("Enter the number of rows: ");
                    int colsAdd = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrix1Add = calculator.getMatrixInput("Enter values for matrix 1", rowsAdd, colsAdd);
                    double[][] matrix2Add = calculator.getMatrixInput("Enter values for matrix 2", rowsAdd, colsAdd);
                    calculator.matrixAddition(matrix1Add, matrix2Add);
                    break;
                case 2:
                    int rowsSub = (int) calculator.getInput("Enter the number of rows: ");
                    int colsSub = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrix1Sub = calculator.getMatrixInput("Enter values for matrix 1", rowsSub, colsSub);
                    double[][] matrix2Sub = calculator.getMatrixInput("Enter values for matrix 2", rowsSub, colsSub);
                    calculator.matrixSubtraction(matrix1Sub, matrix2Sub);
                    break;
                case 3:
                    int rowsMul1 = (int) calculator.getInput("Enter the number of rows for matrix 1: ");
                    int colsMul1 = (int) calculator.getInput("Enter the number of columns for matrix 1: ");
                    int rowsMul2 = (int) calculator.getInput("Enter the number of rows for matrix 2: ");
                    int colsMul2 = (int) calculator.getInput("Enter the number of columns for matrix 2: ");
                    double[][] matrix1Mul = calculator.getMatrixInput("Enter values for matrix 1", rowsMul1, colsMul1);
                    double[][] matrix2Mul = calculator.getMatrixInput("Enter values for matrix 2", rowsMul2, colsMul2);
                    calculator.matrixMultiplication(matrix1Mul, matrix2Mul);
                    break;
                case 4:
                    int rowsTrans = (int) calculator.getInput("Enter the number of rows: ");
                    int colsTrans = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrixTrans = calculator.getMatrixInput("Enter values for matrix", rowsTrans, colsTrans);
                    calculator.matrixTranspose(matrixTrans);
                    break;
                case 5:
                    int rowsDet = (int) calculator.getInput("Enter the number of rows: ");
                    int colsDet = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrixDet = calculator.getMatrixInput("Enter values for matrix", rowsDet, colsDet);
                    calculator.matrixDeterminant(matrixDet);
                    break;
                case 6:
                    int rowsInv = (int) calculator.getInput("Enter the number of rows: ");
                    int colsInv = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrixInv = calculator.getMatrixInput("Enter values for matrix", rowsInv, colsInv);
                    calculator.matrixInverse(matrixInv);
                    break;
                case 7:
                    int rowsScalar = (int) calculator.getInput("Enter the number of rows: ");
                    int colsScalar = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrixScalar = calculator.getMatrixInput("Enter values for matrix", rowsScalar, colsScalar);
                    double scalar = calculator.getInput("Enter the scalar value: ");
                    calculator.scalarMultiplication(matrixScalar, scalar);
                    break;
                case 8:
                    int rowsEigen = (int) calculator.getInput("Enter the number of rows: ");
                    int colsEigen = (int) calculator.getInput("Enter the number of columns: ");
                    double[][] matrixEigen = calculator.getMatrixInput("Enter values for matrix", rowsEigen, colsEigen);
                    calculator.eigenvaluesAndEigenvectors(matrixEigen);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }
}