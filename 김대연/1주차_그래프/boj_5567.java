import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    private static int n;
    private static int m;
    private static List<List<Integer>> friendship = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            friendship.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            friendship.get(s).add(e);
            friendship.get(e).add(s);
        }

        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        depth[1] = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> friends = friendship.get(num);
            for (int friend : friends) {
                if (depth[friend] != -1) {
                    continue;
                }
                queue.add(friend);
                depth[friend] = depth[num] + 1;
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            // System.out.println(depth[i]);
            if (depth[i] <= 2 && depth[i] >= 0) {
                count++;
            }
        }
        System.out.println(count);
    }

}