package com.nchng1.algo.chap01;

import com.nchng1.algo.common.CommonSort;
import com.nchng1.algo.common.Comparator;

public class SelectionSort implements CommonSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
           Comparator.swap(arr, i, minIndex);
        }
    }
}
