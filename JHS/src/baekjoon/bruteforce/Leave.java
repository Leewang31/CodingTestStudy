package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leave {

    private static TimeTable[] timeTables;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(reader.readLine());
        timeTables = new TimeTable[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            timeTables[i] = new TimeTable(st.nextToken(), st.nextToken());
        }

        System.out.println(solve(0, 0));
    }

    private static int solve(int startDay, int sum) {
        if (startDay == N) {
            return sum;
        }
        int max = 0;
        if (timeTables[startDay].withInDeadline(startDay)) {
            max = solve(startDay + timeTables[startDay].period, sum + timeTables[startDay].money);
        }
        return Math.max(max, solve(startDay + 1, sum));
    }

    static class TimeTable {
        int period;
        int money;

        public TimeTable(String period, String money) {
            this.period = Integer.parseInt(period);
            this.money = Integer.parseInt(money);
        }

        public boolean withInDeadline(int period) {
            return this.period + period <= N;
        }
    }
}
