package com.vilderlee.datastructure.dp;

/**
 * PackQuestion
 * <p>
 * 假设我们背包可容纳的重量是4kg，有3样东西可供我们选择，
 * 一个是高压锅有4kg，价值300元，
 * 一个是风扇有3kg，价值200元，
 * 最后一个是一双运动鞋有1kg，价值150元。
 * 问要装哪些东西在重量不能超过背包容量的情况下价值最大。
 * 如果只装高压锅价值才300元，如果装风扇和运动鞋价值将达到350元，所以装风扇和运动鞋才是最优解，
 *
 * @ClassName PackQuestion
 * @Description
 * @Author VilderLee
 * @Date 2021/9/6 9:10 下午
 */

public class PackageQuestion {

    public static void main(String[] args) {
        int maxWeight = 4;
        int[] values = {300, 200, 150};
        int[] weights = {4, 3, 1};

        int[][] dp = new int[values.length + 1][weights.length + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j <= weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println();
    }
}
