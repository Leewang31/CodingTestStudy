package programmers;
import java.util.ArrayList;
import java.util.Scanner;
public class Num_game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        int cnt=0;
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            a.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            b.add(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            if(a.get(i)<b.get(i)){
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
