package com.vilderlee.datastructure.array;

/**
 * 功能描述:
 *
 * @package com.vilderlee.array
 * @auther vilderlee
 * @date 2018-12-06 22:07
 */
public class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int high = A.length;
        for (int i = 0; i < high; i++) {
            int mid = A.length / 2;

            int width = A.length;
            //第一次交换
            for (int j = 0; j < mid; j++, width--) {
                int tem = A[i][j];
                A[i][j] = A[i][width - 1];
                A[i][width - 1] = tem;
            }

            for (int j = 0; j < high; j++) {
                if (1 == A[i][j]) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }

        return A;
    }


    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
    }
}
