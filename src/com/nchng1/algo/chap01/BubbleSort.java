package com.nchng1.algo.chap01;

import com.nchng1.algo.common.CommonSort;
import com.nchng1.algo.common.Comparator;

public class BubbleSort implements CommonSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Comparator.swap(arr, j, j + 1);
                }
            }
        }
    }
}
