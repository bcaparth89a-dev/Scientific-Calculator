package service;

import utils.ExpressionEvaluator;

public class CalculatorService {

    public String calculate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return "";
        }

        try {
            double result = ExpressionEvaluator.evaluate(expression);

            if (result == (long) result) {
                return String.valueOf((long) result);
            }

            return String.valueOf(result);
        } catch (Exception e) {
            return "Error";
        }
    }
}