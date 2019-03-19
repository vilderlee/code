package com.vilderlee.datastructure.array;

/**
 * 功能描述:
 *
 * @package com.vilderlee.array
 * @auther vilderlee
 * @date 2018-12-05 22:22
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int n = 0, m = 0;
        int[] arr = new int[length];
        while (A.length > n) {
            int tmp = A[n];
            if (A[n] % 2 == 1) {
                arr[length - 1] = A[n];
                length--;
            } else {
                arr[m] = tmp;
                m++;
            }
            n++;

        }
        return arr;
    }

    public static int[] sortArrayByParity2(int[] A) {

        int j = 0;
        int length = A.length;
        int[] arr = new int[length];
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==1){
                arr[length-1] = A[i];
                length--;
            }else {
                arr[j] = A[i];
                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        sortArrayByParity2(A);
    }
}
