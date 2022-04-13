package bj.binarySearch;

import java.util.Scanner;

public class JewelBox {
    private static int N;
    private static int M;
    private static int max;
    private static int min = 1;
    private static int[] jewel;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        jewel = new int[M];
        for (int i = 0; i < M; i++) {
            jewel[i] = sc.nextInt();
            max = Math.max(max, jewel[i]);
        }
        result = max;
        binary();
        System.out.println(result);
    }

    private static void binary() {
        while (min<=max) {
            int mid = (max + min) / 2;
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (jewel[i] % mid > 0)
                    cnt++;
                cnt += jewel[i]/mid;
            }
            if(cnt>N)
                min=mid+1;
            else {
                result = Math.min(mid,result);
                max = mid-1;
            }
        }
    }
}
