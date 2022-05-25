package programmers.kakao_blind_2020;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key1, int[][] lock) {
        int key2[][] = getKey(key1);
        int key3[][] = getKey(key2);
        int key4[][] = getKey(key3);
        return(isTrue(key1,lock)||isTrue(key2,lock)||isTrue(key3,lock)||isTrue(key4,lock));
    }
    private static int[][] getKey(int[][] key) {
        //회전단계
        int returnKey[][] = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                returnKey[j][key.length-1-i] = key[i][j];
            }
        }
        return returnKey;
    }

    private static boolean isTrue(int[][] key, int[][] lock) {
        //key를 이동하는 단계
        int newLock[][] = new int[key.length * 2 + lock.length][key.length * 2 + lock.length];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                newLock[i + key.length][j + key.length] = lock[i][j];
            }
        }
        for (int i = 0; i < key.length + lock.length; i++) {
            for (int j = 0; j < key.length + lock.length; j++) {
                if (moveCheck(key, newLock, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean moveCheck(int[][] key, int[][] newLock, int x, int y) {
        //key와 lock의 합이 0이 아닌 지 확인
        int newKey[][] = new int[newLock.length][newLock.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newKey[i + x][j + y] = key[i][j];
            }
        }
        int checkSize = newLock.length - key.length * 2;
        for (int i = checkSize; i < checkSize * 2; i++) {
            for (int j = checkSize; j < checkSize * 2; j++) {
                if (newLock[i][j] + newKey[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}