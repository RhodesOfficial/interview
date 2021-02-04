package com.fight.algorithm.sort;

import java.util.Arrays;

import static com.fight.algorithm.common.CommonUtils.generateArr;
import static com.fight.algorithm.common.CommonUtils.swap;

/**
 * @Author Calpis
 * @Description 插入排序
 * @Date 2021/2/4 16:44
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = generateArr();
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }
}
