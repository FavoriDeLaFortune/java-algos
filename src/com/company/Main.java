package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x, y, z, w;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();
        w = in.nextInt();
        if (x == -y || x == -z || x == -w || y == -z || y == -w || z == -w) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
