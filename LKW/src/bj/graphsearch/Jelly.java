package bj.graphsearch;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jelly {
    static int N;
    static int[][] board;

    static class Point {
        Point(int r, int c) {
            row = r;
            col = c;
        }

        int col;
        int row;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        bfs(0, 0);
    }

    public static void bfs(int r, int c) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(r, c));

        while (!Q.isEmpty()) {
            Point curr = Q.poll();
            int value = board[curr.row][curr.col];

            if (value == -1) {
                System.out.println("HaruHaru");
                return;
            }

            int right = curr.row + value;
            int bottom = curr.col + value;
            if (right < N)
                Q.add(new Point(right, curr.col));
            if (bottom < N)
                Q.add(new Point(curr.row, bottom));
        }
        System.out.println("Hing");
    }
}
