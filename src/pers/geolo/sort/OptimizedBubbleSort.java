package pers.geolo.sort;

/**
 * 优化的冒泡排序，增加指示每一趟排序是否有交换的变量
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-21
 */
public class OptimizedBubbleSort {

    public static void optimizedBubbleSort(int[] array) {
        // 代表每一趟排序是否有交换
        boolean hasExchanged;

        for (int i = 0; i < array.length; i++) {
            hasExchanged = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    hasExchanged = true;
                    SortUtils.swap(array, j, j + 1);
                }
            }
            // 如果该趟排序没有交换，则已经排好序，跳出循环
            if (!hasExchanged) {
                break;
            }
        }
    }
}
