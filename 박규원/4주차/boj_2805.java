import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //나무의 수
        long m = Long.parseLong(st.nextToken()); //집으로 가져가려하는 나무의 길이

        long[] tree = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            tree[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(tree);
        System.out.println(b(tree,n,m));
    }

    public static long mid;
    public static long max=0;

    public static long b(long[] tree, int n, long m){
        long left = 0, right = tree[n-1];

        while(left<=right){
            mid = (left + right) / 2;
            long sum = 0;

            for(int i=0;i<n;i++){
                long diff = tree[i] - mid;
                if(diff<=0) continue;
                sum+=diff;
            }

            //자른 나무 길이가 필요한 나무길이보다 작은 경우
            if(sum<m){
                right = mid-1;
            }else{
                left = mid+1;
                max=mid;
            }

        }
        return max;
    }
}