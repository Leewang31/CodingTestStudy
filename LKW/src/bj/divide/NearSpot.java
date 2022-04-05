package bj.divide;

import java.util.Scanner;

public class NearSpot {
    private static int[][] arr;
    private static int min;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N == 1) {
            return;
        }
        arr = new int[N][2];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2; j++)
                arr[i][j] = sc.nextInt();
        min = (int)distance(0, 1);
        distanceMin();
        System.out.println(min);
    }


    private static double distance(int num1, int num2) {
        return Math.abs(Math.pow(arr[num1][0]-arr[num2][0],2) + Math.pow(arr[num1][1]-arr[num2][1],2));
    }

    private static void distanceMin() {
        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (j <= i) continue;
                min = Math.min(min, (int) distance(i, j));
            }
        }
    }
}
