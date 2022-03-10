package baekjoon.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jelly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Position[][] board = new Position[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new Position(i, j, scanner.nextInt());
            }
        }

        Queue<Position> visitedState = new LinkedList<>();
        visitedState.add(board[0][0]);

        while (!visitedState.isEmpty()) {
            Position currentPosition = visitedState.poll();

            int x = currentPosition.x;
            int y = currentPosition.y;
            int moveValue = currentPosition.moveValue;

            if (moveValue == -1) {
                System.out.println("HaruHaru");
                return;
            }

            if (moveValue == 0) {
                continue;
            }

            if (x + moveValue < N) {
                visitedState.add(board[x + moveValue][y]);
            }
            if (y + moveValue < N) {
                visitedState.add(board[x][y + moveValue]);
            }
        }
        System.out.println("Hing");
    }

    static class Position {
        int x;
        int y;
        int moveValue;

        public Position(int x, int y, int moveValue) {
            this.x = x;
            this.y = y;
            this.moveValue = moveValue;
        }
    }
}
