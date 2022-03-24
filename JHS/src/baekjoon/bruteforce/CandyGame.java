package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {

    private static String[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        candy = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split("");
            for (int j = 0; j < N; j++) {
                candy[i][j] = line[j];
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                changeCandyPosition(new Position(i, j), new Position(i, j + 1));
                max = Math.max(max, checkMaxCandyCount(N));
                changeCandyPosition(new Position(i, j), new Position(i, j + 1));

                changeCandyPosition(new Position(i, j), new Position(i + 1, j));
                max = Math.max(max, checkMaxCandyCount(N));
                changeCandyPosition(new Position(i, j), new Position(i + 1, j));
            }
        }
        System.out.println(max);
    }

    private static int checkMaxCandyCount(int len) {
        int max = 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = 0; j < len - 1; j++) {
                if (candy[i][j].equals(candy[i][j + 1])) {
                    count++;
                } else
                    count = 1;
                max = Math.max(max, count);
            }
        }

        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = 0; j < len-1; j++) {
                if (candy[j][i].equals(candy[j + 1][i])) {
                    count++;
                } else
                    count = 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private static void changeCandyPosition(Position position, Position position1) {
        try {
            String candy1 = candy[position.x][position.y];
            String candy2 = candy[position1.x][position1.y];

            candy[position.x][position.y] = candy2;
            candy[position1.x][position1.y] = candy1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
