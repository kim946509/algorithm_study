import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] solution = new int[n];

        for(int i=0; i<n; i++){
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);
        int min = Integer.MAX_VALUE;
        int answer_a=0, answer_b=0;

        for(int i=0;i<n-1;i++){
            int left = i+1;
            int right = n-1;
            
            while(left<=right){
                int mid = (left + right) / 2;
                int sum = solution[i] + solution[mid];

                if(Math.abs(sum) < Math.abs(min)){
                    min = sum;
                    answer_a = solution[i];
                    answer_b = solution[mid];
                }
                
                if(sum<0){
                    left = mid+1;
                }else if(sum>0){
                    right = mid - 1;
                }else{
                    break;
                }
            }

        }

        System.out.println(answer_a + " " + answer_b);
    }
}