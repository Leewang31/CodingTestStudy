package backjoon.return_method;
import java.util.Scanner;
/*
* 본인 생각
* 재귀 문제 보단 탐색 문제라고 판단
* 일단 재귀파트니 재귀를 하며 분할 후
* if문의 조건 별로 cnt 증가시켜 출력할 생각 이였음
* 실패점 :
* 이유를 모르겠으나 입력문에서 오류가 나옴
* 이게 예외처리고 뭐고 안먹힘
* ide를 껏다키고 클래스를 다시 만들어 보았지만 실패
* 사실 알고리즘 자체도 틀린 거 같은데
* 컴파일을 못해보니 문제점을 알 수 없었음
* */
public class Make_ColorPaper {
    public static int n=0;
    public static int m=0;
    public static int n_cnt =0;
    public static int m_cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size;
        int [][]paper_Array;
        size=sc.nextInt();
        paper_Array=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                paper_Array[i][j]=sc.nextInt();
                System.out.print(paper_Array[i][j]+' ');
            }
            System.out.print("\n");
        }

        devide_Method(paper_Array,size);

    }
    public static void devide_Method(int Array[][],int size){
        if(size/2!=1){
            size/=2;
            devide_Method(Array,size);

        }

        else if(size/2==1){// 마지막 조건이 되면 탐색
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(Array[i][j]==Array[i+1][j]&&Array[i][j]==0) {
                        n_cnt++;
                        if(n_cnt %size==0)n++;
                    }//n
                    if(Array[i][j]==Array[i][j+1]&&Array[i][j]==0) {
                        n_cnt++;
                        if(n_cnt %size==0)n++;
                    }
                    if(Array[i][j]==Array[i+1][j]&&Array[i][j]==1) {
                        m_cnt++;
                        if(n_cnt %size==0)m++;
                    }
                    if(Array[i][j]==Array[i+1][j]&&Array[i][j]==1) {
                        m_cnt++;
                        if(n_cnt %size==0)m++;
                    }

            }
                System.out.println(n);
                System.out.println(m);
                if(size/2==1) return;//종료조건
        }
        }
    }
}
//행과 열이 같을 조건
//인접한 원소들이 같은 값이면 증가
//[i+1][j]==
