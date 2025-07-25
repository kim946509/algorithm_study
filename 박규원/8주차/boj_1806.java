import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] sum_arr = new long[n+1];

        for(int i=0;i<n;i++){
            long value = Integer.parseInt(st.nextToken());
            sum_arr[i+1] = sum_arr[i] + value; //구간합
        }

        int start = 0, end = 0 , length=Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        while(start<=end){
            if(start == end && start == 0) {
                end++;
                continue;
            }
            if(start == end){
                if(sum_arr[end] - sum_arr[start-1] < s) end++;
                else {
                    length = 1;
                    start++;
                }
                if(end >n) break;
                if(min>length){
                    min = length;
                }
                continue;
            }

            if((sum_arr[end] - sum_arr[start])<s) end++;
            else {
                length = end-start;
                start++;
            }
            if(end >n) break;
            if(min>length){
                min = length;
            }
        }

        if(min == Integer.MAX_VALUE || length == Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }
        System.out.println(min);
    }
}