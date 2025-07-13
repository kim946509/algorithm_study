import java.io.*;
import java.util.*;
import java.awt.Point;

class Main {
    private static List<Point> selectedChicken = new ArrayList();
    private static List<Point> house = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();
    private static int n;
    private static int m;
    private static int minChickenDistance = Integer.MAX_VALUE;

    private static void pick(int cur) {
        if (selectedChicken.size() == m) {
            int chickenDistance = calcurateChickenDistance();
            minChickenDistance = Math.min(chickenDistance, minChickenDistance);
            return;
        }
        for (int i = cur; i < chickens.size(); i++) {
            selectedChicken.add(chickens.get(i));
            pick(i + 1);
            selectedChicken.remove(selectedChicken.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new Point(j, i));
                } else if (num == 2) {
                    chickens.add(new Point(j, i));
                }
            }
        }
        pick(0);
        System.out.println(minChickenDistance);
    }

    private static int calcurateChickenDistance() {
        int sumDistnace = 0;
        for (Point p : house) {
            int minDistance = Integer.MAX_VALUE;
            for (Point chicken : selectedChicken) {
                int distance = Math.abs(chicken.x - p.x) + Math.abs(chicken.y - p.y);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
            sumDistnace += minDistance;
        }
        return sumDistnace;
    }
}