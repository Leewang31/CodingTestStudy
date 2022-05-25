package programmers.kakao_blind_2020;

public class BracketConversion {
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));

    }

    public static String solution(String p) {
        StringBuilder sb = new StringBuilder();
        if (p.length() == 0) {
            return sb.toString();
        }
        String u = "";
        String v = "";
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') left++;
            else if (p.charAt(i) == ')') right++;
            if (left != 0 && left == right) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }
        if (check(u)) {
            sb.append(u);
            sb.append(solution(v));
        } else {
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(")");
                if (u.charAt(i) == ')') sb.append("(");
            }
        }
        return sb.toString();
    }

    private static boolean check(String u) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') left++;
            else if (u.charAt(i) == ')') right++;
            if (left < right) return false;
        }
        return true;
    }
}

//다른 사람 코드 fail