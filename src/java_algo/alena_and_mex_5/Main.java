package java_algo.alena_and_mex_5;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int num = in.nextInt();
            arr[i] = num;
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.replace(num, hashMap.get(num) + 1);
            }
        }
        int mex = 0;
        int cur = 1;
        for (Integer key: arr) {
            while (key > cur) {
                if (!hashMap.containsKey(cur)) {
                    hashMap.put(cur, 1);
                    if (hashMap.get(key) == 1) {
                        hashMap.remove(key);
                        break;
                    } else {
                        hashMap.replace(key, hashMap.get(key) - 1);
                    }
                }
                ++cur;
            }
        }
        for (Integer key: hashMap.keySet()) {
            if (key > mex) {
                mex = key;
            }
        }
        System.out.println(mex + 1);
    }
}
