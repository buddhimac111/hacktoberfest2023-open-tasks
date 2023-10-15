# welcome to python basic calculor
import os

current_file_path = os.path.abspath(__file__)

while True:
    try:
        num1 = float(input("Enter First Number: "))
        break  
    except ValueError:
        print("Invalid input. Please enter a valid float.")
while True:
    try:
        num2 = float(input("Enter Second Number: "))
        break  
    except ValueError:
        print("Invalid input. Please enter a valid float.")

operator = input("Enter Operator (+,-,*,/,**,%): ")
if operator == "+":
    print(num1 + num2)
elif operator == "-":
    print(num1 - num2)
elif operator == "*":
    print(num1 * num2)
elif operator == "/":
    print(num1 / num2)
elif operator == "**":
     print(num1 ** num2)
elif operator == "%":
     print(num1 % num2)
else:
    print("Invalid Operator")

user_choice = input("Do you want to run the program again? (yes/no): ").lower()

if user_choice == "yes":
    print("Restarting...")
    exec(open(current_file_path).read())
else:
    print("Goodbye!")
    exit()
    
        



