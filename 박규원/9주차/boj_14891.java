import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<Deque<Integer>> list = new ArrayList<>();
    public static boolean[] check = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0;i<4;i++){
            String s = br.readLine();
            list.add(new ArrayDeque<Integer>());
            for(int j=0;j<8;j++){
                list.get(i).add(s.charAt(j)-'0');
            }
        }

        int rotation = Integer.parseInt(br.readLine());

        for(int i=0;i<rotation;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w_idx = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotate_wheel(w_idx, direction);

            for(int j=0;j<4;j++){
                check[j] = false;
            }
        }

        System.out.println(result_score());
    }

    public static void rotate_wheel(int w_idx, int direction){
        //이미 돌린 바위임
        if(check[w_idx-1]) return;

        int right_w_idx = -1;
        int left_w_idx = -1;
        int my_six_idx = -1;
        int my_sec_idx = -1;

        if(w_idx + 1 <= 4) right_w_idx = getValue(6,w_idx+1);
        if(w_idx - 1 >=1) left_w_idx = getValue(2, w_idx-1);

        my_sec_idx = getValue(2, w_idx);
        my_six_idx = getValue(6, w_idx);

        //시계방향으로 톱니바퀴를 굴림
        if(direction == 1){
            int last_value = list.get(w_idx-1).pollLast();
            list.get(w_idx-1).offerFirst(last_value);
            check[w_idx-1] = true;
        }else{
            //반시계 방향으로 톱니바퀴를 굴림
            int last_value = list.get(w_idx-1).poll();
            list.get(w_idx-1).offer(last_value);
            check[w_idx-1] = true;
        }
        
        //오른쪽 바퀴가 존재하고, 현재의 바퀴가 오른쪽 바퀴랑 맞물린 부분이 극이 다르면 회전시키기
        if(right_w_idx != -1 && right_w_idx != my_sec_idx) rotate_wheel(w_idx+1, direction*-1);
        
        //왼쪽 바퀴가 존재하고, 현재의 바퀴가 왼쪽 바퀴랑 맞물린 부분이 극이 다르면 회전시키기
        if(left_w_idx != -1 && left_w_idx != my_six_idx) rotate_wheel(w_idx-1, direction*-1);
        
        return;
    }

    //deque의 값을 조회하기 (바퀴의 톱니 값을 조회하기)
    public static int getValue(int idx, int wheel_idx){
        int count = 0;
        int answer = 0;

        for(int i : list.get(wheel_idx-1)){
            if(idx == count){
                answer = i;
                break;
            }

            count++;
        }

        return answer;
    }

    public static int result_score(){
        int sum = 0;
        int s_value = 1;

        for(int i=0;i<4;i++){
            int first_value = list.get(i).poll();

            if(first_value != 0){
                sum += s_value;
            }

            s_value *= 2;
        }

        return sum;
    }
}