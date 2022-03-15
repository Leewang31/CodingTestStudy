package bj.graphsearch;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Taekwon {

    private static int N;
    private static int Max = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int [][]Vs = new int[Max][Max];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                Vs[i][j] = sc.nextInt();
            }
        }for(int i=0;i<N;i++){
            taekwon(Vs[i][0],Vs[i][1],0);
        }

    }

    static class Score {
        int myscore;
        int yourscore;
        int cnt;

        Score(int m, int y, int c) {
            myscore = m;
            yourscore = y;
            cnt = c;
        }

    }

    private static void taekwon(int myScore, int yourScore, int cnt) {
        int Max = yourScore - myScore;
        int min = 100;
        Queue<Score> q = new LinkedList<>();
        q.add(new Score(myScore, yourScore, cnt));
        while (!q.isEmpty()) {
            Score curr = q.poll();
            if (curr.myscore > curr.yourscore) {
                curr.cnt = 100;
                continue;
            }
            if (curr.myscore == curr.yourscore) {
                min = min > curr.cnt ? curr.cnt : min;
                continue;
            }
            if (curr.myscore < curr.yourscore) {
                q.add(new Score(curr.myscore * 2, curr.yourscore + 3, curr.cnt + 1));
                q.add(new Score(curr.myscore + 1, curr.yourscore, curr.cnt + 1));
            }
        }
        System.out.println(min);
    }
}

