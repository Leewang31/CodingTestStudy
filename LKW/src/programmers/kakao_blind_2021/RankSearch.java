package programmers.kakao_blind_2021;


import java.util.ArrayList;
import java.util.Arrays;

public class RankSearch {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        int arr[] = solution(info, query);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[][] newInfo = new String[info.length][4];
        for (int i = 0; i < info.length; i++) {
            newInfo[i] = info[i].split(" ");
        }
        for (int i = 0; i < query.length; i++) {
            answer[i] = result(newInfo, query[i]);
        }
        return answer;
    }

    public static int result(String[][] newInfo, String query) {
        query = query.replace("and ", "");
        String[] newQuery = query.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < newQuery.length; i++) {
            arr.add(newQuery[i]);
        }
        for (int i = 0; i < newInfo.length; i++) {
            for (int j = 0; j < newQuery.length; j++) {
                if (newQuery[j].equals("-")) {
                    continue;
                } else if (j == 4 && Integer.parseInt(newInfo[i][j]) >= Integer.parseInt(newQuery[j])) {
                    cnt++;
                } else if (newInfo[i][j].equals(newQuery[j])) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}
//효율실패