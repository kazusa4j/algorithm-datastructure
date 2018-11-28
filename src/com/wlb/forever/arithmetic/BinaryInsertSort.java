package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/22 14:45
 * @Description: 二分法排序 -插入排序
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] arr = {1,4, 2, 3, 1, -3,5, 6, 4, 7,2, 8, 10, 11, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int left = 0;
            int right = i - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i; j > left; j--) {
                arr[j] = arr[j - 1];
            }
            if (left != i) {
                arr[left] = temp;
            }
        }
    }

}
