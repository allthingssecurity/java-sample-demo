public class Calculator {
    /**
     * Adds two numbers
     * @param a first number
     * @param b second number
     * @return sum of the numbers
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers
     * @param a first number
     * @param b second number
     * @return difference of the numbers
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers
     * @param a first number
     * @param b second number
     * @return product of the numbers
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two numbers
     * @param a first number
     * @param b second number
     * @return quotient of the numbers
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Main method to demonstrate calculator functionality
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("Addition: " + calc.add(10, 5));
        System.out.println("Subtraction: " + calc.subtract(10, 5));
        System.out.println("Multiplication: " + calc.multiply(10, 5));
        System.out.println("Division: " + calc.divide(10, 5));
    }
}