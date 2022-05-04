package backjoon.programmers;
import java.util.ArrayList;
import java.util.Scanner;
public class Skill_tree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> skill_Trees=new ArrayList<String>();
        String skill_Tree=new String();
        int i=0;
        skill_Tree=sc.nextLine();

        while(true){
            skill_Trees.add(sc.nextLine());

            if(skill_Trees.get(i)=="end") break;

            System.out.println("i= "+i);
            System.out.println("ㄴ"+ i+"번째 : "+skill_Trees.get(i));
            i++;
        }
        solution(skill_Trees,skill_Tree);


    }
    public static void solution(ArrayList<String> x, String y){
        ArrayList<String> tmp;
        int cnt=0;
        for(int i=0;i<x.size();i++){
            for(int j=0;j<y.length();j++){
                if(x.get(i).charAt(i)==y.charAt(j)) cnt++;
            }
        }
        System.out.println(cnt);
    }
/*
* 스트링들 끼리 위치를 비교해야함
* 스플릿 메소드 사용 할 것것
* */
}
