package programmers.kakao_intern_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PuppetDraw {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}
                       , {0, 0, 1, 0, 3}
                       , {0, 2, 5, 0, 1}
                       , {4, 2, 4, 4, 2}
                       , {3, 5, 1, 3, 1}};

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> puppets = new Stack<>();

        List<List<Integer>> boardList = new ArrayList<>(board.length);
        for (int i = 0; i < board.length; i++) {
            List<Integer> childList = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    childList.add(board[j][i]);
                }
            }
            boardList.add(childList);
        }

        for (int move : moves) {
            int puppet;
            try {
                puppet = boardList.get(move - 1).remove(0);
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
            if (isNotSameOrEmpty(puppets, puppet)) {
                puppets.push(puppet);
                continue;
            }
            puppets.pop();
            answer += 2;
        }
        return answer;
    }

    private static boolean isNotSameOrEmpty(Stack<Integer> puppets, int puppet) {
        return puppets.isEmpty() || puppets.peek() != puppet;
    }
}
