package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/23 16:54
 * @Description: 冒泡排序-交换排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 11, 5, 6, 4, 7, 2, 8, 10, 9, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        boolean flag;
        for (int i = 0; i < n; ++i) {
            flag = true;
            for (int k = 1; k < n - i; k++) {
                if (arr[k] < arr[k - 1]) {
                    swap(arr, k, k - 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
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
