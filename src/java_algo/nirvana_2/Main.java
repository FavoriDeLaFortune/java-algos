package java_algo.nirvana_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //O(n^2)
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        while (num > 0) {
            arr.add(num % 10);
            num /= 10;
        }
        int mult;
        int maxMult = 1;
        for (Integer digit : arr) {
            maxMult *= digit;
        }
        for (int i = arr.size() - 1; i >= 0; --i) {
            mult = 1;
            mult *= arr.get(i) - 1;
            if (mult == -1 || mult == 0) {
                mult = 1;
                for (int j = i - 1; j >= 0; --j) {
                    mult *= 9;
                }
            } else {
                for (int j = arr.size() - 1; j > i; --j) {
                    mult *= arr.get(j);
                }
                for (int j = i - 1; j >= 0; --j) {
                    mult *= 9;
                }
            }
            if (mult > maxMult) {
                maxMult = mult;
            }
        }
        System.out.println(maxMult);
    }
}
