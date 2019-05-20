package pers.geolo.sort;

/**
 * 冒泡排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-20
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtils.swap(array, j, j + 1);
                }
            }
        }
    }
}
