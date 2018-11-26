package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/22 12:17
 * @Description: 插入排序-插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 5, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            int tmp = arr[i];
            while (j > 0) {
                if (tmp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                } else {
                    break;
                }
            }
            arr[j] = tmp;
        }
    }

}
