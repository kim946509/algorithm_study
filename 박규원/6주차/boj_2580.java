import java.io.*;
import java.util.*;

class Main {
    public static int[][] list;
    public static boolean[] check_list;
    public static ArrayList<Integer> blank_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new int[10][10];

        //입력
        for(int i=1;i<=9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=9;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(1, 1);

    }
    
    public static boolean sudoku(int x, int y){ 
    
        if(y>9){
            return sudoku(x+1, 1);
        }

        if(x>9){
            for(int a=1;a<=9;a++){
                for(int b=1;b<=9;b++){
                    System.out.print(list[a][b] + " ");
                }
                System.out.println();
            }
            return true;
        }

        if(list[x][y] != 0){
            return sudoku(x,y+1);
        }

        for(int i=1;i<=9;i++){
            if(check_sudoku(x, y, i)){
                list[x][y] = i;
                if(sudoku(x, y+1)) return true;
                list[x][y] = 0;
            }
        }

        return false;
    }
    
    public static boolean check_sudoku(int x, int y, int num){
        //가로 행에 대해서 해당 값이 존재하는지 검사
        for(int i=1; i<=9; i++){
            if(list[x][i]==num) return false;
        }

        //세로 행에 대해서 해당 값이 존재하는지 검사
        for(int i=1; i<=9; i++){
            if(list[i][y]==num) return false;
        }

        //3X3 칸에서 해당 값이 존재하는지 검사
        int x_value = (int) (x/3.5);
        int y_value = (int) (y/3.5);

        for(int i=x_value*3+1; i<=x_value*3+3; i++){
            for(int j=y_value*3+1; j<=y_value*3+3; j++){
                if(list[i][j] == num) return false;
            }
        }

        return true; //모두 테스트를 통과하면 true 반환
    }
}