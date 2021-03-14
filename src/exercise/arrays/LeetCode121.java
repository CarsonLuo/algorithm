package exercise.arrays;

/*
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

 注意：你不能在买入股票前卖出股票。

 示例 1:
 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

 示例 2:
 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 Related Topics 数组 动态规划
 👍 1330 👎 0
*/
public class LeetCode121 {

    /*
     * 1. '买入时间' 在 '卖出时间'之前
     * 2. 在 '卖出时间'之前的 小于卖出时间价格 && 最小值
     */

    /**
     * 暴力破解
     * 时间: (n * (n-1)) / 2 -> O(n^2)
     * 空间: 1 (只用了一个常量)
     */
    private static int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int y = i + 1; y < prices.length; y ++){
                if(prices[y] > prices[i]) {
                    max = Math.max(max, prices[y] - prices[i]);
                }
            }
        }
        return max;
    }

    /**
     * 一次遍历
     * 时间: O(n)
     * 空间: O(1): 常数个变量
     * 思想: 本质思路是动态规划
     * 即第i天的最大差值 = max(前i-1天的最大差值， 第i天的抛出价格-前i-1天的最小买入价格)
     * 所以只需要遍历1次数组 更新 最小买入价格min_val 和 最大差值max_val即可
     */
    private static int maxProfit2(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int max = 0;
        int minValue = prices[0];
        for (int price : prices) {
            if(price < minValue){
                minValue = price;
            }else {
                max = Math.max(max, price - minValue);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{7,1,5,3,6,4};
        // int[] input = new int[]{7,6,5,4,3,2,1};
        // int[] input = new int[]{1,2,3,4,5,6,7};
        System.out.println(maxProfit2(input));
    }
}
