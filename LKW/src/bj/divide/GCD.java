package bj.divide;

import java.util.Scanner;

public class GCD {
    private static int[] arrR;
    private static int[] arrL;
    private static int x1 = 0;
    private static int x2 = 0;
    private static int right = 0;
    private static int left = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arrR = new int[N];
        arrL = new int[N];
        for (int i = 0; i < N; i++) {
            arrR[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arrL[i] = arrR[N-i-1];
        }
        if (N == 1) {
            System.out.println(arrR[0]);
            return;
        }
        rightCheck(0, N);
        leftCheck(0, N);
//        System.out.println("right : "+right);
//        System.out.println("left : "+left);
        System.out.println(Math.max(right,left));
    }

    private static void rightCheck(int pt, int num) {
        if (num / 2 == 1) {
            for (int i = pt; i < pt + num; i++) {
                right += arrR[i];
            }
            return;
        }
        right += gcdCk(pt, num / 2 - 1);
        rightCheck(num / 2, num - num / 2);
    }
    private static void leftCheck(int pt, int num) {
        if (num / 2 == 1) {
            for (int i = pt; i < pt + num; i++) {
                left += arrL[i];
            }
            return;
        }
        left += gcdCkL(pt, num / 2 - 1);
        leftCheck(num / 2, num - num / 2);
    }

    private static int gcdCkL(int a, int b) {
        if (b == 1) {
            x2 = gcd(arrL[a], arrL[b]);
            return x2;
        } else gcdCkL(a, b - 1);
        x2 = gcd(x2, arrR[b]);
        return x2;
    }
    private static int gcdCk(int a, int b) {
        if (b == 1) {
            x1 = gcd(arrR[a], arrR[b]);
            return x1;
        } else gcdCk(a, b - 1);
        x1 = gcd(x1, arrR[b]);
        return x1;
    }

    private static int gcd(int r1, int r2) {
        if (r2 == 0)
            return r1;
        return gcd(r2, r1 % r2);
    }
}

