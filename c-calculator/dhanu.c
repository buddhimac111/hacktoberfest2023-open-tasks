#include <stdio.h>
#include <math.h>

double add(double a, double b) {
    return a + b;
}

double subtract(double a, double b) {
    return a - b;
}

double multiply(double a, double b) {
    return a * b;
}

double divide(double a, double b) {
    if (b == 0) {
        printf("Error: Division by zero is not allowed.\n");
        return 0.0;
    }
    return a / b;
}

// Function to perform exponentiation
double power(double base, double exponent) {
    return pow(base, exponent);
}

// Function to calculate the square root
double squareRoot(double num) {
    if (num < 0) {
        printf("Error: Cannot calculate square root of a negative number.\n");
        return 0.0;
    }
    return sqrt(num);
}

// Function to calculate the logarithm
double logarithm(double base, double num) {
    if (base <= 0 || num <= 0) {
        printf("Error: Arguments of the log function must be positive.\n");
        return 0.0;
    }
    return log(num) / log(base);
}

int main() {

    double num1, num2, result;
    char operation;

    printf("Advanced Calculator\n");
    printf("Enter an operation (+, -, *, /, ^, sqrt, log): ");
    scanf(" %c", &operation);

    printf("Enter two numbers: ");
    scanf("%lf %lf", &num1, &num2);

    switch (operation) {
        case '+':
            result = add(num1, num2);
            break;
        case '-':
            result = subtract(num1, num2);
            break;
        case '*':
            result = multiply(num1, num2);
            break;
        case '/':
            result = divide(num1, num2);
            break;
        case '^':
            result = power(num1, num2);
            break;
        case 's':
            result = squareRoot(num1);
            break;
        case 'l':
            result = logarithm(num1, num2);
            break;
        default:
            printf("Invalid operation entered.\n");
            return 1; // Exit with an error code
    }

    printf("Result: %lf\n", result);


    return 0;
}