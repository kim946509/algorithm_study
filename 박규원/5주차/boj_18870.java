import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열 값 넣기
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i : list){
            treeSet.add(i);
        }

        Integer[] tree = treeSet.toArray(new Integer[0]); //중복값이 제거되고 정렬된 배열

        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(b(i,tree)+ " ");
        }
        
        System.out.print(sb.toString());
    }


    //이진탐색
    public static int b(int target, Integer[] arr){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] < target){
                left = mid+1;
            }else if(arr[mid] > target){
                right = mid-1;
            }else{
                left = mid;
                break;
            }
        }
        return left;
    }
}