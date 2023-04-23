package com.nchng1.algo.chap02.question;

import com.nchng1.algo.common.Comparator;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Nucho George
 * Time: 2023/3/5 18:15
 * Description: 这是一场试炼！！！
 */
public class ReverseNumPair {
    public static void main(String[] args) {
        int[] arr = Comparator.generateRandomArray(10, 100);
        Comparator.printArray(arr);
        int[] copyArray = Comparator.copyArray(arr);
        int correctRerveseNumPair = correctRerveseNumPair(arr);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        int mergeSort = printReverseNumPairWithMergeSort(copyArray);
        System.out.printf("数组正确的逆序对数量：%d",correctRerveseNumPair);
        System.out.println();
        if (mergeSort == correctRerveseNumPair) {
            System.out.println("success");
        }
        else {
            System.out.println("shit");
        }

    }

    public static int printReverseNumPairWithMergeSort(int[] arr) {
        if (arr == null && arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = ((right - left) >> 1) + left;
        return process(arr, left, mid) +
                process(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int count = 0;
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            count += arr[p1] <= arr[p2] ? 0 : (mid - p1 + 1);
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
        return count;
    }

    public static int correctRerveseNumPair(int[] arr) {
        if (arr == null && arr.length < 2) return 0;
        int count = 0;
        for (int i = arr.length - 1; i > 0; i--) {
//            System.out.printf("第%d位数对应的逆序对：\t", i + 1);
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    count++;
//                    System.out.printf("\t%d,%d\t", arr[j], arr[i]);
                }
            }
//            System.out.println();
        }
        return count;
    }
}
