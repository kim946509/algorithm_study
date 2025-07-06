import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = n*n;
        long count = 0;
        long answer = 0;

        while(left<=right){
            long mid = (left + right) / 2;

            for(int i=1;i<=n;i++){
                count += Math.min(mid/i,n);
            }
            
            if(count>=k){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }

            count=0;
        }

        System.out.println(answer);
    }
}