package com.fight.algorithm.sort;

import java.util.Arrays;

import static com.fight.algorithm.common.CommonUtils.generateArr;
import static com.fight.algorithm.common.CommonUtils.swap;

/**
 * @Author Calpis
 * @Description 希尔排序
 * @Date 2021/2/5 13:57
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = generateArr();
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...之中
                for (int j = i; j >= h && a[j] < a[j - h]; j-= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
