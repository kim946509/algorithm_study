package 박규원.practice.math;
import java.io.*;

//확실이 수학은 재밌네 재밌어 ㅋㅋㅋ (코딩으로 접근하는건 더 재밌음 ㄹㅇㅋㅋ)

class Main {
    public static int two_count =0;
    public static int five_count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++){
            int value = i;

            while(value%5 == 0){
                value /= 5;
                five_count++;
            }

            while(value%2 == 0){
                value/=2;
                two_count++;
            }

        }

        System.out.println(Math.min(two_count, five_count));
    }

}