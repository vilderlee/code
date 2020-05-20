package com.vilderlee.datastructure.array;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/13      Create this file
 * </pre>
 */
public class FindKey {

    public static boolean find(int[][] array, int key) {
        if (null == array) {
            return false;
        }
        int row = 0;
        int column = array[0].length -1 ;
        while (column >= 0 && row <= array.length){
            if (array[row][column] == key){
                return true;
            }
            if (array[row][column] > key){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][]array = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(array.length);
        System.out.println(find(array , 11));;
    }

}
