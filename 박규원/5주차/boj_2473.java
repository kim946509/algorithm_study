import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Long[] solution = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            solution[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(solution);

        Long a=0L,b=0L,c=0L;
        Long sum = 0L;
        Long min = Long.MAX_VALUE;
        
        for(int i =0;i<n-2;i++){

            for(int j=i+1;j<n-1;j++){
                int left = j+1;
                int right = n-1;

                while(left<=right){
                    int mid = (left + right) / 2;
                    sum = solution[i] + solution[j] + solution[mid];
                    Long sum_compare = Math.abs(sum);

                    if(sum_compare<min){
                        min = sum_compare;
                        a = solution[i];
                        b = solution[j];
                        c = solution[mid];
                    }

                    if(sum > 0){
                        right = mid - 1;
                    }else if(sum < 0){
                        left = mid + 1;
                    }else{
                        System.out.println(a + " " + b + " " + c);
                        return;
                    }
                }
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}