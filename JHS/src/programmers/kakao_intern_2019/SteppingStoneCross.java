package programmers.kakao_intern_2019;

public class SteppingStoneCross {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }

        return getPersonNum(min, max, k, stones);
    }

    public static int getPersonNum(int min, int max, int k, int[] stones) {
        while (min < max) {
            int mid = (min + max) / 2;

            if (canGo(stones, mid, k)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    public static boolean canGo(int[] stones, int mid, int k) {
        int zeroCount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid > 0) {
                zeroCount = 0;
                continue;
            }
            zeroCount++;

            if (zeroCount == k) {
                return false;
            }
        }
        return true;
    }
}
