import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //집의 개수
        int c = Integer.parseInt(st.nextToken()); //공유기 개수

        int[] home = new int[n];

        for(int i=0;i<n;i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int left = 0;
        int right = home[n-1] - home[0]; // 처음집과 마지막 집의 거리
        int result = 0;

        while(left<=right){
            int mid = (left + right) / 2;

            int count = 1;
            int lastHome = home[0];

            for(int i=1; i<n; i++){
                if((home[i] - lastHome) >= mid){  
                    count++;
                    lastHome = home[i];
                }
            }

            if(count>=c){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}