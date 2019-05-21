package pers.geolo.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @author 桀骜(Geolo)
 * @date 2019-05-20
 */
public class Test {
    public static void main(String[] args) {
        // 生成随机数组
        int[] originArray = getRandomArray(100000, 1000);
        System.out.print("原始数组为：");
        printArray(originArray);
        // Arrays.sort排序结果
        int[] systemSortArray = originArray.clone();
        Date systemSortBeginTime = new Date();
        Arrays.sort(systemSortArray);
        Date systemSortEndTime = new Date();
        printArray(systemSortArray);
        System.out.println("系统排序时间：" + (systemSortEndTime.getTime() - systemSortBeginTime.getTime()));
        // 我的排序算法结果
        int[] mySortArray = originArray.clone();
        Date mySortBeginTime = new Date();
        HeapSort.heapSort(mySortArray);
        Date mySortEndTime = new Date();
        printArray(mySortArray);
        System.out.println("我的排序时间：" + (mySortEndTime.getTime() - mySortBeginTime.getTime()));

        if (equals(systemSortArray,mySortArray)) {
            System.out.println("算法正确！");
        } else {
            System.out.println("算法错误！");
        }
    }

//    public static void

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] getRandomArray(int length, int range) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * range);
        }
        return array;
    }

    public static boolean equals(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
