import java.io.*;
import java.util.*;

class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            //배열 사이즈
            int size = Integer.parseInt(st.nextToken());
            if(size==0) break;
            
            int[] list = new int[size];
            //배열에 값을 넣기
            for(int i=0;i<size;i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            combination(list, 6);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void combination(int[] arr, int r){
        ArrayList<Integer> result = new ArrayList<>();
        generateCombination(arr, r, 0, result);
    }
    
    public static void generateCombination(int[] arr, int r, int start, ArrayList<Integer> result){
        if(result.size() == r){
            for(int num : result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<arr.length; i++){
            result.add(arr[i]);
            generateCombination(arr, r, i+1, result);
            result.remove(result.size()-1);
        }
    }

    
}
