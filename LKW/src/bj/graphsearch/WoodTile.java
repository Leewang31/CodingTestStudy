package bj.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WoodTile {
    static int N, M;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point {
        Point(int r, int c) {
            row = r;
            col = c;
        }
        int col;
        int row;
    }
    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        String[] A = new String[M];
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = sc.next();
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                board[i][j] = A[i].charAt(j);
            }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '-' || board[i][j] == '|') {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(int r, int c) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(r, c));
        int idx = board[r][c] == '-'? 2 : 0;
        char check = board[r][c];
        board[r][c] ='X';
        while (!Q.isEmpty()) {
            Point curr = Q.poll();
            for (int i=idx;i<idx+2;i++){
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 'X') continue;
                if(board[nr][nc] == check)
                {
                    board[nr][nc] = 'X';
                    Q.add(new Point(nr,nc));
                }
            }
        }
    }
}

