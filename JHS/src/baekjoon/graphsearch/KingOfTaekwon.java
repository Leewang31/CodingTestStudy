package baekjoon.graphsearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//20분
public class KingOfTaekwon {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < C; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());

            int S = Integer.parseInt(stringTokenizer.nextToken());
            int T = Integer.parseInt(stringTokenizer.nextToken());

            Queue<Score> queue = new LinkedList<>();
            queue.offer(new Score(S, T, 0));

            while (!queue.isEmpty()) {
                Score current = queue.poll();
                if (current.isSameScore()) {
                    sb.append(current.kickCount + "\n");
                    queue.clear();
                    break;
                }

                Score kickAScore = current.kickA();
                Score kickBScore = current.kickB();

                if (kickAScore != null) {
                    queue.offer(kickAScore);
                }
                if (kickBScore != null) {
                    queue.offer(kickBScore);
                }
            }
        }
        System.out.println(sb);
    }

    static class Score {
        int myScore;
        int enemyScore;
        int kickCount;
        int nextKick;

        public Score(int myScore, int enemyScore, int kickCount) {
            this.myScore = myScore;
            this.enemyScore = enemyScore;
            this.kickCount = kickCount;
            this.nextKick = kickCount + 1;
        }

        public Score kickA() {
            if (myScore * 2 > enemyScore + 3) {
                return null;
            }
            return new Score(myScore * 2, enemyScore + 3, nextKick);
        }

        public Score kickB() {
            return new Score(myScore + 1, enemyScore, nextKick);
        }

        public boolean isSameScore() {
            return myScore == enemyScore;
        }
    }
}
