package bj.binarySearch;

import java.util.Scanner;
public class DragonMoney {

    private static int[] arr;
    private static int N;
    private static int M;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int maxAmount = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            maxAmount = Math.max(arr[i], maxAmount);
        }
        binary(maxAmount, (int) Math.pow(10, 9));
        System.out.println(result);
    }

    private static void binary(int min, int max) {
        if (min == max) return;
        int mid = (min + max) / 2;
        int ck = check(mid);
        if (ck == M) {
            result = Math.max(result, mid);
            binary(min, mid-1);
            return;
        }
        if (ck > M) {
            binary(mid+1, max);
            return;
        }
        if (ck < M) {
            binary(min, mid-1);
            return;
        }
    }

    private static int check(int mid) {
        int tmpMoney = mid;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (tmpMoney < arr[i]) {
                tmpMoney = mid;
                cnt++;
            }
            tmpMoney -= arr[i];
        }
        return cnt;
    }
}
//시간 초과