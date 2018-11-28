package com.wlb.forever.arithmetic;

import com.sun.tools.javac.api.ClientCodeWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: william
 * @Date: 18/11/27 11:11
 * @Description: 桶排序
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 11, 5, 6, 4, -3, 7, 25, 8, 10, 9, 22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        sort(arr, 10, 0, arr);
    }

    private static void sort(int[] arr, int bucketSize, int start, int[] totalArr) {
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
        List<Integer> intList;
        int bucketInterval = (maxVal - minVal) / bucketSize + 1;
        ArrayList<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            bucket.add(new ArrayList<>());
        }
        int j;
        for (int i = 0; i < arr.length; i++) {
            j = (arr[i] - minVal) / bucketInterval;
            bucket.get(j).add(arr[i]);
        }
        for (int i = 0; i < bucket.size(); i++) {
            intList = bucket.get(i);
            int size = intList.size();
            if (size == 1) {
                totalArr[start++] = intList.get(0);
            } else if (size > 1) {
                boolean allEqual = true;
                for (int l = 1; l < size; l++) {
                    if (!intList.get(l).equals(intList.get(l - 1))) {
                        allEqual=false;
                        break;
                    }
                }
                if(allEqual){
                    for (int l = 0; l < size; l++) {
                        totalArr[start++]=intList.get(0);
                    }
                    continue;
                }
                Integer[] integers = intList.toArray(new Integer[size]);
                int[] intTmp = new int[size];
                for (int l = 0; l < size; l++) {
                    intTmp[l] = integers[l].intValue();
                }
                sort(intTmp, size, start, totalArr);
                start+=size;
            }
        }
    }

}
