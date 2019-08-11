package pers.geolo.dp;

/**
 * 01背包问题
 *
 * @author 桀骜(Geolo)
 * @date 2019-06-24
 */
public class KnapsackQuestion {

    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capacity = 10;
        System.out.println(getMaxValue(weight, value, capacity));
    }

    /**
     * @param weight   物品重量
     * @param value    物品价值
     * @param capacity 背包容量
     * @return 最大价值
     */
    public static int getMaxValue(int[] weight, int[] value, int capacity) {
        // maxValue[i][j] : 任选前i个物品放入容量为j的背包时的最大值
        int n = weight.length;
        int[][] maxValue = new int[n + 1][capacity + 1];

        // 将背包容量为0的状态的价值赋值为0
        for (int i = 0; i <= n; i++) {
            maxValue[i][0] = 0;
        }
        // 将物品数量为0的状态的价值赋值为0
        for (int i = 0; i <= capacity; i++) {
            maxValue[0][i] = 0;
        }
        // 遍历物品数量和背包容量均不为0的状态
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] > j) { // 第i个物品重量比整个背包都大
                    // 不装第i个物品
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    // 装与不装的最大值
                    maxValue[i][j] = Math.max(maxValue[i - 1][j - weight[i - 1]] + value[i - 1], maxValue[i - 1][j]);
                }
            }
        }

        // 打印maxValue
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(maxValue[i][j] + "\t");
            }
            System.out.println();
        }
        return maxValue[n][capacity];
    }
}
