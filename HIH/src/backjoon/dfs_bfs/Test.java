package backjoon.dfs_bfs;
import java.util.Scanner;
public class Test {


        public static void main(String[] args) {
            Scanner sc = new Scanner (System.in);
            int n;
            n=sc.nextInt();
            for(int i=1;i<n;i++)
                for(int j=2;j<i;j++){
                    if(i%j==0&&i/j==0) System.out.print(i+" ");
                }
            }

    }
    /*
    * 1과 자기 자신을 제와하고 약수를 가지지 않아야함
    * 나누어 떨어지면 안됨
    * */

