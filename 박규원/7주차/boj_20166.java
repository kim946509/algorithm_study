import java.io.*;
import java.util.*;

class Main {
    public static char[][] arr;
    public static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1 }; //현재, 상하좌우, 좌측하단, 우측하단, 좌측상단, 우측상단
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1 }; //현재, 상하좌우, 좌측하단, 우측하단, 좌측상단, 우측상단
    public static int n,m,k;
    public static Map<String, Integer> god_love = new LinkedHashMap<>(); //신이 좋아하는 수, 정방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 격자 크기 n
        m = Integer.parseInt(st.nextToken()); // 격자 크기 m
        k = Integer.parseInt(st.nextToken()); // 문자열의 개수 k

        arr = new char[n+1][m+1];

        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=1;j<=m;j++){
                arr[i][j] = str.charAt(j-1);
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dfs(i,j,Character.toString(arr[i][j]));
            }
        }

        for(int i=0;i<k;i++){
            String str = br.readLine();
            if(!god_love.containsKey(str)){
                System.out.println(0);
                continue;
            }
            System.out.println(god_love.get(str));
        }

    }

    public static void dfs(int x, int y, String str){
        god_love.put(str, god_love.getOrDefault(str, 0)+1);

        if(str.length() == 5) return; //길이 최대가 5여서 모든 경우의 수를 구하기

        for(int i=0;i<8;i++){
            int[] pos = range_check(x+dx[i], y+dy[i]);
            dfs(pos[0], pos[1], str + arr[pos[0]][pos[1]]);
        }
    }

    public static int[] range_check(int x, int y){
        int[] pos = new int[2]; //0, 1 인덱스 값은 각각 x와 y 좌표값

        //x 범위 관리
        if(x <= 0){
            pos[0] = n;
        }else if(x>n){
            pos[0] = 1;
        }else{
            pos[0] = x;
        }

        //y 범위 관리
        if(y<=0) {
            pos[1] = m;
        }else if(y>m){
            pos[1] = 1;
        }else{
            pos[1] = y;
        }

        return pos;
    }
}