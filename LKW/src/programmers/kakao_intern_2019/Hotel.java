package programmers.kakao_intern_2019;

public class Hotel {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        Solution(k, room_number);
    }

    private static long[] Solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        boolean room_book[] = new boolean[(int) k + 1];
        for (int i = 0; i < room_number.length; i++) {
            int num = (int) room_number[i];
            if (!room_book[num]) {
                room_book[num] = true;
                answer[i] = num;
            } else {
                for (int j = num + 1; j < k; j++) {
                    if (!room_book[j]){
                        room_book[j] = true;
                        answer[i] = j;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

//모르겠음
