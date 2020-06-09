package com.gtools.algorithm.gold;

import java.util.LinkedList;

public class No39 {
    public static void main(String[] args) {
        int[] nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        No39 no=new No39();
        System.out.println(no.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        LinkedList<Integer> stack = new LinkedList();

        for(int i: nums){
            if(stack.isEmpty())
                stack.push(i);
            else{
                //遇到不一样的两个数就消除
                if(stack.peek() != i) stack.pop();
                else stack.push(i);
            }

        }
        return stack.pop();

    }
}
