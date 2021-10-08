package com.company;

import java.util.Scanner;

public class Main_156 {

    public static void main(String[] args) {
        int x, y, z;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();
        if (x % 2 == 0 && y % 2 == 0 || x % 2 == 0 && z % 2 == 0 || y % 2 == 0 && z % 2 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
