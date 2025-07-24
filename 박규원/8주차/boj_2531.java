import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int[] list = new int[n];

        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int s = 0;
        Set<Integer> set = new HashSet<>();
        int max = 0, idx=0;

        while(true){
            idx=s;
            for(int i = 0;i<k;i++){
                set.add(list[idx]);
                idx = (idx+1)%n; 
            }
            set.add(c);
            if(max<set.size()){
                max = set.size();
            }
            s =(s+1)%n;
            set.clear();
            if(s==0) break;
        }

        System.out.println(max);
    }
}