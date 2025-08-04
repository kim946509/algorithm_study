import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> loadTrucks = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            loadTrucks.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        int time = 0;
        Queue<Integer> bridgeTrucks = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            bridgeTrucks.add(0);
        }
        while (!loadTrucks.isEmpty()) {
            time++;
            sum -= bridgeTrucks.poll();

            if (sum + loadTrucks.peek() <= l) {
                int trucksize = loadTrucks.poll();
                bridgeTrucks.add(trucksize);
                sum += trucksize;

            } else {
                bridgeTrucks.add(0);
            }

            // System.out.println("---------------------------------");
            // System.out.println("time : " + time);
            // System.out.println("-----bridge------");
            // System.out.println(bridgeTrucks.toString());

            // System.out.println("-----load--------");
            // System.out.println(loadTrucks.toString());

        }
        time += w;
        System.out.println(time);
    }
}