package programmers.kakao_blind_2020;

import java.util.Stack;

public class ChangeBracket {
    public static void main(String[] args) {
        String p = "))(()(";
        System.out.println(solution(p));
    }

    private static String solution(String p) {
        if (p.equals("")) {
            return "";
        }
        int countOpen = 0;
        int countClose = 0;
        for (String s : p.split("")) {
            if (s.equals("(")) {
                countOpen++;
            } else {
                countClose++;
            }
            if (countOpen == countClose) {
                break;
            }
        }

        String u = p.substring(0, countOpen + countClose);
        String v = p.substring(countOpen + countClose);

        if (isCorrect(u)) {
            return u + solution(v);
        }
        return "(" + solution(v) + ")" + getReverse(u);
    }

    private static String getReverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length()-1; i++) {
            sb.append(u.charAt(i) == ')' ? "(" : ")");
        }
        return sb.toString();
    }

    private static boolean isCorrect(String u) {
        String[] split = u.split("");
        Stack<String> stack = new Stack<>();

        if (split[0].equals(")")) {
            return false;
        }
        stack.push(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (!stack.peek().equals(split[i])) {
                stack.pop();
                continue;
            }
            stack.push(split[i]);
        }
        return stack.isEmpty();
    }
}
