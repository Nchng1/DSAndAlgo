package com.nchng1.algo.chap03;

import com.nchng1.algo.common.CommonSort;
import com.nchng1.algo.common.Comparator;

public class HeapSort implements CommonSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }
        int heapSize = arr.length;
        Comparator.swap(arr, 0, --heapSize);
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            Comparator.swap(arr, 0, --heapSize);
        }
    }

    // arr[index]刚来的数，往上找父节点比大小
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Comparator.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1; // 左孩子的下标
        // 存在左孩子时
        while (left < heapSize) {
            // 两个孩子比大小，大的把下标赋值给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1 : left;

            // 父子之间比大小，大的赋值下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }

            Comparator.swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1; // 左孩子的下标
        }

    }
}
