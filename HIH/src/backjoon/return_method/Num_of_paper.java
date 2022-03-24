package backjoon.return_method;
import java.util.Scanner;
/*
* 본인 생각
* 2차원 배열로 받고
* sum의 합이 이러할 경우 조건에  맞게 cnt를 각각 증가시키고
* 9개가 아닌 건 원소별로 cnt 늘릴 생각 했음
* 실패점
* sum에서 각 테이블 합이 0이 되는 경우를 인식을 못하는 거 같음
* if문 조건부에서 인접 원소가 다를 경우에만 sum이 다르게 동작되길 바랬음
* 그리고 i와 j가 cnt+3 부분에서 범위가 초과될 수도 있기 때문에 ij 가 cnt+3보다 작동할 수 있도록
* 수정하였지만 실패
* */

public class Num_of_paper {
    public static int cnt=0;
    public static int zero_Cnt=0;
    public static int mone_Cnt=0;
    public static int one_Cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size;
        int[][] paper_Array;

        size=sc.nextInt();
        paper_Array=new int[size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                paper_Array[i][j]=sc.nextInt();
            }
        }
        return_Method(paper_Array,size);
        System.out.println(mone_Cnt);
        System.out.println(zero_Cnt);
        System.out.println(one_Cnt);

    }
    public static void return_Method(int Array[][],int size){
        int[][] cnt_array=new int[9][9];
        int sum=0;
        //int n=cnt;
        if(size*3==cnt) {
            return;
        }

        for(int i=cnt;i<cnt+3;i++){
            for(int j=cnt;j<cnt+3;j++){
                try{
                    cnt_array[i][j]=Array[i][j];
                    sum+=cnt_array[i][j];
                    if(sum==0&&cnt_array[i][j]==cnt_array[i+1][j]&&cnt_array[i][j]==cnt_array[i][j+1]&&cnt_array[i][j]
                            ==cnt_array[i+1][j+1]&&i<cnt&&j<cnt) zero_Cnt++;
                    else if(sum==9&&i<cnt+3&&j<cnt+3)one_Cnt++;
                    else if(sum==-9&&i<cnt+3&&j<cnt+3)mone_Cnt++;
                    else if(cnt_array[i][j]==0)zero_Cnt++;
                    else if(cnt_array[i][j]==1)one_Cnt++;
                    else if(cnt_array[i][j]==-1)mone_Cnt++;
            }catch (ArrayIndexOutOfBoundsException e){
                continue;
        }}
        }

        cnt+=3;
        return_Method(Array,size);
    }
}
/*종료 조건
* 9개로 전부 나눠야함
* */