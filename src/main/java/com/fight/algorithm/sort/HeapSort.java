package com.fight.algorithm.sort;

import java.util.Arrays;

import static com.fight.algorithm.common.CommonUtils.generateArr;
import static com.fight.algorithm.common.CommonUtils.swap;

/**
 * @Author Calpis
 * @Description 堆排序
 * @Date 2021/2/5 15:33
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = generateArr();
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

}
