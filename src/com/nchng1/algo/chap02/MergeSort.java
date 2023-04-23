package com.nchng1.algo.chap02;

import com.nchng1.algo.common.CommonSort;

/**
 * User: Nucho George
 * Time: 2023/3/4 2:17
 * Description: 这是一场试炼！！！
 */
public class MergeSort implements CommonSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int left = 0;
        int right = arr.length - 1;
        process(arr, left, right);
    }

    public void process(int[] arr, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr,int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return;
    }



}
