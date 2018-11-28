package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/27 10:50
 * @Description: 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 11, 5, 6, 4, -3, 7, 2, 8, 10, 9, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int maxVal = arr[0];
        int minVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
                continue;
            }
            if (minVal > arr[i]) {
                minVal = arr[i];
            }
        }
        int[] tmpArr = new int[maxVal - minVal + 1];
        Arrays.fill(tmpArr, 0);
        int bias = 0 - minVal;
        for (int i = 0; i < arr.length; i++) {
            tmpArr[arr[i] + bias]++;
        }
        int j = 0;
        for (int i = 0; i < tmpArr.length; i++) {
            while (tmpArr[i] > 0) {
                arr[j] = minVal + i;
                tmpArr[i]--;
                j++;
            }
        }
    }

}
