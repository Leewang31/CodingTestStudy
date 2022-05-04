package baekjoon.diviedandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class BathRoom {

    private static int[][] arr;
    private static int tileNumber = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int K = Integer.parseInt(reader.readLine());
        int length = (int) Math.pow(2, K);

        if (length * length % 3 != 1) {
            System.out.println("-1");
            return;
        }

        st = new StringTokenizer(reader.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        arr = new int[length][length];
        arr[length - y][x - 1] = -1;

        solve(new Position(0, 0, length), null);

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void solve(Position start, Position blank) {
        if (start.canFill()) {
            if (start.hasNoBlank()) {
                start.fillHasNoBlankTile(blank);
                return;
            }
            start.fillHasBlankTile();
            return;
        }

        int newSize = start.size / 2;
        Position[] newPositions = start.getNewPositions(newSize);
        solve(newPositions[0], new Position(newSize, newSize - 1, newSize));
        solve(newPositions[1], new Position(newSize, newSize, newSize));
        solve(newPositions[2], new Position(newSize - 1, newSize - 1, newSize));
        solve(newPositions[3], new Position(newSize - 1, newSize, newSize));
        solve(newPositions[4], null);
    }

    static class Position {
        int x;
        int y;
        int size;
        HowToFill how;

        public Position(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            how = new HowToFill();
        }

        public Position[] getNewPositions(int newSize) {
            return new Position[]{
                    new Position(this.x + newSize, this.y, newSize),
                    new Position(this.x + newSize, this.y + newSize, newSize),
                    new Position(this.x, this.y, newSize),
                    new Position(this.x, this.y + newSize, newSize),
                    new Position(newSize - 1, newSize - 1, newSize)
            };
        }

        public boolean hasNoBlank() {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (arr[i][j] == -1) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void fillHasNoBlankTile(Position blank) {
            if (blank == null) {
                how.fill(x, y, size, (i, j) -> arr[i][j] == 0);
                return;
            }
            how.fill(x, y, size, (i, j) -> i != blank.x || j != blank.y);
        }

        public void fillHasBlankTile() {
            how.fill(x, y, size, (i, j) -> arr[i][j] != -1);
        }

        public boolean canFill() {
            return size == 2;
        }
    }

    static class HowToFill {
        static void fill(int x, int y, int size, ArrPredicate p) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (p.test(i, j)) {
                        arr[i][j] = tileNumber;
                    }
                }
            }
            tileNumber++;
        }

    }
    interface ArrPredicate {
        boolean test(int i, int j);
    }
}
