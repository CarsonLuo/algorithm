package exercise.sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序 (冒泡排序的变种)
 */
public class CockTailSort {

    /*
       以 {2,3,4,5,6,7,8,1} 为例子
       使用 '冒泡排序' 的话会浪费几次循环
       如: 第一次 {2,3,4,5,6,7,1, #8} ......

       '鸡尾酒排序' 则像时钟一样, 右 -> 左, 右 -> 左
       第一轮
          右 -> 左 : {2,3,4,5,6,7,1, #8}
          左 -> 右 : {#1, 2,3,4,5,6,7, #8}
       以此类推
     */

    private static void sort(int[] nums){
        int mid = nums.length / 2;
        int i = 0;
        while (i != mid){
            // 右 -> 左
            for(int y = i; y < nums.length - i - 1; y++){
                if(nums[y] > nums[y + 1]){
                    swap(y, y + 1, nums);
                }
            }
            // 左 -> 右
            for(int y = nums.length - i - 1; y > i; y--){
                if(nums[y - 1] > nums[y]){
                    swap(y - 1, y, nums);
                }
            }
            i++;
        }
    }

    private static void betterSort(int[] nums){
        int mid = nums.length / 2;
        int i = 0;
        while (i != mid){
            boolean isSorted = true;
            for(int y = i; y < nums.length - i - 1; y++){
                if(nums[y] > nums[y + 1]){
                    swap(y, y + 1, nums);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
            for(int y = nums.length - i - 1; y > i; y--){
                if(nums[y - 1] > nums[y]){
                    swap(y - 1, y, nums);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
            i++;
        }
    }

    /**
     * 原始的冒泡排序，有序区的长度和排序的轮数是相等的。比如第一轮排序过后的有序区长度是1，第二轮排序过后的有序区长度是2 ......
     *
     * 要想优化，我们可以在每一轮排序的最后，记录下最后一次元素交换的位置，那个位置也就是无序数列的边界，再往后就是有序区了。
     *
     * 对于单向的冒泡排序，我们需要设置一个边界值，对于双向的鸡尾酒排序，我们需要设置两个边界值。
     */
    private static void betterSort2(int[] nums){
        int i = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int leftBoundIndex = 0;
        int rightBoundIndex = nums.length - 1;
        while (i != nums.length/2){
            boolean isSorted = true;
            for(int y = leftBoundIndex; y < rightBoundIndex; y++){
                if(nums[y] > nums[y + 1]){
                    swap(y, y + 1, nums);
                    isSorted = false;
                    rightIndex = y + 1;
                }
            }
            rightBoundIndex = rightIndex;
            if(isSorted){
                break;
            }
            for(int y = rightBoundIndex; y > leftBoundIndex; y--){
                if(nums[y - 1] > nums[y]){
                    swap(y - 1, y, nums);
                    isSorted = false;
                    leftIndex = y;
                }
            }
            leftBoundIndex = leftIndex;
            if(isSorted){
                break;
            }
            i++;
        }
    }

    private static void swap(int i, int y, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,6,7,8,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{2,3,4,5,6,7,8,1};
        betterSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{1,2,7,6,5,4,3,8,9};
        betterSort2(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
