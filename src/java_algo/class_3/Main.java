package java_algo.class_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //O(n^2)
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int sum;
        for (int i = 1; i < num; ++i) {
            sum = i;
            int copy = i;
            while (copy > 0) {
                sum += copy % 10;
                copy /= 10;
            }
            if (sum == num) {
                arr.add(i);
            }
        }
        System.out.println(arr.size());
        for (Integer number: arr) {
            System.out.print(number + " ");
        }
    }
}
