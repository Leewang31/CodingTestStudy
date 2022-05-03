package programmers.kakao_intern_2019;

import java.util.HashMap;
import java.util.Map;

public class HotelRoomAssign {
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};

        long[] solution = solution(k, room_number);
        for (long l : solution) {
            System.out.print(l + " ");
        }
    }

    private static long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = getEmptyRoom(room_number[i]);
        }

        return answer;
        /*HashMap<Long, Boolean> roomMap = new HashMap<>();
        for (long i = 0; i < k; i++) {
            roomMap.put(i + 1, true);
        }

        for (int i = 0; i < room_number.length; i++) {
            long key = room_number[i];
            if (roomMap.get(key)) {
                answer[i] = key;
                roomMap.put(key, false);
                continue;
            }

            while (true) {
                if (roomMap.get(++key)) {
                    answer[i] = key;
                    roomMap.put(key, false);
                    break;
                }
            }
        }
        return answer;*/
    }

    private static long getEmptyRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long emptyRoom = getEmptyRoom(map.get(room));
        map.put(room, map.get(emptyRoom));
        return emptyRoom;
    }
}
