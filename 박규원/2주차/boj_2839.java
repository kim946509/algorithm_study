import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = -1;

        //5kg 팩이 많이 담을 수 있다는 것 -> 최소한의 설탕백을 담는 다는 뜻
        for(int i = n/5 ; i>=0 ; i--){
            int remainder = n - (5*i);

            //5kg 설탕팩을 담고 남은 무게에 3kg 설탕백을 못담는다면 다시 반복문 실행
            if(remainder%3==0){
                //최대로 담을 수 있는 5kg 설탕백 개수에 3kg 설탕백 개수를 더한 것이 최소의 설탕백 개수가 됨
                count = i + (remainder/3);
                break;
            }    
        }

        System.out.println(count);
    }

}