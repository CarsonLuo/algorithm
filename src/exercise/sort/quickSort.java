package exercise.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 属于 '交换排序' 的一种
 * 平均复杂度 : O(nlogn);  最差 : O(n^2)
 *
 * 啥时候最差?
 *   当你以'数组第一个为基准', 例如 {8,7,6,5,4,3,2,1} 时, 就是 n^2 的复杂度
 *   怎么解决呢? 随机取一个数作为'基准'
 *
 * 算法过程:
 *  (1). 选定'基准数'
 *  (2). 将数组中小于/大于 '基准数' 的数,放到基准数的左/右 (这里, 移动元素有 '挖坑法', '指针交换法')
 *  (3). 再将两边的数组再根据(1)(2)步骤
 *       假如经过(1)(2)步骤后, 基准数对应的index 为 'pivotIndex', 则两边为 [leftStart, pivotIndex - 1], [pivotIndex + 1, rightStart]
 *  TODO 写一下, '基准数' 不取数组的第一位为基准数
 */
public class quickSort {

    private static void sort(int[] arr, int leftStart, int rightStart){
        if(leftStart >= rightStart){
            return;
        }
        int pivotIndex = partition2(arr, leftStart, rightStart);
        sort(arr, leftStart, pivotIndex - 1);
        sort(arr,pivotIndex + 1, rightStart);
    }

    /**
     * 挖坑法
     * {4,7,6,5,3,2,8,1}
     *   {#1, 7,6,5,3,2,8, 1}
     *   {#1, 7,6,5,3,2,8, #7}
     *   {#1, #2, 6,5,3,2, #8, #7}
     *   {#1, #2, 6,5,3, #6, #8, #7}
     *   {#1, #2, #3, 5, 3, #6, #8, #7}
     *   {#1, #2, #3, #3, #5, #6, #8, #7}
     * 最后将 arr[left] = pivot
     * {#1, #2, #3, #4, #5, #6, #8, #7}
     */
    private static int partition(int[] arr, int leftStart, int rightStart){
        int pivot = arr[leftStart];
        int left = leftStart;
        int right = rightStart;
        while (left < right){
            while (left < right){
                if(arr[right] < pivot){
                    arr[left] = arr[right];
                    left++;
                    break;
                }
                right--;
            }
            while (left < right){
                if(arr[left] > pivot){
                    arr[right] = arr[left];
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[left] = pivot;
        return left;
    }

    /**
     * 指针交换法
     * {4,7,6,5,3,2,8,1}
     *   {4,#1,6,5,3,2,8,#7}
     *   {4,#1,#2,5,3,#6,#8,#7}
     *   {4,#1,#2,#3,#5,#6,#8,#7}
     * 最后将 left指针 和 '起始的指针' 数据交换
     * {#3,#1,#2,#4,#5,#6,#8,#7}
     *
     * 学习中的疑惑: 为啥先 right--, 再 left++, 最后才可以 left指针 和 '起始的指针' 数据交换
     * 如果先 left++, 再right--, 是不可以  left指针 和 '起始的指针' 数据交换的哦
     */
    private static int partition2(int[] arr, int leftStart, int rightStart){
        int pivot = arr[leftStart];
        int left = leftStart;
        int right = rightStart;
        while (left != right){
            while (arr[right] > pivot && left < right){
                right--;
            }
            while (arr[left] <= pivot && left < right){
                left++;
            }
            if(left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, leftStart);
        return left;
    }

    private static void swap(int[] arr, int i, int y){
        int tmp = arr[i];
        arr[i] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,7,6,5,3,2,8,1};
        int i = partition2(arr, 0, arr.length - 1);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }
}
