package 박규원.practice.math;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //낮에 올라가는 거리
        int b = Integer.parseInt(st.nextToken()); //밤에 내려오는 거리
        int v = Integer.parseInt(st.nextToken()); //나무 높이
        int result = 0;

        System.out.println((v-b-1)/(a-b)+1); //올림으로 처리 -> 나머지가 생기면 올림, 나미지가 0이면 그대로
    }
}