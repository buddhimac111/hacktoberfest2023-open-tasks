#include<stdio.h>
#include<conio.h>
#include<math.h>

int main(void){
    double first;
    double second;
    char choice;

    printf("###########################");
    printf("\nSimple Calculator Program!! \n");
    printf("###########################");

    printf("\nEnter the First Number: ");
    scanf("%lf", &first);

    printf("\nEnter the Second Number: ");
    scanf("%lf", &second);

    printf("\nNow enter the operator (+, -, *, /, ^): ");
    scanf(" %c", &choice);

    switch (choice){
        case '+':
            printf("\nThe addition of two numbers %.2lf and %.2lf is: %.2lf\n", first, second, first+second);
            break;
        case '-':
            printf("\nThe Subtraction of two numbers %.2lf and %.2lf is: %.2lf\n", first, second, first-second);
            break;
        case '*':
            printf("\nThe Product of two numbers %.2lf and %.2lf is: %.2lf\n", first, second, first*second);
            break;
        case '/':
            printf("\nThe Division of two numbers %.2lf and %.2f is: %.2lf\n", first, second, first/second);
            break;
        case '^':
            printf("\nThe Value of %.2lf raised to %.2lf is: %.2lf\n", first, second, pow(first, second));
            break;
        default:
            printf("\nInvalid Operator\n");
            break;
    }
        

    return 0;


}