package bj.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Router {
    private static int N;
    private static int M;
    private static int result=0;
    private static int[] home;
    private static int[] router;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        home = new int[N];
        router = new int[M];
        for (int i = 0; i < N; i++)
            home[i] = sc.nextInt();
        Arrays.sort(home);
        binary(0, N - 1);
        System.out.println(result);
    }

    private static void binary(int min, int max) {
        router = new int[M];
        router[0] = home[0];
        while (min <= max) {
            int mid = (max + min) / 2;
            int distance = (home[max] + home[min])/2;
           check(distance, 1, 0);
           if(router[2] !=0){
                for (int i = 1; i < M; i++)
                    distance = Math.min(distance, router[i] - router[i - 1]);
                result = Math.max(result,distance);
                min=mid+1;
            }
            else
                max = mid-1;
        }
    }

    private static void check(int distance, int cnt, int num) {
        if (cnt == 3)
            return ;
        for (int i = N - 1; i > num; i--) {
            if (home[i] - home[num] <= distance) {
                router[cnt] = home[i];
                cnt++;
                check(distance, cnt, i);
                break;
            }
        }
    }
}


