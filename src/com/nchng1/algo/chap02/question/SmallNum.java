package com.nchng1.algo.chap02.question;

import com.nchng1.algo.common.Comparator;

/**
 * User: Nucho George
 * Time: 2023/3/5 17:25
 * Description: 这是一场试炼！！！
 */
public class SmallNum {
    public static void main(String[] args) {
        int[] arr = Comparator.generateRandomArray(100000, 100);
        int[] copyArray = Comparator.copyArray(arr);
        int correctSmallNum = correctSmallNum(arr);
        int mergeSortSmallNum = countSmallNumWithMergeSort(copyArray);
        Comparator.printArray(arr);
        System.out.printf("数组正确的小河数值：%d", correctSmallNum);
        System.out.println();
        if (correctSmallNum == mergeSortSmallNum) {
            System.out.println("success");
        }
        else {
            System.out.println("shit");
        }
    }

    public static int countSmallNumWithMergeSort(int[] arr) {
        if (arr == null && arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = left + ((right - left) >> 1);
        int leftNum = process(arr, left, mid);
        int rightNum = process(arr, mid + 1, right);
        int mergeNum = merge(arr, left, mid, right);
        return leftNum + rightNum + mergeNum;
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int res = 0;
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;
    }

    public static int correctSmallNum(int[] arr) {
        if (arr == null && arr.length < 2) return 0;
        int total = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    total += arr[j];
                }
            }
        }
        return total;
    }
}
