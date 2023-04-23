package com.nchng1.algo.chap02;

import com.nchng1.algo.common.CommonSort;
import com.nchng1.algo.common.Comparator;

/**
 * User: Nucho George
 * Time: 2023/3/6 1:15
 * Description: 这是一场试炼！！！
 */
public class QuickSort implements CommonSort {
    @Override
    public void sort(int[] arr) {
        if (arr == null && arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public void process(int[] arr, int left, int right) {
        if (left >= right) return;
        int[] bound = partition(arr, (int) (Math.random() * (right - left + 1) + left), right);
        process(arr, left, bound[0]);
        process(arr, bound[1], right);
    }

    public int[] partition(int[] arr, int left, int right) {
        int num = arr[right];
        int leftZone = -1;
        int rightZone = right;
        int i = 0;
        while (i < rightZone) {
            if (arr[i] < num) {
                Comparator.swap(arr, ++leftZone, i++);
            }
            else if (arr[i] > num) {
                Comparator.swap(arr, i, --rightZone);
            }
            else {
                i++;
            }
        }
        Comparator.swap(arr, right, rightZone);
        return new int[]{leftZone, rightZone};
    }
}
