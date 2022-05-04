package baekjoon.diviedandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BathRoomLarge {

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

        init(reader, length);
        fillOrDivide(new Position(0, 0, length));
        printTileArray();
    }

    private static void init(BufferedReader reader, int length) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(reader.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        arr = new int[length][length];
        arr[length - y][x - 1] = -1;
    }

    private static void fillOrDivide(Position start) {
        if (start.isNotFill() || start.isFIll()) {
            return;
        }

        if (start.canFill()) {
            start.fillSubTile();
            return;
        }

        Position[] newPositions = start.getNewPositions(start.size/2);
        checkAndFillSubTileHasBlank(newPositions);
        fillLetTile(newPositions);
    }

    private static void printTileArray() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillLetTile(Position[] newPositions) {
        fillOrDivide(newPositions[4]);
        fillOrDivide(newPositions[0]);
        fillOrDivide(newPositions[1]);
        fillOrDivide(newPositions[2]);
        fillOrDivide(newPositions[3]);
    }

    private static void checkAndFillSubTileHasBlank(Position[] newPositions) {
        fillOrDivide(newPositions[0]);
        fillOrDivide(newPositions[1]);
        fillOrDivide(newPositions[2]);
        fillOrDivide(newPositions[3]);
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
                    new Position(this.x + newSize / 2, this.y + newSize / 2, newSize)
            };
        }

        public void fillSubTile() {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = tileNumber;
                    }
                }
            }
            tileNumber++;
        }

        public boolean canFill() {
            return size == 2;
        }

        public boolean isNotFill() {
            return how.check(x, y, size, (i, j) -> arr[i][j] != 0);
        }

        public boolean isFIll() {
            return how.check(x, y, size, (i, j) -> arr[i][j] == 0);
        }
    }

    static class HowToFill {
        static boolean check(int x, int y, int size, ArrPredicate p) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (p.test(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

    interface ArrPredicate {
        boolean test(int i, int j);
    }
}
