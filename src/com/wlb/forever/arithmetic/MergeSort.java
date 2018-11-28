package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/23 15:53
 * @Description: 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 9, 5, 6, 12, -2,7, 11, 8, 10, 11, 14};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int start, int end, int[] tmpArr) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(arr, start, mid, tmpArr);
        sort(arr, mid + 1, end, tmpArr);
        merge(arr, start, mid, end, tmpArr);
    }


    private static void merge(int[] arr, int start, int mid, int end, int[] tmpArr) {
        int i = start;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmpArr[t++] = arr[i++];
            } else {
                tmpArr[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmpArr[t++] = arr[i++];
        }
        while (j <= end) {
            tmpArr[t++] = arr[j++];
        }
        t = 0;
        while (start <= end) {
            arr[start++] = tmpArr[t++];
        }
    }

}
