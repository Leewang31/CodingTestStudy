package bj.graphsearch;

import java.util.Scanner;

public class Virus {
    static int Com, Line;
    static int Max = 10;
    static int [][] Graph = new int[Max][Max];
    static boolean [] Check = new boolean[Max];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Com = sc.nextInt();
        Line = sc.nextInt();
        for(int i = 0; i< Line; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                Graph[u][v]=Graph[v][u]=1;
            }
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int node) {
        Check[node] = true;
        for(int next = 0; next<Com;next++){
            if(!Check[next] && Graph[node][next]!=0)
            {
                cnt++;
                dfs(next);
            }
        }
    }
}
