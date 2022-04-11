package bj.binarySearch;

import java.util.Scanner;

public class Lesson {
    private static int N;
    private static int M;
    private static int max;
    private static int min;
    private static int result;
    private static int[] lesson;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lesson = new int[N];
        min = lesson[0];
        for (int i = 0; i < N; i++) {
            lesson[i] = sc.nextInt();
            max += lesson[i];
            min = Math.max(lesson[i], min);
        }
        result = max;
        binary();
        System.out.println(result);
    }

    private static void binary() {
        while (min<=max) {
            int mid = (max + min) / 2;
            int tmp = 0;
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if (tmp + lesson[i] > mid) {
                    cnt++;
                    tmp = lesson[i];
                }
                else
                    tmp+=lesson[i];
            }
            if(cnt>M){
                min=mid+1;
            }
            else{
                result = Math.min(mid,result);
                max=mid-1;
            }
        }
    }
}
