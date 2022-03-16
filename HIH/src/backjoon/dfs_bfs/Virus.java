package backjoon.dfs_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Virus {
    public static boolean dfs(int computer, int start, int[][] matrix, boolean[] visited)
    {
        if(visited[start] == true) /* 방문했다면 탈출 */
            return false;

        visited[start] = true; /* 방문 체크 및 감염된 컴퓨터 개수 카운팅 */
        count++;

        for(int ii = 1 ; ii < computer+1 ; ii++)
        {
            if(matrix[start][ii] == 1) /* 루프를 돌아서 연결되어있다면 바이러스 감염시키러 들어간다 */
            {
                dfs(computer, ii, matrix, visited);
            }
        }

        return true;
    }


    public static int count = 0;
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int computer = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[computer+1][computer+1];
            boolean[] visited = new boolean[computer+1]; /* 컴퓨터 개수 만큼 1차원 배열로 방문했는지 체크하면됨 */

            for(int ii = 0 ; ii < n ; ii++)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                /* 1은 연결되어있다는 의미고 양쪽방향 둘다 연결시켜준다. */
                matrix[x][y] = 1;
                matrix[y][x] = 1;
            }


            /* 1번 컴퓨터 시작 */
            dfs(computer, 1, matrix, visited);

            /* 1을 뺀 이유는 dfs에서 1번 컴퓨터부터 카운트되기때문임(제외시킬려고) */
            System.out.println(count-1);

            br.close();
        }




    }

/*첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.*/