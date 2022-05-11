package programmers;
import java.util.ArrayList;
import java.util.Scanner;
public class Tuple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int max=0;
        String result="";
        ArrayList<String> s=new ArrayList<String>();
        while(true) {
            String tuple = sc.nextLine();
            if (tuple == "-1") break;
            s.add(tuple);
        }
        for(int i=0;i<s.size();i++) {
            for (int j = 0; j < s.get(i).length(); j++) {
                if (!result.contains(String.valueOf(s.get(i).charAt(j)))) {
                    result += s.get(i).split(",");
                }
            }
        }
        System.out.println(result);
    }
}
