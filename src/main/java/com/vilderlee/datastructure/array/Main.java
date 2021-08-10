package com.vilderlee.datastructure.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int circle = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < circle; i++) {
            String[] s = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            String[] ar = scanner.nextLine().split(" ");
            List<Integer> list =
                    Stream.of(ar).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> res = new ArrayList<>();
            Set<Integer> set = new HashSet<>(list);
            if (set.size() == 1) {
                System.out.println(k + " " + list.get(0));
                break;
            }
            int count = 1;
            int max = 0;
            for (int j = 0; j < list.size(); j++) {
                int val = list.get(j);
                if (res.contains(val)) {
                    if (res.size() < k - 1) {
                        res.add(val);
                    } else {
                        System.out.println(count + " " + val);
                        break;
                    }
                } else {
                    max = Math.max(max, res.size());
                    res.clear();
                    res.add(val);
                }
                if (j == n - 1) {
                    j = -1;
                }
                if (count > 2 * n) {
                    System.out.println("INF");
                    break;
                }
                count++;
            }
        }
    }
}
