package programmers.summer_winter_coding_2018;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        int [] A = {5,1,3,7};
        int [] B = {2,2,6,8};
        System.out.println(solution(A,B));
    }

    private static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0 ;
        for(int i = 0 ; i< A.length;i++){
            if(cnt == B.length){
                return answer;
            }
            while(A[i]>B[cnt]) {
                if(cnt == B.length-1 ){
                    return answer;
                }
                System.out.println("1. cnt : "+cnt);
                cnt++;
            }
            System.out.println("2. cnt : "+cnt);
            cnt++;
            answer++;
        }
        return answer;
    }
}