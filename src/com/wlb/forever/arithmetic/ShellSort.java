package com.wlb.forever.arithmetic;

import java.util.Arrays;

/**
 * @author: william
 * @Date: 18/11/22 15:20
 * @Description: 希尔排序-插入排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {22,1, 4, 2, 3, 1, 5, 6, 4, -3,7, 2, 8, 10, 11};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int d=arr.length;
        int n=arr.length;
        int shellNum=2;
        while (d>=shellNum){
            d=d/shellNum;
            for (int i=d;i<n;i++){
                int tmp=arr[i];
                int j=i;
                while (j>=d){
                    if(arr[j-d]>tmp){
                        arr[j]=arr[j-d];
                        j-=d;
                    }else {
                        break;
                    }
                }
                if(j!=i){
                    arr[j]=tmp;
                }
            }
        }
    }

}
