package com.fight.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Calpis
 * @Description 快速排序
 * @Date 2021/2/4 1:08
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Random().nextInt(100);
        }
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j- 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo...i-1], a[i], a[i+1...hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo]; // 切分元素
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < a[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j); // 将v=a[j]放入正确的位置
        return j; // a[lo...i-1] <= a[i] <= a[i+1...hi] 完成
    }

    /**
     * 交换a[i]与a[j]
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        if (a[i] != a[j]) {
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }

}
