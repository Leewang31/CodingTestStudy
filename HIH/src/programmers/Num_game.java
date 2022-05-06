package programmers;

public class Num_game {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int cnt = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]<B[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
