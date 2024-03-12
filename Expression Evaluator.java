import java.util.Scanner;
import java.util.Stack;

public class ExpressionEvaluator {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter an arithmetic expression: ");// ask user to enter expression
        String expression=scanner.nextLine();
        Integer result = expressionEvaluation(expression);
        System.out.println("Result: " + result); // print output
    }
    public static int expressionEvaluation(String expression) {
        Stack<Integer> numbersStack = new Stack<>(); // create stack to store numbers
        Stack<Character> operatorsStack = new Stack<>();//create stack to store opreator

        //iterating through string
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                Integer number = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number = number * 10 + (expression.charAt(i) - '0'); //extracting number from the string
                    i++;
                }
                i--; // Move back one position to handle the character after the number in the next iteration
                numbersStack.push(number);// push number into number stack
            } else if (ch == '(') {
                operatorsStack.push(ch);// push bracket into operatorsStack
            } else if (ch == ')') {
                //checking stack is not empty and the top element is not an opening bracket
                while (!operatorsStack.isEmpty() && operatorsStack.peek() != '(') {
                    performOperation(numbersStack, operatorsStack);
                }
                operatorsStack.pop(); // Pop the opening parenthesis
            } else if (isOperator(ch)) {
                while (!operatorsStack.isEmpty() && hasPrecedence(ch, operatorsStack.peek())) {
                    performOperation(numbersStack, operatorsStack);//call performOperation
                }
                operatorsStack.push(ch);
            }
        }

        while (!operatorsStack.isEmpty()) {
            performOperation(numbersStack, operatorsStack);
        }

        return numbersStack.pop(); // //return the value
    }

    // Perform arithmetic operation
    private static void performOperation(Stack<Integer> numbers, Stack<Character> operators) {
        char operator = operators.pop();// Pop operator
        int secondOperand = numbers.pop();// Pop second operand
        int firstOperand = numbers.pop();// Pop first operand
        int result = performOperation(firstOperand, secondOperand, operator);// Perform operation
        numbers.push(result);// Push result back to numbers stack

    }

    // Check precedence of operators
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != '+' && op1 != '-') || (op2 != '*' && op2 != '/');
    }
    // Check if character is an operator
    private static boolean isOperator(char ch) {

        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    // Perform arithmetic operation
    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    System.out.println("Error: Division by zero");
                    return 0; // Return 0 as result for division by zero
                }
                return operand1 / operand2;
            default:
                System.out.println("Error: Invalid operator");
                return 0; // Return 0 as result for invalid operator
        }
    }


}
