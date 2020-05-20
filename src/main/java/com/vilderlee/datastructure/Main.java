package com.vilderlee.datastructure;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Scanner;

public class Main{
    public static int getLast(String words){
        if(null == words || words.length() == 0){
            return 0;
        }
        String[] args = words.split(" ");
        return args[args.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(getLast("hello world"));
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        char word = scanner.nextLine().toCharArray()[0];

        char[] chars = words.toCharArray();
        int result = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == word){
                result++;
            }
        }

    }

}
