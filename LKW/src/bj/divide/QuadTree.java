package bj.divide;

import java.util.Scanner;

public class QuadTree {
    private static int N;
    private static char[][] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        color = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                color[i][j] = str.charAt(j);
            }
        }

        search(0, 0, N);
    }

    private static void search(int y, int x, int num) {
        if(num == 1){
            System.out.print(color[y][x]);
            return;
        }
        for (int i = y; i < num + y; i++) {
            for (int j = x; j < num + x; j++) {
                if (color[y][x] != color[i][j]) {
                    division(y, x, num);
                    return;
                }
            }
        }
        System.out.print(color[y][x]);
    }

    private static void division(int y, int x, int num) {
        System.out.print("(");
        int numNew = num / 2;
        search(y, x, numNew);
        search(y, x + numNew, numNew);
        search(y + numNew, x, numNew);
        search(y + numNew, x + numNew, numNew);
        System.out.print(")");
        return;
    }
}
