package programmers.kakao_blind_2020;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    private static boolean solution(int[][] key, int[][] lock) {
        int[][] key1 = key;
        int[][] key2 = getTurnedKey(key1);
        int[][] key3 = getTurnedKey(key2);
        int[][] key4 = getTurnedKey(key3);

        return isCorrect(key1, lock) || isCorrect(key2, lock) || isCorrect(key3, lock) || isCorrect(key4, lock);
    }

    private static int[][] getTurnedKey(int[][] key) {
        int[][] result = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                result[i][j] = key[key.length - 1 - j][i];
            }
        }
        return result;
    }

    private static boolean isCorrect(int[][] key, int[][] lock) {
        int[][] padding = getPaddingArray(key, lock);
        for (int i = 0; i < padding.length - lock.length + 1; i++) {
            for (int j = 0; j < padding.length - lock.length + 1; j++) {
                if (valid(lock, padding, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] getPaddingArray(int[][] key, int[][] lock) {
        int padSize = lock.length - 1;
        int[][] result = new int[key.length + padSize * 2][key.length + padSize * 2];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                result[padSize +i][padSize+j] = key[i][j];
            }
        }
        return result;
    }

    private static boolean valid(int[][] lock, int[][] padding, int i, int j) {
        for (int k = 0; k < lock.length; k++) {
            for (int l = 0; l < lock.length; l++) {
                if (lock[k][l] + padding[i + k][j + l] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
