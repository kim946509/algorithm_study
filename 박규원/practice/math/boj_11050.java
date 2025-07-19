import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        int s = 1;
        int p = 1;

        for(int i=n;i>n-k;i--){
            s*=i;
        }

        for(int i=k;i>=1;i--){
            p*=i;
        }

        System.out.println(s/p);
    }
}