package pers.geolo.sort;

/**
 * 选择排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-21
 */
public class SelectionSort {

    public static void selectionSort(int[] array) {
        // 最小的下标
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                minIndex = i;
                if (array[j] < array[i]) {
                    minIndex = j;
                }
                SortUtils.swap(array, i, minIndex);
            }
        }
    }
}
