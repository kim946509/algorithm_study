import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int t = n+m;

        Set<String> set = new HashSet<>();
        Set<String> answer = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<t;i++){
            String s = br.readLine();

            if(set.contains(s)){
                answer.add(s);
            }else{
                set.add(s);
            }
        }

        System.out.println(answer.size());
        for(String s : answer){
            System.out.println(s);
        }
        
    }
}