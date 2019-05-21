package pers.geolo.sort;

/**
 * 归并排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-21
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        // 创建和原数组大小一样的临时数组，用于归并过程的暂存，避免频繁开辟空间
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    private static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(array, left, middle, temp);
            sort(array, middle + 1, right, temp);
            merge(array, left, middle, right, temp);
        }
    }

    /**
     * 将左右两部分归并
     */
    private static void merge(int[] array, int left, int middle, int right, int[] temp) {
        int i = left, j = middle + 1, tempLength = 0;
        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                temp[tempLength++] = array[i++];
            } else {
                temp[tempLength++] = array[j++];
            }
        }
        // 将左边剩余元素填充进temp
        while (i <= middle) {
            temp[tempLength++] = array[i++];
        }
        // 将右边剩余元素填充进temp
        while (j <= right) {
            temp[tempLength++] = array[j++];
        }
        // 将temp前length个值拷贝回array的left~right区间
        for (int k = 0; k < tempLength; k++) {
            array[left + k] = temp[k];
        }
    }
}
