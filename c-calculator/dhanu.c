#include <stdio.h>
#include <math.h>

// Function to perform addition
double add(double a, double b) {
    return a + b;
}

// Function to perform subtraction
double subtract(double a, double b) {
    return a - b;
}

// Function to perform multiplication
double multiply(double a, double b) {
    return a * b;
}

// Function to perform division
double divide(double a, double b) {
    if (b == 0) {
        printf("Error: Division by zero is not allowed.\n");
        return 0.0;
    }
    return a / b;
}

int main() {

    return 0;
}