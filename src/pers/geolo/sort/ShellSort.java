package pers.geolo.sort;

/**
 * 希尔排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-20
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {6, 3, 7, 3, 8, 3, 33, 9, 23, 0, 43, 5};
        shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void shellSort(int[] array) {
        // gap表示步长，每次减小为原来的1/2
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // i表示要进行插入排序的元素，从第一组的第二个元素(0 + gap)开始，对该组元素(a + gap * n)进行插入排序，各组交叉进行
            for (int i = gap; i < array.length; i++) {
                // 获取要插入的元素
                int current = array[i];
                // 在要插入元素前面的元素
                int j = i - gap;
                while (j >= 0 && array[j] > current) {
                    // 将元素后移gap位
                    array[j + gap] = array[j];
                    j -= gap;
                }
                // 插入到j + gap
                array[j + gap] = current;
            }
        }
    }
}
