import java.io.*;
import java.util.*;

class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] list;
    public static int[][] answer = {
        {1,2,3},
        {4,5,6},
        {7,8,0}
    };

    public static Deque<State> q = new LinkedList<>();
    public static Set<String> visited = new HashSet<>();

    public static class State{
        int[][] puzzle;
        int move;

        public State(int[][] puzzle, int move){
            this.puzzle = puzzle;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        list = new int[3][3];
        answer = new int[3][3];

        int value = 1;

        //정답 배열 초기화
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==2 && j==2) {
                    answer[i][j] = 0;
                    break;
                }
                answer[i][j] = value;
                value++;
            }
        }

        //입력 받기
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    //퍼즐이 완성되면 종료된다 - dfs(백트래킹)
    //퍼즐이 완성되는 모든 경우의 수를 찾는다 - bfs
    //처음에 백트래킹을 생각했는데 알고보니 모든 경우를 찾아서 최소값을 찾아야 되는것이였다.
    //문제를 많이 풀어서 센스를 쌓아야겠다

    public static int bfs(){
        q.offer(new State(list, 0));

        while(!q.isEmpty()){
            State current = q.poll();
            int[][] puzzle = current.puzzle;
            int move = current.move;

            if(answer_check(puzzle)){
                return move;
            }

            int[] pos = find_blank(puzzle);
            int x = pos[0]; int y = pos[1];

            for(int i=0;i<4;i++){
                if(x+dx[i] <0 || x+dx[i] >2 || y+dy[i] <0 || y+dy[i] > 2) continue;
                
                int[][] new_puzzle = copyArray(puzzle);
                new_puzzle[x][y] = new_puzzle[x+dx[i]][y+dy[i]];
                new_puzzle[x+dx[i]][y+dy[i]] = 0;

                String new_puzzle_str = arrayToString(new_puzzle);
                if(!visited.contains(new_puzzle_str)){
                    visited.add(new_puzzle_str);
                    q.offer(new State(new_puzzle, move+1));
                }
            }
            
        }

        return -1;
    }

    public static String arrayToString(int[][] list){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                sb.append(list[i][j]);
            }
        }
        return sb.toString();
    }

    public static int[][] copyArray(int[][] arr){
        int[][] puzzle = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                puzzle[i][j] = arr[i][j];
            }
        }
        return puzzle;
    }

    public static int[] find_blank(int[][] list){
        int[] pos = new int[2];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(list[i][j] == 0){
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }

        return pos;
    }

    public static boolean answer_check(int[][] list){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(list[i][j] != answer[i][j]) return false;
            }
        }
        return true;
    }
}