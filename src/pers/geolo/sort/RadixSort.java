package pers.geolo.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @date 2019-05-22
 */
public class RadixSort {

    public static void RadixSort(int[] array) {
        // 计算array最大值
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }
        // 计算最大值为几位数
        int maxBit = 0;
        while (maxValue != 0) {
            maxValue /= 10;
            maxBit++;
        }
        // 用数的值作为下标存储数据
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        // 从低到高对每一位迭代
        for (int i = 1; i <= maxBit; i++) {
            int rate = (int) Math.pow(10, i - 1);
            for (int j = 0; j < array.length; j++) {
                int num = array[j] / rate % 10;
                buckets.get(num).add(array[j]);
            }
            int sortedIndex = 0;
            for (int j = 0; j < buckets.size(); j++) {
                List<Integer> bucket = buckets.get(j);
                for (int k = 0; k < bucket.size(); k++) {
                    array[sortedIndex++] = bucket.get(k);
                }
                bucket.clear();
            }
        }
    }
}
