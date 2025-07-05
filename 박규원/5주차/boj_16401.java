import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); //조카의 수
        int n = Integer.parseInt(st.nextToken()); //과자의 수

        int[] l = new int[n]; //과자의 길이가 들어간 배열

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i =0;i<n;i++){
            l[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(l);

        int left = 1;
        int right = l[n-1];
        int answer = 0;

        while(left<=right){
            int mid = (left + right) / 2; //시도하는 과자의 길이

            int count = 0;
            for(int i : l){
                if(i/mid >= 1){
                    count += (i/mid); //과자를 줄 수 있는 인원 수
                }
            }

            //나눠줄수 있는 조카의 수가 같거나 많다면 빼빼로 길이가 최대이거나 작다는 것
            if(count>=m){
                answer = mid;
                left = mid + 1;
            }else{ //나눠줄 수 있는 조카의 수가 작다면 빼빼로 길이가 너무 크다는 것
                right = mid-1;
            }
        }

        System.out.print(answer);
    }
}