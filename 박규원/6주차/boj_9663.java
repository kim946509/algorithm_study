import java.io.*;
import java.util.*;

class Main {
    public static int[] cols;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cols = new int[n+1];

        nQueen(n, 1);

        System.out.println(count);
    }

    public static void nQueen(int n, int row){
        //정답 리스트에 좌표 배열이 모두 찼다면 (n에 도달했다면 함수 종료)
        if(row > n){
            count++;
            return;
        }

        for(int i = 1; i<=n; i++){
            if(check_nQueen_rule(i,row)){
                cols[row] = i;
                nQueen(n, row+1);
            }
        }

    }

    //좌표 값을 받아서 nQueen 규칙에 위배되는지 확인
    public static boolean check_nQueen_rule(int x, int y){

        for(int row =1 ; row<y ; row++){
            if(cols[row] == x) return false; //같은 열이면 안됨
            if(Math.abs(row-y) == Math.abs(cols[row] - x)) return false;
        }

        return true;
    }

}