package bj.graphsearch;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Friend {

    private static int N;
    private static int M;
    private static int[][] Graph;
    private static boolean [] Visited;

    static class Cnt {
        Cnt(int a) {
            number = a;
        }
        int number;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int max = 1;
        Graph = new int[20][20];
        for(int i=0;i<M;i++){
            int v= sc.nextInt();
            int u= sc.nextInt();
            Graph[v][u] = Graph[u][v] = 1;
        }
        for(int i = 1; i<=N;i++) {
            for(int j=1;j<=N;j++){
                Visited[j]=false;
            }
            max = (dfs(i, N) > max) ? dfs(i, N) : max;
        }
    }

    private static int dfs(int node, int num) {
        Queue<Cnt>q = new LinkedList<>();
        int max = 1;
        q.add(new Cnt(node));
        while(!q.isEmpty()){
            Cnt curr = q.poll();
            for (int i = curr.number; i<=num; i++){
                for(int j=1;j<=num;j++){
                    if(Graph[i][j] == 1 && Visited[i]!=true &&Visited[j]!=false){
                        Visited[i]=true;
                        Visited[j]=true;
                        if(curr.number+1>num) {
                            max+=2;
                            q.add(new Cnt(1));
                        }
                        max+=2;
                        q.add(new Cnt(curr.number+1));
                    }
                }
            }
        }
        return max;
    }
}
