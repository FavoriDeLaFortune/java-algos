package java_algo.filya_1;

import java.util.Scanner;

public class Main {

    //O(2 * n + CONST) ~ O(n)
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int maxNum = -1;
        int minNum = 1_000_000_001;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) { //O(n)
            int num;
            num = in.nextInt();
            if (num > maxNum) {
                maxNum = num;
            }
            if (num < minNum) {
                minNum = num;
            }
            arr[i] = num;
        }
        int x = maxNum - minNum;
        int midNum = maxNum - x / 2;
        for (int i = 0; i < n; ++i) { //O(n)
            if (!(arr[i] == maxNum) && !(arr[i] == minNum) && !((arr[i] == midNum) && x % 2 == 0)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
