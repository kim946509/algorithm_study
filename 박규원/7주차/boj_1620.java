import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> reverse_map = new HashMap<>();

        for(int i=1;i<=n;i++){
            String str = br.readLine();
            map.put(i, str);
            reverse_map.put(str, i);
        }

        for(int i=0;i<m;i++){
            String check = br.readLine();
            if(Character.isDigit(check.charAt(0))){
                System.out.println(map.get(Integer.parseInt(check)));
            }else{
                System.out.println(reverse_map.get(check));
            }
        }

    }
}