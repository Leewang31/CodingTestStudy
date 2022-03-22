package backjoon.return_method;
import java.util.Scanner;
/* 본인 생각
* 2차원 배열로 cnt 부터 cnt+2 까지 받아오고
* 그 값을 1차원 배열에 저장하여
* 정렬알고리즘을 통해 정렬 하고
* 그 값들 중 2번째 원소를 따로 반환하여
* 그 값 들만 모아놓은 1차원 배열값의
* 1차원 배열의 두번 쨰 원소만 출력 하려고 했음
* 실패점 :
* 전화로 말했지만 1차원 배열에 내가 생각한 데로 원소가 안들어감
* if문과 i, j의 값들을 수정해보며 개선하려 하였으나 실패
* */
public class Want_prize {
    public static int cnt=0;
    public static int Prize[];
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int table_Array[][]=new int[size][size];
        int t[]=new int[]{9, 3, 24, 12};
        //System.out.println(find_Second_Min(t,3));
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                table_Array[i][j]=sc.nextInt();
            }
        }

        return_Method(table_Array,size);


    }

    public static void return_Method(int[][] Array,int size){
        int[] case_Arr=new int[size];
        //for(int i=0;i<size;i++)case_Arr[i]=' ';
        if(cnt==size) {

            System.out.println(sort(Prize,size));
            return;
        }

        if(cnt ==0) Prize=new int[size];
        Prize[cnt]=0;

        for(int i=cnt;i<cnt+2;i++){
            for(int j=cnt;j<cnt+2;j++){
                try {
                                case_Arr[i+j]=Array[i][j];

                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        for(int i=0;i<size;i++) System.out.println("i: "+i+' '+case_Arr[i]);
        Prize[cnt]=sort(case_Arr,size);

        System.out.println("cnt: "+cnt+"\nsize: "+size);

        cnt+=2;
        return_Method(Array,size);
    }
    public static int Pow(int n, int m){
        int x=n;
        for(int i=0;i<m-1;i++){
            n*=x;
        }
        return n;
    }
    public static int find_Second_Min(int Array[],int size){
        int min=0;
        for(int i=0;i<size;i++){
            try {
                if ( Array[i] < Array[i + 1] && min < Array[i]) min = Array[i];
            } catch (ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
        return min;
    }
    public static int sort(int arr[],int size) {
        int minIndex = 0;
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        //for(int i=0;i<size;i++) System.out.println(arr[i]);
        return arr[1];

    }
}
