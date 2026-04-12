import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeometricShapeAreaCalculator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static void main(String[] args) {
        displayWelcomeMessage();
        runApplication();
        displayGoodbyeMessage();
    }

    private static void displayWelcomeMessage() {
        System.out.println("==============================================");
        System.out.println("     GEOMETRIC SHAPE AREA CALCULATOR");
        System.out.println("==============================================");
        System.out.println("This program calculates the area of different");
        System.out.println("geometric shapes using user-provided values.");
        System.out.println();
    }

    private static void runApplication() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInteger("Enter your choice: ");

            switch (choice) {
                case 1:
                    calculateCircleArea();
                    break;
                case 2:
                    calculateRectangleArea();
                    break;
                case 3:
                    calculateTriangleArea();
                    break;
                case 4:
                    calculateSquareArea();
                    break;
                case 5:
                    calculateParallelogramArea();
                    break;
                case 6:
                    calculateTrapeziumArea();
                    break;
                case 7:
                    calculateEllipseArea();
                    break;
                case 8:
                    calculateRhombusArea();
                    break;
                case 9:
                    displayFormulaReference();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 10.");
            }

            if (running) {
                pauseBeforeContinuing();
            }
        }
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("--------------- MAIN MENU ----------------");
        System.out.println("1. Calculate area of a Circle");
        System.out.println("2. Calculate area of a Rectangle");
        System.out.println("3. Calculate area of a Triangle");
        System.out.println("4. Calculate area of a Square");
        System.out.println("5. Calculate area of a Parallelogram");
        System.out.println("6. Calculate area of a Trapezium");
        System.out.println("7. Calculate area of an Ellipse");
        System.out.println("8. Calculate area of a Rhombus");
        System.out.println("9. Show area formulas");
        System.out.println("10. Exit");
        System.out.println("------------------------------------------");
    }

    private static void calculateCircleArea() {
        System.out.println();
        System.out.println("Circle Area Calculation");
        double radius = readPositiveDouble("Enter the radius of the circle: ");
        double area = Math.PI * radius * radius;

        displayResult("Circle", area,
                "Formula used: Area = pi x radius x radius");
    }

    private static void calculateRectangleArea() {
        System.out.println();
        System.out.println("Rectangle Area Calculation");
        double length = readPositiveDouble("Enter the length of the rectangle: ");
        double width = readPositiveDouble("Enter the width of the rectangle: ");
        double area = length * width;

        displayResult("Rectangle", area,
                "Formula used: Area = length x width");
    }

    private static void calculateTriangleArea() {
        System.out.println();
        System.out.println("Triangle Area Calculation");
        double base = readPositiveDouble("Enter the base of the triangle: ");
        double height = readPositiveDouble("Enter the height of the triangle: ");
        double area = 0.5 * base * height;

        displayResult("Triangle", area,
                "Formula used: Area = 1/2 x base x height");
    }

    private static void calculateSquareArea() {
        System.out.println();
        System.out.println("Square Area Calculation");
        double side = readPositiveDouble("Enter the side of the square: ");
        double area = side * side;

        displayResult("Square", area,
                "Formula used: Area = side x side");
    }

    private static void calculateParallelogramArea() {
        System.out.println();
        System.out.println("Parallelogram Area Calculation");
        double base = readPositiveDouble("Enter the base of the parallelogram: ");
        double height = readPositiveDouble("Enter the perpendicular height: ");
        double area = base * height;

        displayResult("Parallelogram", area,
                "Formula used: Area = base x height");
    }

    private static void calculateTrapeziumArea() {
        System.out.println();
        System.out.println("Trapezium Area Calculation");
        double firstParallelSide = readPositiveDouble("Enter the first parallel side: ");
        double secondParallelSide = readPositiveDouble("Enter the second parallel side: ");
        double height = readPositiveDouble("Enter the height: ");
        double area = 0.5 * (firstParallelSide + secondParallelSide) * height;

        displayResult("Trapezium", area,
                "Formula used: Area = 1/2 x (a + b) x height");
    }

    private static void calculateEllipseArea() {
        System.out.println();
        System.out.println("Ellipse Area Calculation");
        double majorRadius = readPositiveDouble("Enter the major radius: ");
        double minorRadius = readPositiveDouble("Enter the minor radius: ");
        double area = Math.PI * majorRadius * minorRadius;

        displayResult("Ellipse", area,
                "Formula used: Area = pi x major radius x minor radius");
    }

    private static void calculateRhombusArea() {
        System.out.println();
        System.out.println("Rhombus Area Calculation");
        double diagonalOne = readPositiveDouble("Enter the first diagonal: ");
        double diagonalTwo = readPositiveDouble("Enter the second diagonal: ");
        double area = 0.5 * diagonalOne * diagonalTwo;

        displayResult("Rhombus", area,
                "Formula used: Area = 1/2 x diagonal1 x diagonal2");
    }

    private static void displayFormulaReference() {
        System.out.println();
        System.out.println("Area Formula Reference");
        System.out.println("------------------------------------------");
        System.out.println("Circle        : pi x r x r");
        System.out.println("Rectangle     : length x width");
        System.out.println("Triangle      : 1/2 x base x height");
        System.out.println("Square        : side x side");
        System.out.println("Parallelogram : base x height");
        System.out.println("Trapezium     : 1/2 x (a + b) x height");
        System.out.println("Ellipse       : pi x a x b");
        System.out.println("Rhombus       : 1/2 x d1 x d2");
        System.out.println("------------------------------------------");
    }

    private static void displayResult(String shapeName, double area, String formula) {
        System.out.println();
        System.out.println("Shape          : " + shapeName);
        System.out.println(formula);
        System.out.println("Calculated area: " + decimalFormat.format(area) + " square units");
    }

    private static int readInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }

    private static double readPositiveDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = scanner.nextDouble();
                scanner.nextLine();

                if (value > 0) {
                    return value;
                }

                System.out.println("Value must be greater than zero. Please try again.");
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }
    }

    private static void pauseBeforeContinuing() {
        System.out.println();
        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void displayGoodbyeMessage() {
        System.out.println();
        System.out.println("Thank you for using the Geometric Shape Area Calculator.");
        System.out.println("Program closed successfully.");
    }
}
