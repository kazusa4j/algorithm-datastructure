package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/23 17:17
 * @Description: 快速排序-交换排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 9, 5, 6, 12, 7, 11, 8, 10, 11, 14};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        pivot(arr, start, end);

        int i = start;
        int j = end - 1;
        int pivotVal = arr[j];
        while (i < j) {
            if (arr[i] > pivotVal) {
                boolean flag = true;
                for (int k = j - 1; k > i; k--) {
                    if (arr[k] < pivotVal) {
                        swap(arr, i, k);
                        swap(arr, k, j);
                        j = k;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    swap(arr, i, j);
                    j = i;
                    break;
                }
            }
            i++;
        }
        sort(arr, start, j - 1);
        sort(arr, j + 1, end);

    }

    /**
     * 定位枢纽
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void pivot(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (mid != end - 1) {
            swap(arr, mid, end - 1);
        }
        mid = end - 1;
        if (arr[start] > arr[mid]) {
            swap(arr, start, mid);
        }
        if (arr[mid] > arr[end]) {
            swap(arr, mid, end);
            if (arr[start] > arr[end]) {
                swap(arr, start, mid);
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
    private static void swap(int[] arr, int a, int b)  {
        if(a==b){
            System.out.println("数组交换的值相同");
            return;
        }
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

}
