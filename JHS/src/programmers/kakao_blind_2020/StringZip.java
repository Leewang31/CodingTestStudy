package programmers.kakao_blind_2020;

public class StringZip {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length()/2+1; i++) {
            answer = Math.min(answer, getSubString(i, s).length());
        }
        return answer;
    }

    private static String getSubString(int flagCount, String s) {
        StringBuilder sb = new StringBuilder();
        String start = s.substring(0, flagCount);
        int count = 1;
        for (int i = flagCount; ; i+=flagCount) {
            try {
                String substring = s.substring(i, i + flagCount);
                if (start.equals(substring)) {
                    count++;
                } else {
                    sb.append(count == 1 ? start : count + start);
                    start = substring;
                    count = 1;
                }
            } catch (Exception e) {
                sb.append(s.substring(i));
                break;
            }
        }
        if (count != 0) {
            sb.append(count == 1 ? start : count + start);
        }
        System.out.println("sb = " + sb);
        return sb.toString();
    }
}
