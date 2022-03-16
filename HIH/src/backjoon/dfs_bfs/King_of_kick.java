package backjoon.dfs_bfs;
import java.util.Scanner;

public class King_of_kick {
    public static int Three_point=3;
    public static  int One_point=1;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int S[], T[], R[];
        int n;
        int j=0;
        int sub;
        int cnt=0;
        n=sc.nextInt();
        S=new int[n];
        T=new int[n];
        R=new int[n];
        for(int i=0;i<n;i++){
            S[i]=sc.nextInt();
            T[i]=sc.nextInt();
        }

        while(S[j]!=T[j]){
            cnt=0;
            sub=T[j]-S[j];
            System.out.println("sub: "+sub+" s[j]: "+S[j]);
            if(sub>=S[j]){
                sub+=3;
                for(int k=0;k<sub;k++){
                    sub-=1;
                    if(S[j]==sub) {
                        cnt++;
                        System.out.println("cnt : "+cnt);
                    }
                    if(S[j]>sub) {
                        System.out.println("sub: "+sub+" S[j]: "+S[j]);
                        break;}
                }
                cnt+=sub;

            }
            else{
                for(int g=0;g<sub;g++){
                    sub-=1;
                    cnt++;}
            }
            System.out.println(cnt+1);
            if(j==n-1)break;
            S[j]+=sub;
            j++;
        }
    }
}
/*태균이는 지금 태권도 겨루기 중이다. 지금은 상대에게 지고 있지만 지금부터 진심으로 경기하여 빠르게 역전을 노리려 한다.

태균이가 현재 할 수 있는 연속 발차기는 두가지가 있다.

A는 현재 점수만큼 점수를 얻을 수 있는 엄청난 연속 발차기이다. 하지만 상대 역시 3점을 득점하는 위험이 있다.
B는 1점을 얻는 연속 발차기이다.
현재 태균이의 점수 S와 상대의 점수 T가 주어질 때, S와 T가 같아지는 최소 연속 발차기 횟수를 구하는 프로그램을 만드시오.

입력
첫째 줄에 테스트 케이스의 수 C(1 ≤ C ≤ 100)이 주어진다. 둘째 줄부터 C줄에 걸쳐 테스트 케이스별로 현재 점수 S와 T가 공백을 사이에 두고 주어진다. (1 ≤ S < T ≤ 100)

출력
각 줄마다 S와 T가 같아지는 최소 연속 발차기 횟수를 출력한다.*/