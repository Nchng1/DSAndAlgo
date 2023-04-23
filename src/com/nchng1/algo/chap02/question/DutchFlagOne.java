package com.nchng1.algo.chap02.question;

import com.nchng1.algo.common.Comparator;

/**
 * User: Nucho George
 * Time: 2023/3/5 23:40
 * Description: 这是一场试炼！！！
 */
public class DutchFlagOne {
    public static void main(String[] args) {
        int[] arr = Comparator.generateRandomArray(100, 100);
        Comparator.printArray(arr);
        int num = arr[(int) (Math.random() * arr.length)];
        System.out.println("num数值为：" + num);
        int left = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                Comparator.swap(arr, i, left + 1);
                left++;
            }
        }
        Comparator.printArray(arr);
    }
}
