package programmers.kakao_intern_2019;

import java.util.Stack;

public class PuppetDraw {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}
                , {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(Solution(board, moves));

}

    private static int Solution(int[][] board, int[] moves) {
        int answer = 0;
        int currentPop;
        Stack<Integer> stack = new Stack<>();
        stack.push(search(board, moves[0]));
        for (int i = 1; i < moves.length; i++) {
            currentPop = stack.peek();
            int search = search(board, moves[i]);
            if(search == 0){ continue;}
            if (currentPop == search) {
                stack.pop();
                answer++;
                continue;
            } else {
                stack.push(search);
            }
        }
        return answer*2;

    }

    private static int search(int[][] board, int searchNum) {
        int result = 0;
        for(int i =0;i<5;i++){
            result = board[i][searchNum - 1];
            if(result !=0){ board[i][searchNum - 1] = 0; break; }
        }
        return result;
    }
}
