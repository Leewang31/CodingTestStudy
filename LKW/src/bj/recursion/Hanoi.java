package bj.recursion;

import java.util.Scanner;
//이전코드참조
public class Hanoi {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoical(N,1,3,2);
        System.out.println(cnt);
        if(cnt<20){
            hanoi(N, 1, 3, 2);
        }
    }
    private static void hanoical(int n, int start, int end, int sub) {
        if (n == 1) {
            cnt++;
            return;
        }
        hanoical(n - 1, start, sub, end);
        cnt++;
        hanoical(n-1,sub,end,start);
    }
    private static void hanoi(int n, int start, int end, int sub) {
        if (n == 1) {
            System.out.println(start + " " + end);
            return;
        }
        hanoi(n - 1, start, sub, end);
        System.out.println(start + " " + end);
        hanoi(n-1,sub,end,start);
    }
}