package bj.bruteforce;

import java.util.Scanner;

public class Permutation {
    static int N;
    static int[] arr;
    static int[] result;
    static boolean [] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
            visited[i] = false;
        for (int i = 0; i < N; i++)
            arr[i] = i+1;
        result = new int[N];
        getResult(0);
    }

    private static void getResult(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]!=true){
                result[cnt] = arr[i];
                visited[i]=true;
                getResult(cnt + 1);
                visited[i]=false;
            }
        }
    }
}