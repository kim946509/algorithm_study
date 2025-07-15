import java.io.*;
import java.util.*;

class Main {
    public static int[] list;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n];
        for(int i=1;i<=n;i++){
            list[i-1] = i;
        }

        combination(n,m,0,0);
        System.out.println(sb.toString());
    }

    public static void combination(int n, int m, int idx, int count){
        if(count == m) {
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx;i<n;i++){
                arr.add(list[i]);
                combination(n,m,i+1,count+1);
                arr.remove(arr.size()-1);
        }

    }
}