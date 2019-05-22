package pers.geolo.sort;

/**
 * 计数排序
 * 只适用于（正）整数排序，且数组元素值的跨度较小
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-22
 */
public class CountingSort {

    public static void countingSort(int[] array) {
        // 获取数组元素的最大值
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }
        // 创建用于计数的数组
        int[] bucket = new int[maxValue + 1];
        // 进行计数
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }
        // 进行统计
        int sortedIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                array[sortedIndex++] = i;
                bucket[i]--;
            }
        }
    }
}
