import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key,0)+1);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<m;i++){
            int key = Integer.parseInt(st.nextToken());
            if(map.get(key) == null) {
                sb.append(0).append(" ");
                continue;
            }
            sb.append(map.get(key)).append(" ");
        }
        
        System.out.print(sb.toString());
    }
}