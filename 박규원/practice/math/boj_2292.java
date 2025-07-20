import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        if(n == 1){
            System.out.println(1);
            return;
        }

        int start = 2;
        int end = 7;
        
        int s_idx = 1;
        int e_idx = 2;

        while(true){
            if(start<=n && n<=end){
                break;
            }
            
            start += 6*s_idx;
            end += 6*e_idx;
            
            s_idx++;
            e_idx++;
        }

        System.out.println(e_idx);
    }
}