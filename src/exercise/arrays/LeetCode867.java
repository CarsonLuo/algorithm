package exercise.arrays;

import java.util.Arrays;

/*
给定一个矩阵 A， 返回 A 的转置矩阵。

矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]

输入：[[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]

1 <= A.length <= 1000
1 <= A[0].length <= 1000
 */
public class LeetCode867 {

    public static int[][] transpose(int[][] A) {
        int yLength = A[0].length;
        int[][] t = new int[A[0].length][A.length];
        for(int i = 0; i < A.length; i++){
            for(int y = 0; y < yLength; y++){
                t[y][i] = A[i][y];
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};
        int[][] b = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Arrays.deepToString(transpose(a)));

        System.out.println(Arrays.deepToString(transpose(b)));
    }
}
