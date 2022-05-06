package programmers.kakao_intern_2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumExpression {
    private static HashSet<String> operator = new HashSet<>();
    private static List<Long> number = new ArrayList<>();
    private static List<String> operators = new ArrayList<>();
    private static String expression;
    private static long max;
    public static void main(String[] args) {
        String expression = "50*6-3*2";
        System.out.println(solution(expression));
    }

    private static long solution(String expression) {
        MaximumExpression.expression = expression;
        splitExpression(expression);
        getPriority(new ArrayList<>());
        return max;
    }

    private static void splitExpression(String expression) {
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '-' || c == '+' || c == '*') {
                operators.add(String.valueOf(c));
                operator.add(String.valueOf(c));
                number.add(Long.valueOf(sb.toString()));
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        number.add(Long.valueOf(sb.toString()));
    }

    private static void getPriority(List<String> operatorOrder) {
        if (operatorOrder.size() == operator.size()) {
            long now = calc(operatorOrder);
            max = Math.max(max, now);
            return;
        }
        for (String s : operator) {
            if (!operatorOrder.contains(s)) {
                operatorOrder.add(s);
                getPriority(operatorOrder);
                operatorOrder.remove(s);
            }
        }
    }

    private static long calc(List<String> operatorOrder) {
        List<Long> numberTemp = new ArrayList<>(number);
        List<String> operatorTemp = new ArrayList<>(operators);
        for (String s : operatorOrder) {
            for (int i = 0; i < operatorTemp.size(); i++) {
                System.out.println(operatorTemp.get(i));
                if (s.equals(operatorTemp.get(i))) {
                    numberTemp.set(i, calcWithOperator(numberTemp.get(i), numberTemp.get(i + 1), s));
                    numberTemp.remove(i + 1);
                    operatorTemp.remove(i--);
                }
            }
        }
        return Math.abs(numberTemp.get(0));
    }

    private static Long calcWithOperator(Long number1, Long number2, String operation) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
        }
        return 0L;
    }
}
