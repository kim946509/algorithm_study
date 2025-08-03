import java.io.*;
import java.util.*;

class Main {
    public static int[] dx = {-1, 0, 1, 0}; //북동남서
    public static int[] dy = {0, 1, 0, -1}; //북동남서
    public static int[][] list;

    public static int n; //직사각형 n
    public static int m; //직사각형 m

    public static int r,c,d;

    public static int clean_count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //직사각형 n
        m = Integer.parseInt(st.nextToken()); //직사각형 m

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); //현재 위치 r
        c = Integer.parseInt(st.nextToken()); //현재 위치 c
        d = Integer.parseInt(st.nextToken()); //현재 방향

        list = new int[n][m];

        //직사각형 배열 입력 받기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            clean_now();
            //작동종료하는 경우 반복문 종료
            if(!clean_check()) break;
        }

        System.out.println(clean_count);

    }

    //현재 칸이 청소되지 않았으면 청소하기
    public static void clean_now(){
        // 2 : 청소되지 않았던 칸을 청소하기
        if(list[r][c] == 0) {
            list[r][c] = 2;
            clean_count++;
        };
        
    }

    //현재 칸의 주변 4칸 검사 후 조건 2가지 처리
    public static boolean clean_check(){
        int not_clean_status = 0;

        //칸의 주변 4칸 검사하여 청소되지 않은 빈칸을 찾기
        for(int i=0;i<4;i++){
            int nx = r+dx[i];
            int ny = c+dy[i];

            if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;

            if(list[nx][ny] == 0) not_clean_status++; //청소되지 않은 빈칸이 있는 경우
        }

        //청소되지 않은 빈칸이 없는 경우
        if(not_clean_status == 0){
            //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
            int b_d = (d+2)%4;
            int nx = r+dx[b_d];
            int ny = c+dy[b_d];
            
            //후진할 수 없는 상황이라면 작동 종료
            if(nx<0 || nx>n-1 || ny<0 || ny>m-1) return false;

            //후진할 칸에 벽이있다면 작동 종료
            if(list[nx][ny] == 1) return false;

            //후진이 가능하다면 후진
            r = nx; 
            c = ny;
            return true;
        }

        //청소되지 않은 빈 칸이 있는 경우
        while(true){    
            d = (d+3)%4; // 방향 업데이트 => 반시계방향으로 90도 회전
            int nx = r+dx[d];
            int ny = c+dy[d];

            if(nx<0 || nx>n-1 || ny<0 || ny>m-1) continue;

            if(list[nx][ny] >= 1) continue;

            if(list[nx][ny] == 0){
                r = nx;
                c = ny;
                break;
            }
        }

        return true;
    }
}