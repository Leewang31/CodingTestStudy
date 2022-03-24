package baekjoon.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FloorDecoration {
    static Position[][] decorator;
    static int Row;
    static int Col;

    public static void main(String[] args) {
        int resultCount = 0;
        Scanner scanner = new Scanner(System.in);

        Row = scanner.nextInt();
        Col = scanner.nextInt();
        decorator = new Position[Row][Col];

        for (int i = 0; i < Row; i++) {
            String line = scanner.next();
            for (int j = 0; j < Col; j++) {
                decorator[i][j] = new Position(i,j,String.valueOf(line.charAt(j)));
            }
        }

        for (int i = 0 ; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                if (!decorator[i][j].isSamePattern("X")) {
                    resultCount++;
                    solve(i, j);
                }
            }
        }
        System.out.println(resultCount);
    }

    private static void solve(int row, int col) {
        Queue<Position> queue = new LinkedList<>();
        String currentPattern = decorator[row][col].pattern;
        decorator[row][col].pattern = "X";

        queue.offer(new Position(row, col, currentPattern));

        int[] moveRow = {-1, 1, 0, 0};
        int[] moveCol = {0, 0, -1, 1};
        int index = currentPattern.equals("-") ? 2 : 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            for (int i = index; i < index + 2; i++) {
                int nextRow = current.row + moveRow[i];
                int nextCol = current.col + moveCol[i];

                Position nextPosition;
                try {
                    nextPosition = new Position(nextRow, nextCol, decorator[nextRow][nextCol].pattern);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }

                if (nextPosition.isSamePattern(currentPattern)) {
                    decorator[nextRow][nextCol].pattern = "X";
                    queue.offer(nextPosition);
                }
            }
        }
    }

    static class Position {
        int row;
        int col;
        String pattern;

        public Position(int row, int col, String pattern) {
            this.row = row;
            this.col = col;
            this.pattern = pattern;
        }

        public boolean isSamePattern(String pattern) {
            return this.pattern.equals(pattern);
        }
    }
}
