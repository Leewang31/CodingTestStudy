package programmers.summer_winter_coding_2018;
import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(solution(d, budget));
    }

    private static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            budget -=d[i];
            if (budget<0) return answer;
            answer++;
        }
        return d.length;
    }
}
