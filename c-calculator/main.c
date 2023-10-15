#include <stdio.h>

int main() {
    double num1, num2, result;
    char operator;

    printf("Enter an operator (+, -, *, /): ");
    scanf(" %c", &operator);

    if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
        printf("Invalid operator entered.");
        return 1; // Exit with an error code
    }

    printf("Enter number one: ");
    scanf("%lf", &num1);
    printf("Enter number two: ");
    scanf("%lf", &num2);
    
    return 0; // Exit with a success code
}