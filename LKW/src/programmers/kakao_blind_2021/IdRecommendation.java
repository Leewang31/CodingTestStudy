package programmers.kakao_blind_2021;

import java.util.ArrayList;

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

        /*if (word.isEmpty()) {
            return EmptyCheck(word);
        }*/

        try {


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
        /*if (word.isEmpty()) {
            return EmptyCheck(word);
        }*/

            for (int i = 0; i < word.size() - 1; i++) {
                if (word.get(i).equals('.') && word.get(i + 1).equals('.')) {
                    word.remove(i);
                    --i;
                }
            }
/*        if (word.isEmpty()) {
            return EmptyCheck(word);
        }*/

            while (true) {
                if (word.isEmpty()) {
                    return EmptyCheck(word);
                } else if (word.get(0).equals('.')) {
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
                } else if (word.get(0).equals('.')) {
                    word.remove(0);
                    continue;
                } else if (word.get(word.size() - 1).equals('.')) {
                    word.remove(word.size() - 1);
                    continue;
                } else {
                    break;
                }
            }

            while (word.size() < 3) {
                word.add(word.get(word.size() - 1));
            }

        } catch (IndexOutOfBoundsException e) {
            return EmptyCheck(word);
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
