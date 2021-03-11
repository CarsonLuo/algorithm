package exercise.arrays;

import java.util.Arrays;

/**
 * @ClassName LeetCode189
 * @Author Carson
 * @Date 2020/12/9 12:08
 **/
public class LeetCode189 {

    /**
     * 移动一次: 将数组往右移一位, 再将最后的数据放在最前面
     * k次 * 移动一次
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        while (i < k){
            int last = nums[nums.length-1];
            for(int y = nums.length - 1; y > 0; y--){
                nums[y] = nums[y-1];
            }
            nums[0] = last;
            i++;
        }
    }

    public void rotate2(int[] nums, int k){
        int lastIndex = nums.length - 1;
        for(int i = 0; i < (nums.length+1)/2; i++){
            int var = nums[i];
            nums[i] = nums[lastIndex - i];
            nums[lastIndex - i] = var;
        }

        for(int i = 0; i < (k+1)/2; i ++){
            int var = nums[i];
            nums[i] = nums[k-1-i];
            nums[k-1-i] = var;
        }

        for(int i = k; i < (nums.length + k)/2; i++){
            int var = nums[i];
            nums[i] = nums[nums.length-1+k-i];
            nums[nums.length-1+k-i] = var;
        }
    }

    public static void main(String[] args) {
        LeetCode189 leetCode = new LeetCode189();
        int[] numArr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        leetCode.rotate2(numArr, 3);
        System.out.println(Arrays.toString(numArr));
    }
}
