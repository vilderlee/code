package com.vilderlee.datastructure.dp;

/**
 * 类说明:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *     [1,3,1],
 *      [1,5,1],
 *      [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 * 求dp[m][n]最小，也就是 min{dp[m-1][n],dp[m][n-1] + arr[m][n]}
 *
 * <p>
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/21      Create this file
 * </pre>
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int[][]dp = new int[row][column];
        //初始化

        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] =Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][column-1];
    }
}
