package 박규원.practice.implementation;
import java.io.*;
import java.util.*;

class Main {
    //구현, DP(비효율적)
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     int t = Integer.parseInt(br.readLine());
    //     for(int i=0;i<t;i++){
    //         int k = Integer.parseInt(br.readLine());
    //         int n = Integer.parseInt(br.readLine());

    //         int[][] list = new int[k+1][n+1];

    //         for(int j=1;j<n+1;j++){
    //             list[0][j] = j;
    //         }

    //         for(int j = 1;j<k+1;j++){
    //             for(int l=1;l<n+1;l++){
    //                 int idx = 1;
    //                 while(idx<=l){
    //                     list[j][l] += list[j-1][idx];
    //                     idx++;
    //                 }
    //             }
    //         }
    //         System.out.println(list[k][n]);
    //     }


    // }

    //DP로 해결
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] list = new int[k+1][n+1];

            for(int j=1;j<n+1;j++){
                list[0][j] = j;
            }

            for(int j=1;j<k+1;j++){
                for(int l=1;l<n+1;l++){
                    list[j][l] = list[j][l-1] + list[j-1][l];
                } 
            }
            System.out.println(list[k][n]);
        }


    }

}