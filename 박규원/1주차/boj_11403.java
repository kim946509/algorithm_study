import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[n+1][n+1];
        int[][] result = new int[n+1][n+1];

        //그래프 인접 행렬 입력 받기
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j=1;j<=n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =1 ; i<n+1;i++){
            for(int j=1;j<n+1;j++){
                for(int k=1;k<n+1;k++){
                    //만약에 바로 접근할 수 있는 길도 없고, 거쳐가는 길 두개 중 하나라도 0(길이 없음)이라면 갈 수 있는 방법이 없다.
                    if((graph[j][i] == 1 && graph[i][k] == 1) || (graph[j][k] == 1)){
                        graph[j][k]= 1;
                    }
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                int num = graph[i][j];
                if(num>0) System.out.print(num + " ");
                else System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}