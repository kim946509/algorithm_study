import java.io.*;
import java.util.*;

//호오,,, 일반적인 재귀로는 안풀린다는 말이지...
//배열을 사용하면 메모리 초과...
//배열 안사용하면 시간 초과... (시간제한 0.5초)


class Main {
    public static int count = 0;
    public static int result = 0;
    public static int r,c;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        visit(0,0,size);

        System.out.println(count);
    }

    public static void visit(int i, int j, int size){
        if(size == 1){
            return;
        }

        int half = size/2;
        int area = half * half;

        if(i+half > c && j+half > r){ //2사분면에 속하는 경우
            visit(i, j, half);
            return;
        }
        
        if(i+half <= c && j+half >r ){ //1사분면에 속하는 경우
            visit(i+half, j ,half);
            count = count + area;
            return;
        }

        if(i+half > c && j+half <= r){ //3사분면에 속하는 경우
            visit(i, j+half, half);
            count = count + area*2;
            return;
        }
        
        if(i+half <= c && j+half <= r){ //4사분면에 속하는 경우
            visit(i+half, j+half, half);
            count = count + area*3;
            return;
        }

    }
}