package utils;

import java.util.Stack;

public class ExpressionEvaluator {

    private static boolean isDegree = true;

    public static void setDegree(boolean degree) {
        isDegree = degree;
    }

    public static double evaluate(String expression) {
        expression = expression.replaceAll("\\s+", "");
        return evaluateExpression(expression);
    }

    private static double evaluateExpression(String expr) {

        Stack<Double> values = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (int i = 0; i < expr.length();) {

            char ch = expr.charAt(i);

            // NUMBER
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();

                while (i < expr.length() &&
                        (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    sb.append(expr.charAt(i++));
                }

                values.push(Double.parseDouble(sb.toString()));
                continue;
            }

            // FUNCTION
            if (Character.isLetter(ch)) {
                StringBuilder func = new StringBuilder();

                while (i < expr.length() && Character.isLetter(expr.charAt(i))) {
                    func.append(expr.charAt(i++));
                }

                ops.push(func.toString());
                continue;
            }

            // (
            if (ch == '(') {
                ops.push("(");
                i++;
                continue;
            }

            // )
            if (ch == ')') {
                while (!ops.peek().equals("(")) {
                    applyOp(values, ops.pop());
                }
                ops.pop(); // remove (

                if (!ops.isEmpty() && isFunction(ops.peek())) {
                    applyOp(values, ops.pop());
                }

                i++;
                continue;
            }

            // OPERATOR
            if (isOperator(ch)) {
                while (!ops.isEmpty() &&
                        precedence(ops.peek()) >= precedence(String.valueOf(ch))) {
                    applyOp(values, ops.pop());
                }

                ops.push(String.valueOf(ch));
            }

            i++;
        }

        while (!ops.isEmpty()) {
            applyOp(values, ops.pop());
        }

        return values.pop();
    }

    private static void applyOp(Stack<Double> values, String op) {

        // FUNCTION
        if (isFunction(op)) {
            double val = values.pop();

            switch (op) {
                case "sin":
                    values.push(Math.sin(convert(val)));
                    break;
                case "cos":
                    values.push(Math.cos(convert(val)));
                    break;
                case "tan":
                    values.push(Math.tan(convert(val)));
                    break;
                case "log":
                    values.push(Math.log10(val));
                    break;
                case "sqrt":
                    values.push(Math.sqrt(val));
                    break;
            }
            return;
        }

        double b = values.pop();
        double a = values.pop();

        switch (op) {
            case "+": values.push(a + b); break;
            case "-": values.push(a - b); break;
            case "*": values.push(a * b); break;
            case "/": values.push(a / b); break;
            case "%": values.push(a % b); break;
            case "^": values.push(Math.pow(a, b)); break;
        }
    }

    private static double convert(double val) {
        return isDegree ? Math.toRadians(val) : val;
    }

    private static boolean isFunction(String s) {
        return s.equals("sin") || s.equals("cos") || s.equals("tan")
                || s.equals("log") || s.equals("sqrt");
    }

    private static boolean isOperator(char ch) {
        return "+-*/%^".indexOf(ch) != -1;
    }

    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/") || op.equals("%")) return 2;
        if (op.equals("^")) return 3;
        return 0;
    }
}