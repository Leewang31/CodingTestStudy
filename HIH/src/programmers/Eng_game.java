package programmers;
import java.util.Arrays;
import java.util.Scanner;
public class Eng_game {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int i=0;
        int who;
        String s[]=new String[sc.nextInt()];

       while(true){
           s[i]=sc.nextLine();
           if(find(s,s[i])&&i>0){
               who=i%n;
               System.out.println("["+(i%n+1)+",");
               break;
           }
           i++;
       }


    }
    public static boolean find(String s[],String index){
        for(int i=0;i<s.length-1;i++){
            if(s[i]==index) {
                return true;


            }
            else return false;
        }
        return false;
    }
}
