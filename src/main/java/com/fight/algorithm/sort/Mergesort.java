package com.fight.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Calpis
 * @Description 归并排序
 * @Date 2021/2/4 1:16
 */
public class Mergesort {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Random().nextInt(100);
        }
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并算法
     *
     * @param arr
     * @param lo
     * @param hi
     */
    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    /**
     * 将a[lo...mid]和a[mid+1...hi]归并
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] arr, int lo, int mid, int hi) {
        // 左指针与右指针
        int i = lo, j = mid + 1;
        // 辅助数组
        int[] aux = new int[arr.length];

        // 将a[lo...hi]复制到aux[lo...hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        // 归并回到a[lo...hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) { // 左半边用尽(取右半边的元素)
                arr[k] = aux[j++];
            } else if (j > hi) { // 右半边用尽(取左半边的元素)
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) { // 右半边的当前元素小于左半边的当前元素(取右半边的元素)
                arr[k] = aux[j++];
            } else { // 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
                arr[k] = aux[i++];
            }
        }
    }
}
