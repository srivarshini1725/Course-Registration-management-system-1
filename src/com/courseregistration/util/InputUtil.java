package com.courseregistration.util;

import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {

        System.out.print(message);

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

    public static String getString(String message) {

        System.out.print(message);

        return scanner.next();
    }

    public static String getLine(String message) {

        System.out.print(message);

        return scanner.nextLine();
    }
}