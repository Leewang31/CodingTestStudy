package programmers.kakao_intern_2019;

import java.util.Arrays;

public class Stepping {
    public static void main(String[] args) {
        int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(Solution(stones,k));
    }

    private static int Solution(int[] stones, int k) {
        int answer = 0;
        int max =0;
        for (int a : stones)
            max = Math.max(max,a);
        while( answer <= max ){
            int tmp = 0;
            for(int i =0 ; i<stones.length;i++){
                if(stones[i] == 0) {
                    tmp++;
                    if( tmp == k ) {
                        return answer;
                    }
                }
                else { tmp = 0; }
            }
            answer ++;
            for(int i =0 ; i<stones.length;i++){
                if(stones[i] == 0) { continue; }
                stones[i] -= 1;
            }
        }
        return answer;
    }
}
//효율성 실패