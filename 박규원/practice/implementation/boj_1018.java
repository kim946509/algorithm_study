package 박규원.practice.implementation;
import java.io.*;
import java.util.*;

class Main {
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] rect = new char[n][m];

        //보드 입력받기
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                rect[i][j] = str.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int idx = 0; idx<=n-8; idx++){
            for(int jdx=0;jdx<=m-8; jdx++){
                int min_value = find_min(idx,jdx,rect);
                if(min > min_value){
                    min = min_value;
                }
            }
        }

        System.out.println(min);
    }

    public static int find_min(int idx, int jdx, char[][] arr){
        int count_b=0, count_w=0;
        char char_b, char_w;
        
        for(int i=idx;i<idx+8;i++){
            for(int j=jdx;j<jdx+8;j++){
                char_b = ((i+j)%2==0) ? 'B' : 'W';
                char_w = ((i+j)%2==0) ? 'W' : 'B';

                if(arr[i][j] != char_b) count_b++;
                if(arr[i][j] != char_w) count_w++;
            }
        }

        return Math.min(count_b, count_w);
    }

}