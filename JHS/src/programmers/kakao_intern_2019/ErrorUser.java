package programmers.kakao_intern_2019;

import java.util.*;
import java.util.regex.Pattern;

public class ErrorUser {
    private static HashSet<HashSet<String>> result;
    private static Set<Integer> set;
    public static void main(String[] args) {
        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "abc1**"};
//        System.out.println(solution(userId, bannedId));

        System.out.println(solution1(userId, bannedId));
    }

    public static int solution1(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        go(0, user_id, banned_id, 0);

        return set.size();
    }

    public static void go(int index, String[] user_id, String[] banned_id, int bit) {
        if(index == banned_id.length) {
            set.add(bit);
            return;
        }

        String reg = banned_id[index].replace("*", ".");
        for(int i=0; i<user_id.length; ++i) {
            if((((bit>>i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            go(index + 1, user_id, banned_id, (bit | 1<<i));
        }

    }

    public static int solution(String[] userId, String[] bannedId) {
        result = new HashSet<>();
        List<List<String>> bannedUser = new ArrayList<>();
        for (String banId : bannedId) {
            bannedUser.add(getList(banId, userId));
        }
        getResult(bannedUser, new HashSet<>(), 0);
        return result.size();
    }

    private static List<String> getList(String banId, String[] userId) {
        List<String> result = new ArrayList<>();
        for (String id : userId) {
            if (Pattern.matches(banId.replace("*", "."), id)) {
                result.add(id);
            }
        }
        return result;
    }

    private static void getResult(List<List<String>> bannedUser, HashSet<String> bannedUserList, int depth) {
        if (depth == bannedUser.size()) {
            result.add(bannedUserList);
            return;
        }
        for (String id : bannedUser.get(depth)) {
            if (!bannedUserList.contains(id)) {
                bannedUserList.add(id);
                getResult(bannedUser, bannedUserList, depth+1);
                bannedUserList.remove(id);
            }
        }
    }
}
