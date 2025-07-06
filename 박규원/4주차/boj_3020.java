import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] s = new int[n/2];
        int[] j = new int[n/2];
        int s_idx=0;
        int j_idx=0;

        //석순과 종유석 초기화
        for(int i = 0; i<n; i++){
            if(i%2==0){
                s[s_idx++] = Integer.parseInt(br.readLine()); //석순 초기화
            }else{
                j[j_idx++] = Integer.parseInt(br.readLine()); //종유석 초기화
            }
        }

        Arrays.sort(s);
        Arrays.sort(j);

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for(int i=1;i<=h;i++){
            int s_mid = i;
            int j_mid = h - s_mid + 1;

            int s_count = lowerBound(s_mid, s);
            int j_count = lowerBound(j_mid, j);

            if((s_count + j_count) < min){
                min = s_count + j_count;
                answer = 1;
            }else if((s_count + j_count) == min){
                answer++;
            }
        }

        System.out.println(min + " " + answer);
    }


    public static int lowerBound(int target, int[] arr){
        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left + right)/2;

            if(arr[mid]>=target){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        if(left == arr.length){
            return 0;
        }
        return arr.length-left;
    }

}
