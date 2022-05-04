package bj.divide;

import java.util.Scanner;

public class ShowerRoom {
    private static int[][] arr;
    private static int[] color = {1, 2, 4, 5};
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int c = sc.nextInt();
        int r = sc.nextInt();
        int size = (int) Math.pow(2, N);
        arr = new int[size][size];
        arr[r-1][c-1] = -1;
        colorInput(0, 0, size);
        for (int i = size-1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void colorInput(int r, int c, int num) {
        if (num == 2) {
            for (int i = r; i < 2 + r; i++) {
                for (int j = c; j < 2 + c; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = color[cnt];
                    }
                }
            }
            cnt++;
            return;
        }
        check(0, 0, num);
    }

    private static void check(int r, int c, int num) {
        if (drainCheck(0, 0, num) == 1) {
            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    arr[i][j] = 3;
                }
            }
            colorInput(0, 0, 2);
            colorInput(0, 2, 2);
            colorInput(2, 0, 2);
            colorInput(2, 2, 2);
            return;
        }
        if (drainCheck(0, 0, num) == 2) {
            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (i == 1 && j == 2) continue;
                    arr[i][j] = 3;
                }
            }
            colorInput(0, 0, 2);
            colorInput(0, 2, 2);
            colorInput(2, 0, 2);
            colorInput(2, 2, 2);
            return;
        }
        if (drainCheck(0, 0, num) == 3) {
            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (i == 2 && j == 1) continue;
                    arr[i][j] = 3;
                }
            }
            colorInput(0, 0, 2);
            colorInput(0, 2, 2);
            colorInput(2, 0, 2);
            colorInput(2, 2, 2);
            return;
        }
        if (drainCheck(0, 0, num) == 4) {
            for (int i = 1; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (i == 2 && j == 2) continue;
                    arr[i][j] = 3;
                }
            }
            colorInput(0, 0, 2);
            colorInput(0, 2, 2);
            colorInput(2, 0, 2);
            colorInput(2, 2, 2);
            return;
        }
    }

    private static int drainCheck(int r, int c, int num) {
        for (int i = r; i < num + r; i++) {
            for (int j = c; j < num + c; j++) {
                if (arr[i][j] != 0) {
                    if (i < num / 2 + r && j < num / 2 + c) return 1;
                    if (i < num / 2 + r && j >= num / 2 + c) return 2;
                    if (i >= num / 2 + r && j < num / 2 + c) return 3;
                    if (i >= num / 2 + r && j >= num / 2 + c) return 4;
                }
            }
        }
        return -1;
    }
}
