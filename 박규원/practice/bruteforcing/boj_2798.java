import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] list = new int[n];

        for(int i =0;i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int answer = 0;
        int sum = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    sum = list[i] + list[j] + list[k];
                    if((answer<sum) && (sum<=m)){
                        answer = sum;
                    }
                }
            }
        
            sum=0;
        }

        System.out.print(answer);


    }
}