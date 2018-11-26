package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/23 11:19
 * @Description: 堆排序-选择排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 11, 5, 6, 4, 7, 2, 8, 10, 9, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //将堆顶移至最后，调整大顶堆
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 调整大顶堆
     *
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        //左节点和右节点的位置
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (right < length && arr[left] < arr[right]) {
            if (arr[right] > arr[i]) {
                swap(arr, i, right);
                adjustHeap(arr, right, length);
            }
            return;
        }
        if (left < length && arr[left] > arr[i]) {
            swap(arr, i, left);
            adjustHeap(arr, left, length);
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
