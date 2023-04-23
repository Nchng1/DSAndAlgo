package com.nchng1.algo.chap01;

import com.nchng1.algo.common.CommonSort;
import com.nchng1.algo.common.Comparator;

public class InsertionSort implements CommonSort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                Comparator.swap(arr, j - 1, j);
            }
        }
    }
}
