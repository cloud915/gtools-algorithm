package com.gtools.algorithm.sort.heap;

import java.util.Arrays;

/**
 * @Description 将一个数组，转换为二叉树的表示结构；但不引入Node类
 * @Author ghy
 * @Date 2020/1/16 18:18
 */
public class Two_ArrayToTreeStruct {
    public static void main(String[] args) {

        int[] nums = {9, 8, 1, 3, 2, 7, 6, 11, 15, 20, 18};
        System.out.println(Arrays.toString(nums));

        /**
         * 主要先理解数组中为何要跳跃索引方式获取值
         * 首先，要将这个数组 理解为一个tree
         * 1、有一个默认的思路， 索引i的位置，是一个节点，它的左右节点是 i*2+1和i*2+2
         *    当i=0时，左节点索引是 0*2+1=1,右节点索引是 0*2+2=2
         *    当i=1时，左节点索引是 1*2+1=3,右节点索引是 1*2+2=4  注意，这里i=1位置的元素，是作为i=0的左节点的
         *    当i=2时，左节点索引是 2*2+1=5,右节点索引是 2*2+2=6  注意，这里i=2位置的元素，是作为i=0的右节点的
         * 2、根据上面的枚举逻辑，构建的这个虚拟tree，根节点就是i=0的元素，后面的元素都作为下级元素存在
         * 并且，由于二叉树是左右两个子节点，那么在我们遍历 数组 时，会存在m*2+n的关系，
         * 相当于2倍位置的元素，已经被作为子节点处理了；也就是，只需要遍历数组一半的元素，就能构建完成这颗虚拟tree
         * 不信，看一下上面例子，当i=2时，已经操作了index=6位置的元素（完成了整个数组的遍历）
         */

        for (int i = 0; i < nums.length / 2 - 1; i++) {
            System.out.println(String.format("节点%s ，左节点是%s 右节点是%s", nums[i], nums[i * 2 + 1], nums[i * 2 + 2]));
        }
        //运行上面的代码，可发现，nums.length/2-1 并不是完全的数组的一半，导致只遍历到元素15的位置，而元素20,18还没处理
        // 这也是接下来的问题，在com/gtools/algorithm/sort/heap/One_ArrayToTreeStruct.java:25 位置，有以下处理

        int index = nums.length / 2 - 1;
        System.out.print(String.format("节点%s ，左节点是%s", nums[index], nums[index * 2 + 1]));

        if (nums.length % 2 == 1) {
            System.out.println(String.format(" 右节点是%s", nums[index * 2 + 2]));
        }

        /**
         * 最后几行的含义：
         * 取index=nums.length/2-1，是由于前面的for循环，没有遍历到这个节点，因为有可能导致 i*2+2 超过数组长度
         * 也就是，数组长度为奇数还是偶数 的问题，是i*2+1与i*2+2与 中间索引的关系：
         *      长度=奇数，中位数*2+1 是倒数第二个值，中位数*2+1是倒数第一个值
         *      长度=偶数，中位数*2+1 是倒数第一个值，中位数*2+2超出数组长度
         *
         * 因此，代码单独处理这种两种情况，反映到tree结构上，就是tree的节点，是否有右子树
         */


    }
}
