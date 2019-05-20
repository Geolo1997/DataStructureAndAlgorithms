package pers.geolo.sort;

/**
 * 排序算法工具类
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-20
 */
public class SortUtils {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
