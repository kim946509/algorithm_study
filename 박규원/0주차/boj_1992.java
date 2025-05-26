import java.io.*;
import java.util.*;

class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][n];

        //입력 받기
        for(int i =0; i<n; i++){
            String str = br.readLine();

            for(int j=0;j<n;j++){
                list[i][j] = str.charAt(j)-'0';
            }
        }

        q_tree(0,0,n,list);
    
        System.out.print(sb.toString());

    }

    public static boolean list_result(int i, int j, int size, int[][] list){
        int compare = list[i][j];

        for(int idx = i; idx<i+size;idx++){
            for(int jdx=j;jdx<j+size;jdx++){
                if(list[idx][jdx] != compare) return false;
            }
        }
        return true;
    }

    public static void q_tree(int i, int j, int size, int[][] list){

        if(size == 1){
            if(list[i][j] == 1) sb.append("1");
            else sb.append("0");
            return;
        }

        if(list_result(i, j, size, list)){
            sb.append(list[i][j]);
            return;
        }

        int half = size/2;

        sb.append("(");

        q_tree(i, j, half, list);
        q_tree(i, j+half, half, list);
        q_tree(i+half, j, half, list);
        q_tree(i+half, j+half, half, list);
        
        sb.append(")");
    }
}