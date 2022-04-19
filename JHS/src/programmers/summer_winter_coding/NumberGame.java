package programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberGame {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length; i++) {
            if (A[answer] < B[i]) {
                answer++;
            }
        }
        return answer;
    }
}
