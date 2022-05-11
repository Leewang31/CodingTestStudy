package programmers.kakao_intern_2020_winter;

public class RaceTrack {
    private static int straightPay = 100;
    private static int cornerPay = 500;
    private static int MIN = 5000000;

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int answer = 0;
        move(board, 0, 0, 0, 0);
        return MIN;
    }

    private static void move(int[][] board, int row, int col, int straight, int corner) {
        if (!check(board, row, col, straight, corner)) {
            move(board, row - 1, col, straight++, corner);
            move(board, row + 1, col, straight++, corner);
            move(board, row, col - 1, straight, corner++);
            move(board, row, col + 1, straight, corner++);
        }
    }

    private static boolean check(int[][] board, int row, int col, int straight, int corner) {
        if (board[row][col] == 1 || row < 0 || row > 3 || col < 0 || col > 3) {
            return false;
        } else if (row == 3 && col == 3) {
            MIN = Math.min(MIN, (straight * straightPay + corner * cornerPay));
        }
        return true;
    }
}

//제귀 기억이 안나요..
