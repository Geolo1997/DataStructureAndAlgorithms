package pers.geolo.sort;

/**
 * 堆排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-21
 */
public class HeapSort {

    public static void heapSort(int[] array) {
        // 建堆
        // 第一个非叶子节点的位置为length / 2 - 1
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0; i--) {
            // 将堆顶最大元素交换至堆底
            SortUtils.swap(array, 0, i);
            // 重新调整堆顶
            adjustHeap(array, 0, i);
        }
    }

    /**
     * 调整以i为根节点的二叉树为大顶堆，其左右子树已为大顶堆
     */
    private static void adjustHeap(int[] array, int i, int length) {
        // 寻找根节点和左右子节点中的最大值
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        // 最大值在子节点
        if (largest != i) {
            // 和根节点进行交换
            SortUtils.swap(array, i, largest);
            // 以被交换的子节点为根进行调整
            adjustHeap(array, largest, length);
        }
    }

    /**
     * 非递归实现
     */
    private static void adjustHeap2(int[] array, int i, int length) {
        // 记录根节点
        int root = array[i];
        // j 表示子节点下标
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 寻找左右子节点中的最大值
            if (j + 1 < length && array[j + 1] > array[j]) {
                j++;
            }
            if (array[j] > root) { // 子节点中的最大值大于根节点
                // 根节点赋值为该子节点
                array[i] = array[j];
                // 该子节点成为新的根节点（值变为root）
                i = j;
            } else { // 根节点已为最大，调整完成
                break;
            }
        }
        // 最后的根节点赋值为root
        array[i] = root;
    }
}
