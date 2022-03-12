package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1번 친구부터 마지막 번호까지 순차적으로 실행
 *
 * 조건 1) 호출된 친구가 무대 위에 올라가지 않았다면 자신의 친한 친구와 함께 무대 위로 올라간다
 *   --> 친한 친구가 이미 무대 위에 올라간 상태면 같이 올라 갈 수 없기 때문에 다음 친구를 확인한다
 * 조건 2) 친한 친구가 없다면 일단 무대 위에 올라갈 수 없기 때문에 0을 반환한다
 * 조건 3) 호출된 친구가 이미 무대 위에 올라간 상태
 *   --> 다음 번호의 친구를 호출하여 1번부터 다시 실행
 *   --> 이때 아직 다음 번호 친구가 누군가와 같이 올라가는지는 모르기 때문에 Count 증가시키지 않는다
 * 조건 4) 마지막 번호 친구까지 실행이 완료되면 종료
 */
public class FriendPalindrome {
    static int N, M;
    private static Relation[] relations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relations = new Relation[N + 1];
        for (int i = 0; i <= N; i++) {
            relations[i] = new Relation(i);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int myNum = Integer.parseInt(st.nextToken());
            int friendNum = Integer.parseInt(st.nextToken());
            relations[Math.min(myNum, friendNum)].friendNum.add(Math.max(myNum, friendNum));
        }

        int result = solve(relations[1], 0) * 2;
        System.out.println(result == N ? result : result + 1);
    }

    static int solve(Relation relation, int count) {
        // 조건 4
        if (relation.myNum == N) {
            return count;
        }
        // 조건 3
        if (relation.attend) {
            return solve(relations[relation.myNum + 1], count);
        }

        int result = 0;
        // 조건 1 & 조건 2
        for (Integer friendNum : relation.friendNum) {
            // 조건 1-1
            if (relations[friendNum].attend) {
                continue;
            }
            relations[friendNum].attend = true;
            result = Math.max(result, solve(relations[relation.myNum+1], count + 1));
            relations[friendNum].attend = false;
        }
        return Math.max(result, solve(relations[relation.myNum+1], count));
    }

    static class Relation {
        int myNum;
        boolean attend;
        List<Integer> friendNum = new ArrayList<>();

        public Relation(int myNum) {
            this.myNum = myNum;
            attend = false;
        }

        @Override
        public String toString() {
            return "Relation{" +
                    "myNum=" + myNum +
                    ", attend=" + attend +
                    ", friendNum=" + friendNum +
                    '}';
        }
    }
}