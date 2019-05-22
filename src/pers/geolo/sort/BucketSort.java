package pers.geolo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 *
 * @author 桀骜(Geolo)
 * @date 2019-05-22
 */
public class BucketSort {

    /**
     * 使用ArrayList，增查速度奇慢
     */
    public static void bucketSort(int[] array) {
        // 获取数组元素的最大值和最小值
        int maxValue = array[0], minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
            minValue = Math.min(minValue, array[i]);
        }
        // 桶的值跨度
        int bucketRange = 10;
        // 桶的数量
        int bucketCount = (maxValue - minValue) / bucketRange + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>(1000));
        }
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - minValue) / bucketRange;
            // TODO ArrayList增查操作过于耗时
            buckets.get(index).add(array[i]);
        }
        // 对每个桶元素进行排序
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        // 将桶元素放回原数组
        int sortedIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            List<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                array[sortedIndex++] = bucket.get(j);
            }
        }
    }

    /**
     * 使用自定义int型链表
     */
    public static void bucketSort2(int[] array) {
        // 获取数组元素的最大值和最小值
        int maxValue = array[0], minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            maxValue = Math.max(maxValue, array[i]);
            minValue = Math.min(minValue, array[i]);
        }
        // 桶的值跨度
        int bucketRange = 10;
        // 桶的数量
        int bucketCount = (maxValue - minValue) / bucketRange + 1;
        IntLinkedList[] buckets = new IntLinkedList[bucketCount];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new IntLinkedList();
        }
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - minValue) / bucketRange;
            buckets[index].add(array[i]);
        }
        // 对每个桶元素进行排序
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort();
        }
        // 将桶元素放回原数组
        int sortedIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            IntLinkedList bucket = buckets[i];
            for (IntLinkedList.Node node = bucket.first(); node != null; node = node.next) {
                array[sortedIndex++] = node.value;
            }
        }
    }

    /**
     * int型链表
     */
    static class IntLinkedList {
        private Node head = new Node();
        private Node tail = head;
        private int length = 0;

        public void add(int a) {
            Node node = new Node();
            node.value = a;
            tail.next = node;
            node.last = tail;
            tail = node;
            length++;
        }

        public Node first() {
            return head.next;
        }

        /**
         * 简单插入排序
         */
        public void sort() {
            for (Node node = first(); node != null; ) {
                Node nextNode = node.next;
                Node lastNode;
                for (lastNode = node.last; lastNode != head; lastNode = lastNode.last) {
                    if (lastNode.value <= node.value) {
                        node.last.next = node.next;
                        if (node.next != null) {
                            node.next.last = node.last;
                        }
                        node.next = lastNode.next;
                        if (lastNode.next != null) {
                            lastNode.next.last = node;
                        }
                        node.last = lastNode;
                        lastNode.next = node;
                        break;
                    }
                }
                if (lastNode == head) {
                    node.last.next = node.next;
                    if (node.next != null) {
                        node.next.last = node.last;
                    }
                    node.next = head.next;
                    if (head.next != null) {
                        head.next.last = node;
                    }
                    node.last = head;
                    head.next = node;
                }
                node = nextNode;
            }
        }

        public class Node {
            int value;
            Node next;
            Node last;
        }
    }

    /**
     * 菜鸟教程版，数组拷贝扩容，与2速度差不多
     * https://www.runoob.com/w3cnote/bucket-sort.html
     */
    public static int[] bucketSort3(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            InsertionSort.insertionSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
