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

int main() {

    return 0;
}