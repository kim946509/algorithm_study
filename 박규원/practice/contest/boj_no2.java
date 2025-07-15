import java.util.*;
import java.io.*;

class Main{
public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int[] dx = {0,0,-1,1}; //상하좌우
        int[] dy = {-1,1,0,0}; //상하좌우 

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] list = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<4;k++){
                    if(i+dy[k]>=1 && i+dy[k]<=n && j+dx[k]>=1 && j+dx[k]<=m){
                        arr.add(list[i+dy[k]][j+dx[k]]); 
                    }
                }
                
            }
        }
    }
}
