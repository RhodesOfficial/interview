package com.fight.algorithm.common;

import java.util.Random;

/**
 * @Author Calpis
 * @Description 算法公共工具类
 * @Date 2021/2/4 16:37
 */
public class CommonUtils {

    /**
     * 生成随机数组
     *
     * @return
     */
    public static int[] generateArr() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

    /**
     * 交换a[i]与a[j]
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {
        if (a[i] != a[j]) {
            a[i] = a[i] ^ a[j];
            a[j] = a[i] ^ a[j];
            a[i] = a[i] ^ a[j];
        }
    }
}
