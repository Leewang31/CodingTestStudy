package programmers.kakao_blind_2020;

public class StringCompression {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int minNum = s.length();
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            minNum = Math.min(minNum, stringCut(s, i));
        }
        return minNum;
    }

    private static int stringCut(String s, int num) {
        String count = "";
        int temp = 1;
        for (int i = 0; ; i += num) {
            try {
                if (s.substring(i, i + num).equals(s.substring(i + num, i + num * 2))) {
                    temp++;
                } else {
                    if (temp != 1) {
                        count += String.valueOf(temp);
                        temp = 1;
                    }
                    for (int j = 0; j < num; j++) {
                        count += "@";
                    }
                }
            } catch (Exception e) {
                if (temp != 1) {
                    count += String.valueOf(temp);
                }
                for (int j = 0; j < s.length() % num + num; j++) {
                    count += "@";
                }
                break;
            }
        }
        return count.length();
    }
}