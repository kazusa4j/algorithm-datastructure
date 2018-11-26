package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/23 17:32
 * @Description: 简单选择排序-选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 11, 5, 6, 4, 7, 2, 8, 10, 9, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int tmp = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[tmp] > arr[j]) {
                    tmp = j;
                }
            }
            if (tmp != i) {
                swap(arr, i, tmp);
            }
        }
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
}
