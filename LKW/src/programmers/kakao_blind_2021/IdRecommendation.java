package programmers.kakao_blind_2021;

import sun.invoke.empty.Empty;

import java.util.ArrayList;

/*      1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/
public class IdRecommendation {
    public static void main(String[] args) {
        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";
//        System.out.println(solution(new_id1));
//        System.out.println(solution(new_id2));
//        System.out.println(solution(new_id3));
//        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));

    }

    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String answer = "";
        ArrayList<Character> word = new ArrayList<>();

        for (int i = 0; i < new_id.length(); i++) {
            word.add(new_id.charAt(i));
        }

        if (word.isEmpty()) {
            return EmptyCheck(word);
        }

        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).equals('-') || word.get(i).equals('_') || word.get(i).equals('.')) {
                continue;
            } else if (Integer.valueOf(word.get(i)) >= Integer.valueOf('a') &&
                    Integer.valueOf('z') >= Integer.valueOf(word.get(i))) {
                continue;
            } else if (Integer.valueOf(word.get(i)) >= Integer.valueOf('0') &&
                    Integer.valueOf('9') >= Integer.valueOf(word.get(i))) {
                continue;
            } else {
                word.remove(i);
                i--;
            }
        }
        if (word.isEmpty()) {
            return EmptyCheck(word);
        }

        for (int i = 0; i < word.size() - 1; i++) {
            if (word.get(i).equals('.') && word.get(i + 1).equals('.')) {
                word.remove(i);
                --i;
            }
        }
        if (word.isEmpty()) {
            return EmptyCheck(word);
        }

        while (true) {
            if (word.isEmpty()) {
                return EmptyCheck(word);
            }
            else if (word.get(0).equals('.')) {
                word.remove(0);
                continue;
            } else if (word.get(word.size() - 1).equals('.')) {
                word.remove(word.size() - 1);
                continue;
            } else {
                break;
            }
        }

        while (word.size() > 15) {
            word.remove(word.size() - 1);
        }
        while (true) {
            if (word.isEmpty()) {
                return EmptyCheck(word);
            }
            else if (word.get(0).equals('.')) {
                word.remove(0);
                continue;
            } else if (word.get(word.size() - 1).equals('.')) {
                word.remove(word.size() - 1);
                continue;
            } else {
                break;
            }
        }

        while (word.size()<3){
            word.add(word.get(word.size()-1));
        }

        for (int i = 0; i < word.size(); i++) {
            answer += word.get(i);
        }
        return answer;
    }

    private static String EmptyCheck(ArrayList<Character> word) {
        String answer = "";
            word.add('a');
            while (word.size()<3){
                word.add(word.get(word.size()-1));
            }
            for (int i = 0; i < word.size(); i++) {
                answer += word.get(i);
            }
            return answer;
    }
}
