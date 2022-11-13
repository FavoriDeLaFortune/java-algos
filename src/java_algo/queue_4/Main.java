package java_algo.queue_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //O(n^2)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        int[] queue = new int[5];
        for (int i = 0; i < 5; ++i) {
            queue[i] = i;
        }
        for (int i = 0; i < 5; ++i) {
            table.add(new ArrayList<>());
            for (int j = 0; j < 5; ++j) {
                int g;
                g = in.nextInt();
                table.get(i).add(g);
            }
        }
        int maxSum = 0;
        int sum;
        while (nextPermutation(queue)) {
            int g12 = table.get(queue[0]).get(queue[1]);
            int g21 = table.get(queue[1]).get(queue[0]);
            int g34 = table.get(queue[2]).get(queue[3]);
            int g43 = table.get(queue[3]).get(queue[2]);
            int g23 = table.get(queue[1]).get(queue[2]);
            int g32 = table.get(queue[2]).get(queue[1]);
            int g45 = table.get(queue[3]).get(queue[4]);
            int g54 = table.get(queue[4]).get(queue[3]);
            sum = (g12 + g21 + g34 + g43) + (g23 + g32 + g45 + g54) + (g34 + g43) + (g45 + g54);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }

    static boolean nextPermutation(int[] queue) {
        for (int a = queue.length - 2; a >= 0; --a) {
            if (queue[a] < queue[a + 1]) {
                for (int b = queue.length - 1; ; --b) {
                    if (queue[b] > queue[a]) {
                        int t = queue[a];
                        queue[a] = queue[b];
                        queue[b] = t;
                        for (++a, b = queue.length - 1; a < b; ++a, --b) {
                            t = queue[a];
                            queue[a] = queue[b];
                            queue[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
