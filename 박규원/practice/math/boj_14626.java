package 박규원.practice.math;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        char[] list = s.toCharArray();
        int m = list[list.length-1]-'0';
        int star_value = 0;
        int sum = 0;

        for(int i=0;i<13;i++){
            
            int value = (i%2==0) ? 1 : 3;
            if(list[i] == '*') {
                star_value = value;
                continue;
            }
            sum+=(value*(list[i]-'0'));
        }
        
        int answer = 0;
        for(int i=0;i<=9;i++){
            if((sum+(star_value*i))%10 == 0){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}