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

    switch (operator) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            if (num2 == 0) {
                printf("Error: Division by zero is not allowed.\n");
                return 1; // Exit with an error code
            }
            result = num1 / num2;
            break;
    }
    
    return 0; // Exit with a success code
}