package pers.geolo.sort;

/**
 * 快速排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-20
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 进行划分操作，获取基准坐标
            int partitionIndex = partition2(array, left, right);
            // 对基准左边部分进行快速排序
            quickSort(array, left, partitionIndex - 1);
            // 对基准右边部分进行快速排序
            quickSort(array, partitionIndex + 1, right);
        }
    }

    /**
     * 划分方法1：从左至右扫描
     */
    private static int partition(int[] array, int left, int right) {
        // 基准值
        int pivot = array[left];
        // 基准值应在的下标，初始假设其余元素都大于基准值
        int pivotIndex = left;
        // 从第二个元素开始到末尾进行迭代
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < pivot) { // 如果元素i小于基准值
                // 基准下标右移一位
                pivotIndex++;
                // i和基准下标元素交换
                SortUtils.swap(array, i, pivotIndex);
            }
        }
        // 把基准下标所指的小于基准值的元素和left位置的基准值交换位置
        SortUtils.swap(array, pivotIndex, left);
        return pivotIndex;
    }

    /**
     * 划分方法2：两端往中间扫描并交换
     */
    private static int partition2(int[] array, int left, int right) {
        // 基准值
        int pivot = array[left];
        while (left < right) {
            // 当右边元素大于或等于基准值时right左移
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            // 当左边元素小于或等于基准值时left右移
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }
}
