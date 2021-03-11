package exercise.arrays;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 627 👎 0

// 难度 : 简单

import java.util.Arrays;

public class LeetCode66 {

    private int[] plusOne(int[] digits) {
        if(digits[digits.length - 1] != 9){
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        int add = 1;
        for(int i = digits.length - 1; 0 < i; i--){
            if(add == 1){
                if(digits[i] == 9) {
                    digits[i] = 0;
                    add = 1;
                }else {
                    digits[i] = digits[i] + 1;
                    add = 0;
                }
            }
        }
        if(add == 1){
            if(digits[0] == 9) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                newArr[1] = 0;
                for (int i = 1; i < digits.length - 1; i++) {
                    newArr[i + 1] = digits[i];
                }
                return newArr;
            }else {
                digits[0] = digits[0] + 1;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        LeetCode66 leetCode = new LeetCode66();
        int[] digits = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(leetCode.plusOne(digits)));
    }
}
