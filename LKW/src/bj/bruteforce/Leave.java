package bj.bruteforce;

import java.util.Scanner;

public class Leave {
    static int N;
    static int[] day;
    static int[] profit;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        day = new int[N];
        profit = new int[N];
        for (int i = 0; i < N; i++) {
            day[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }
        maxProfit(0, 0);
        System.out.println(max);
    }

    private static void maxProfit(int x, int nowProfit) {
        for (int i = x; i < N; i++) {
            if (x + day[i] > N)
                return;
            x += day[i];
            nowProfit += profit[i];
            max = max > nowProfit ? max : nowProfit;
            maxProfit(x, nowProfit);
        }
    }
}
