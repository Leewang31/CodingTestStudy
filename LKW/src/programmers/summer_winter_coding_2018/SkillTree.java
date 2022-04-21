package programmers.summer_winter_coding_2018;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }

    private static int solution(String skill, String[] skill_trees) {
        /*char[] word;
        word = new char[skill.length()];
        for (int i = 0; i < skill.length(); i++) {
            word[i] = skill.charAt(i);
        }*/

        char[] word = skill.toCharArray();
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            boolean ck = false;
            for (int j = 0; j < skill.length(); j++) {
                if (skill_trees[i].charAt(j) == word[j])
                    ck = true;
            }
            if (ck == false) {
                answer++;
                cnt =0;
                continue;
            }
            if (skill_trees[i].charAt(0) == word[cnt]){
                answer++;
                cnt++;
            }
            else{
                cnt =0;
            }

        }
        return answer;
    }
}