package com.fight.algorithm.sort;

import java.util.Arrays;

import static com.fight.algorithm.common.CommonUtils.generateArr;

/**
 * @Author Calpis
 * @Description 归并排序
 * @Date 2021/2/4 1:16
 */
public class Mergesort {

    /**
     * 辅助数组
     */
    private static int[] aux;

    public static void main(String[] args) {
        int[] arr = generateArr();
        aux = new int[100];
        sort(arr, 0, arr.length - 1);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序(自底向上)
     *
     * @param arr
     * @param lo
     * @param hi
     */
    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 分为a[lo...mid]和a[mid+1...hi]
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    /**
     * 归并排序(自顶向下)
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        // sz:子数组大小
        for (int sz = 1; sz < arr.length; sz *= 2) {
            // lo:子数组索引
            for (int lo = 0; lo < arr.length - sz; lo += (sz * 2)) {
                merge(arr, lo, lo + sz - 1, Math.min(lo + (sz * 2) - 1, arr.length - 1));
            }
        }
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
