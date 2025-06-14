import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = 1;
        }

        int max = 0;
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //크기 비교하며 부분수열 구하기
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxLength = 0;
        int maxIndex = 0;
        //가장 큰 길이를 가진 원소 구하기
        for(int i=0;i<n;i++){
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
        
    }
}