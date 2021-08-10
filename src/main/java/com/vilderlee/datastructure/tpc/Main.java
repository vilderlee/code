package com.vilderlee.datastructure.tpc;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr1 = scanner.nextLine().split(" ");
        int first = Integer.parseInt(arr1[0]);

        for (int i = 0; i < first; i++) {
            String[] arr2 = scanner.nextLine().split(" ");
            int team = Integer.parseInt(arr2[0]);
            int gold = Integer.parseInt(arr2[1]);

            String[] arr3 = scanner.nextLine().split(" ");
            String[] arr4 = scanner.nextLine().split(" ");

            int tencent = Integer.parseInt(arr3[0]) + Integer.parseInt(arr4[0]);
            arr3[0] = String.valueOf(tencent);

            List<Integer> list =
                    Stream.of(arr3).map(Integer::parseInt).sorted((a, b) -> b - a).collect(Collectors.toList());

            if (list.get(gold - 1) <= tencent) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
