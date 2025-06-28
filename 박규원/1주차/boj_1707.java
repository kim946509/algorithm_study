import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] visited;
    public static int[] color;
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            visited = new boolean[v + 1];
            color = new int[v + 1];
            result = false;

            for (int j = 0; j <= v; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st1.nextToken());
                int b = Integer.parseInt(st1.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            // 연결 요소 모두 탐색
            for (int j = 1; j <= v; j++) {
                if (!visited[j]) {
                    color[j] = 0; // 임의의 색으로 시작
                    dfs(j);
                }
            }

            if (result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : list.get(node)) {
            if (!visited[neighbor]) {
                color[neighbor] = 1 - color[node]; // 반대 색으로 칠하기
                dfs(neighbor);
            } else if (color[neighbor] == color[node]) {
                result = true;
            }
        }
    }
}
