package bj.recursion;

import java.util.Scanner;

public class PaperCut {
    static int[][] arr;
    static int minusN;
    static int zeroN;
    static int plusN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt( );
        arr = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                arr[i][j] = sc.nextInt();
        check(0, 0, size);
        System.out.println(minusN);
        System.out.println(zeroN);
        System.out.println(plusN);
    }

    private static void check(int y, int x, int size) {
        if (size == 1) {
            {
                if (arr[y][x] == -1)
                    minusN++;
                if (arr[y][x] == 0)
                    zeroN++;
                if (arr[y][x] == 1)
                    plusN++;
            }
            return;
        }
        int color = arr[y][x];
        try {
            for (int i = y; i < size + y; i++)
                for (int j = x; j < size + x; j++) {
                    if (arr[i][j] != color)
                        throw new Exception();
                }
            if (arr[y][x] == -1)
                minusN++;
            if (arr[y][x] == 0)
                zeroN++;
            if (arr[y][x] == 1)
                plusN++;
        } catch (Exception e) {
            cut(y, x, size);
        }

    }

    private static void cut(int y, int x, int size) {
        int size3 = size / 3;
        int size6 = size3 * 2;
        check(y, x, size3);
        check(y, x + size3, size3);
        check(y, x + size6, size3);
        check(y + size3, x, size3);
        check(y + size3, x + size3, size3);
        check(y + size3, x + size6, size3);
        check(y + size6, x, size3);
        check(y + size6, x + size3, size3);
        check(y + size6, x + size6, size3);
    }
}