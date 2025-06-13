import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {
    private static int n;
    private static int m;
    private static Set<Integer> trueMembers = new HashSet<>();
    private static Set<Integer> lieMembers = new HashSet<>();
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 진실을 아는 사람들 입력
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()); // 진실을 아는 사람들 수

        for (int i = 0; i < num; i++) {
            trueMembers.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> partyMembers = new ArrayList<>();

        // 파티마다 참여 멤버 반복해서 같은 파티 참여하는 멤버들 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int numbers = Integer.parseInt(st.nextToken());

            List<Integer> members = new ArrayList<>();
            for (int j = 0; j < numbers; j++) {
                members.add(Integer.parseInt(st.nextToken()));
            }

            // 그래프 그리기
            for (int t = 0; t < members.size() - 1; t++) {
                int left = members.get(t);
                int right = members.get(t + 1);
                graph.get(left).add(right);
                graph.get(right).add(left);
            }

            partyMembers.add(members);
        }

        int count = 0;
        // bfs 진행
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 1)
                continue;

            boolean isAnyTrust = false;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = -1; // 1: 거짓, 2: 진실
            if (trueMembers.contains(i)) {
                isAnyTrust = true;
                visited[i] = -1;
            }

            while (!queue.isEmpty()) {
                int node = queue.poll();
                List<Integer> friends = graph.get(node);
                for (int friend : friends) {
                    if (visited[friend] != 0)
                        continue;
                    queue.add(friend);
                    visited[friend] = -1;

                    // 아직 한명도 진실을 알고있는 사람이 없을경우 검사
                    if (!isAnyTrust && trueMembers.contains(friend)) {
                        isAnyTrust = true;
                    }
                }
            }
            // 모두 진실을 모를 경우 모두 2로 색칠
            if (!isAnyTrust) {
                for (int cur = 1; cur <= n; cur++) {
                    if (visited[cur] == -1) {
                        visited[cur] = 2;
                    }
                }
            }
            // 진실을 아는 사람이 있을 경우. 모두 1로 색칠
            else {
                for (int cur = 1; cur <= n; cur++) {
                    if (visited[cur] == -1) {
                        visited[cur] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            List<Integer> members = partyMembers.get(i);
            boolean isAnyTrust = false;
            for (int member : members) {
                if (visited[member] == 1) {
                    isAnyTrust = true;
                    break;
                }
            }
            if (!isAnyTrust) {
                count++;
            }
        }
        System.out.println(count);
    }

}