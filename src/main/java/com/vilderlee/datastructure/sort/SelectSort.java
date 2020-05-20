package com.vilderlee.datastructure.sort;

import java.util.Arrays;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/14      Create this file
 * </pre>
 */
public class SelectSort {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            //找到最小元素的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            //交换当前头部元素跟之后的元素中最小的值
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insert = array[i];
            int j = i - 1;
            for (; j >= 0 && insert < array[j]; j--) {
                array[j + 1] = array[j];
            }

            array[j + 1] = insert;
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 1, 3, 2, 8 };
        insertSort(array);
        System.out.println(Arrays.toString(array));

        int i =3;
        for (; i < 5; ++i) {
            System.out.println(i);
        }
    }
}
