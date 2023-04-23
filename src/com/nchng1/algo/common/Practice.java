package com.nchng1.algo.common;


import com.nchng1.algo.chap01.InsertionSort;
import com.nchng1.algo.chap02.MergeSort;
import com.nchng1.algo.chap02.QuickSort;
import com.nchng1.algo.chap03.HeapSort;
import com.nchng1.algo.common.Comparator;

public class Practice {
    public static void main(String[] args) {
        Comparator.compare(10,50000, 100, new HeapSort());
    }

    public static void find2Nums(int[] arr) {
        if (arr == null) return;
        int eor = 0;
        for (int num : arr) {
            eor ^= num; // eor = a ^ b
        }
        int rightOne = eor & ((~eor) + 1); // 最右侧的一
        int oneNum = 0;
        for (int num : arr) {
            if ((num & rightOne) == 0) {
                oneNum ^= num;
            }
        }
        System.out.println(oneNum + "\t" + (eor ^ oneNum));
    }

}
