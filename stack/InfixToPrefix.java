package stack;

import java.util.Stack;

public class InfixToPrefix {
    private int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    private String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) result.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    public String convert(String exp) {
        StringBuilder reversed = new StringBuilder(exp).reverse();
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') reversed.setCharAt(i, ')');
            else if (reversed.charAt(i) == ')') reversed.setCharAt(i, '(');
        }

        String postfix = infixToPostfix(reversed.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        InfixToPrefix converter = new InfixToPrefix();
        String exp = "(A-B/C)*(A/K-L)";
        System.out.println("Infix:  " + exp);
        System.out.println("Prefix: " + converter.convert(exp));
    }
}
