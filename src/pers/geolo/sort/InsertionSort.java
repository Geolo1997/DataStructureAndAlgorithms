package pers.geolo.sort;

/**
 * 简单插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {6, 3, 7, 3, 8, 3, 33, 9, 23, 0, 43, 5};
        insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void insertionSort(int[] array) {
        // i:要插入的元素的下标，从数组的第二个元素开始到最后一个元素进行迭代
        for (int i = 1; i < array.length; i++) {
            // 获取要插入的元素
            int key = array[i];
            // j:在要插入的元素前面的元素
            int j = i - 1;
            // 从要插入的元素前一个开始到数组的第一个元素进行迭代，当元素j小于或等于key时顺序正确，跳出迭代
            while (j >= 0 && array[j] > key) {
                // 将元素j后移一位
                array[j + 1] = array[j];
                j--;
            }
            // 把元素j前一个赋值为key
            array[j + 1] = key;
        }
    }
}
