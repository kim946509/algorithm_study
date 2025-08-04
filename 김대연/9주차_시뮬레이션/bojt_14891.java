import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    private static List<List<Integer>> tires = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            tires.add(new ArrayList<>());
            String input = sc.next();
            for (int j = 0; j < 8; j++) {
                tires.get(i).add((input.charAt(j) - '0'));
            }
        }

        int k = sc.nextInt();
        for (int t = 0; t < k; t++) {
            int number = sc.nextInt() - 1;
            int direction = sc.nextInt();

            boolean isLeft;
            if (direction == 1) {
                isLeft = false;
            } else {
                isLeft = true;
            }

            int[] rotateDir = new int[4];
            rotateDir[number] = direction;

            // 왼쪽 판단
            for (int i = number - 1; i >= 0; i--) {
                if (tires.get(i).get(2).equals(tires.get(i + 1).get(6)))
                    break;
                rotateDir[i] = -rotateDir[i + 1];
            }

            // 오른쪽 판단
            for (int i = number + 1; i < 4; i++) {
                if (tires.get(i - 1).get(2).equals(tires.get(i).get(6)))
                    break;
                rotateDir[i] = -rotateDir[i - 1];
            }

            for (int i = 0; i < 4; i++) {
                if (rotateDir[i] == 0)
                    continue;
                turn(rotateDir[i], i);
            }

        }

        int sum = 0;
        int x = 1;
        for (int i = 0; i < 4; i++, x *= 2) {
            sum += tires.get(i).get(0) * x;
        }
        System.out.println(sum);
    }

    static void turn(int direction, int target) {
        List<Integer> targetList = tires.get(target);
        if (direction == 1) {
            int last = targetList.remove(7);
            targetList.add(0, last);
        } else {
            int first = targetList.remove(0);
            targetList.add(first);
        }
    }

}