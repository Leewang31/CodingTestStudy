package programmers.kakao_intern_2019;

import java.util.Arrays;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Solution(s));
    }

    private static int[] Solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2);
        String text = s.replace("},{", "-");
        String arr[] = text.split("-");
        System.out.println(Arrays.toString(arr));
        int max = arr.length;
        for (int i = 0; i < max; i++) {
            for (int j = 1; j <= max; j++) {
                if (arr[j].length() == j*2-1) {
                    answer[i] = Integer.parseInt(arr[j]);
                    break;
                }
            }
        }
        return answer;
    }
}
//모르겠음
