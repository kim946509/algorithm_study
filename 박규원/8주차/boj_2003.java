import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] list = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list[i] = Long.parseLong(st.nextToken());
        }

        int start = 0, end = 0;
        long sum = 0;
        int count=0;

        while(start<=end && end<n){
            //특정 구간의 합 구하기
            for(int idx=start;idx<=end;idx++){
                sum+=list[idx];
            }

            if(start == end && end ==0){
                end++;
                if(sum == m) count++;
                sum=0;
                continue;
            }

            if(start == end){
                end++;
                if(sum==m) count++;
                sum=0;
                continue;
            }

            if(sum > m) start++;
            else if(sum<m) end++;
            else {
                count++;
                start++;
                end++;
            }

            sum=0;
        }

        System.out.println(count);
    }
}