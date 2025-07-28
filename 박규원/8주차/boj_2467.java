import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[n];

        int start = 0, end = n-1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        //입력 받기
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());            
        }

        while(start<end){
            int sum = list[start] + list[end];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                answer[0] = list[start];
                answer[1] = list[end];
                if(sum<0) start++;
                else if(sum>0) end--;
                else break;
                continue;
            }

            if(sum < 0) start++;
            else if(sum>0) end--;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}