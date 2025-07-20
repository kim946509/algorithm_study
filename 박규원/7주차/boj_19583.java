import java.io.*;
import java.util.*;

class Main {
    public static int s, e, q;
    public static int count = 0;
    public static Set<String> map = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s_s = st.nextToken().split(":");
        String[] s_e = st.nextToken().split(":");
        String[] s_q = st.nextToken().split(":");

        s = Integer.parseInt(s_s[0] + s_s[1]); //개강총회를 시작한 시간
        e = Integer.parseInt(s_e[0] + s_e[1]); //개강총회를 끝낸 시간 
        q = Integer.parseInt(s_q[0] + s_q[1]); //개강총회 스트리밍을 끝낸 시간

        while(true){
            try{
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                String time = st1.nextToken();
                String name = st1.nextToken();
                attendance(time, name);
            }catch(Exception Exception){
                break;
            }
        }

        System.out.println(count);
    }

    public static void attendance(String time, String name){
        String[] s_t = time.split(":");
        int int_time = Integer.parseInt(s_t[0] + s_t[1]);
        
        if(int_time<=s){
            map.add(name);
            return;
        }
        
        if(int_time<e){
            return;
        }

        if(int_time<=q && map.contains(name)){
            map.remove(name);
            count++;
            return;
        }
    }
}