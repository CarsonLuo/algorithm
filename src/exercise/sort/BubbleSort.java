package exercise.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    /*
        以 '从小打大', arr = {4,6,8,3,2,5}
        第一轮, 将最大的放到最后面 ->  4,6,3,2,5,#8
        由于最大的固定了, 为 #8; 则固定最后倒数第二位的
        第二轮, -> 4,3,2,5,#6,#8
        以此类推;
        以下算法, 返回 '从小到大' 排序的数组
     */
    private static void sort(int[] nums){
        for(int length = nums.length; length > 0; length--) {
            for (int i = 1; i < length; i++) {
                if (nums[i - 1] > nums[i]) {
                    swap(i - 1, i, nums);
                }
            }
        }
    }

    /*
        [优化第一版]
        以 {1,2,3,4,9,8,7,6,5} 为例
        到了第 4 轮结束时 -> {1,2,3,4,5, #6, #7, #8, #9}
        这时已经有序了
     */
    private static void betterSort(int[] nums){
        boolean isSorted;
        for(int length = nums.length; length > 0; length--) {
            isSorted = true;
            for (int i = 1; i < length; i++) {
                if (nums[i - 1] > nums[i]) {
                    swap(i - 1, i, nums);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    /*
      [优化第二版]
      以 {4,3,2,1,5,6,7,8} 为例
      第一轮: {3,2,1,4,5,6,7, #8}
      右边只固定了一个 #8, 其实右边有5个数都是有序的了, 如果不优化的话, 会白白比较很多次
      如何避免这种情况呢？
      我们可以在每一轮排序的最后，记录下最后一次元素交换的位置，那个位置也就是无序数列的边界，再往后就是有序区了。
     */
    private static void betterSort2(int[] nums){
        boolean isSorted;
        int lastSwapIndex = 0;
        for(int length = nums.length; length > 0; length = lastSwapIndex) {
            isSorted = true;
            for (int i = 1; i < length; i++) {
                if (nums[i - 1] > nums[i]) {
                    swap(i - 1, i, nums);
                    isSorted = false;
                    lastSwapIndex = i;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    private static void swap(int i, int y, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,1,8,3,7,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{1,2,3,4,8,7,6,5};
        betterSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{4,3,2,1,5,6,7,8};
        betterSort2(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}