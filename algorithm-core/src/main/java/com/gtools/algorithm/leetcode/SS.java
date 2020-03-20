package com.gtools.algorithm.leetcode;

import com.gtools.algorithm.link.Node;
import com.gtools.algorithm.point2offer.No13;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2020/3/11 22:59
 */
public class SS {
    public static void main(String[] args) {
        /*int[][] nums = new int[1][2];
        nums[0][0]=1;
        nums[0][1]=1;
        List<Integer> list=new ArrayList<>();

        System.out.println(findNumberIn2DArray(nums, 0));*/
        //System.out.println(fib(5));
        /*int[] res= printNumbers(3);
        System.out.println(res[res.length-1]);*/
        //mergeTwoLists(Node.createLink(1, 2, 3), Node.createLink(1, 3, 4));
        int[] nums={1,2,4,3,2,2,2};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(nums[(nums.length-1)/2]);

    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node node1 = l1;
        Node node2 = l2;
        Node result = new Node(-1);
        Node tmp = result;
        while (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                result.next = new Node(node1.val);
                result.next.next =new Node(node2.val);
                result = result.next.next;
                node1=node1.next;
                node2=node2.next;
            } else if (node1.val > node2.val) {
                result.next = new Node(node2.val);
                result = result.next;
                node2 = node2.next;
            } else if (node1.val < node2.val) {
                result.next = new Node(node1.val);
                result = result.next;
                node1 = node1.next;
            }
        }
        while (node1 != null) {
            result.next = node1;
            result = result.next;
            node1 = node1.next;
        }
        while (node2 != null) {
            result.next = node2;
            result = result.next;
            node2 = node2.next;
        }
        return tmp.next;
    }

    public static int[] printNumbers(int n) {
        int max = 0;
        int tmp = 9;

        for (int i = 1; i <= n; i++) {
            max = max + tmp;
            tmp = tmp * 10;
        }
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static int fib(int n) {
        int length = n + 1;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib2(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        int x = column - 1;
        int y = 0;
        while (true) {
            if (matrix[y][x] == target) return true;
            else if (matrix[y][x] > target) x--;
            else y++;
            if (x < 0) break;
            if (y > row - 1) break;
        }
        return false;
    }
}
