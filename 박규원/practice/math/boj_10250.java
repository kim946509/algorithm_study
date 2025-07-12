import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken()); //층 수
            int w =Integer.parseInt(st.nextToken()); //방 수
            int n = Integer.parseInt(st.nextToken()); //몇번째 손님

            int front =0 , back=0;
            if(n%h == 0){
                front = h;
                back = n/h;
            }else{
                front = n%h;
                back = n/h + 1;
            }

            if(back/10 == 0){
                System.out.println(front + "0" + back);
                continue;
            }

            System.out.println(front + "" + back);
        }
    }
}